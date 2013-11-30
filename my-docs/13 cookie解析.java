FWD_SLASH 是forward slash 正斜线(/)，forward代表向前

backlash 反斜线(\) back代表向后

相关rfc:
rfc2109: cookie v0
rfc2965: cookie v1


cookie v0:
   The syntax for the header is:

   cookie          =       "Cookie:" cookie-version
                           1*((";" | ",") cookie-value)
   cookie-value    =       NAME "=" VALUE [";" path] [";" domain]
   cookie-version  =       "$Version" "=" value
   NAME            =       attr
   VALUE           =       value
   path            =       "$Path" "=" value
   domain          =       "$Domain" "=" value


cookie v1:

   The syntax for the header is:

	cookie          =  "Cookie:" cookie-version 1*((";" | ",") cookie-value)
	cookie-value    =  NAME "=" VALUE [";" path] [";" domain] [";" port]
	cookie-version  =  "$Version" "=" value
	NAME            =  attr
	VALUE           =  value
	path            =  "$Path" "=" value
	domain          =  "$Domain" "=" value
	port            =  "$Port" [ "=" <"> value <"> ]


//并不是一个ServerCookie对应一个"Cookie: xxx"，而是对应其中的cookie-value
	protected final void processCookieHeader(byte bytes[], int off, int len) {
		if (len <= 0 || bytes == null) {
			return;
		}
		int end = off + len;
		int pos = off;
		int nameStart = 0;
		int nameEnd = 0;
		int valueStart = 0;
		int valueEnd = 0;
		int version = 0;
		ServerCookie sc = null;
		boolean isSpecial;
		boolean isQuoted;

		while (pos < end) {
			isSpecial = false;
			isQuoted = false;

			//1. 如果是http分隔符并且设置了“不允许http分隔符出现在vo版本的cookie中”，那么跳过此字符
			//2. 跳过vo分隔符
			//3. 跳过空白

			// Skip whitespace and non-token characters (separators)
			while (pos < end
					&& (CookieSupport.isHttpSeparator((char) bytes[pos]) && !CookieSupport.ALLOW_HTTP_SEPARATORS_IN_V0
							|| CookieSupport.isV0Separator((char) bytes[pos]) || isWhiteSpace(bytes[pos]))) {
				pos++;
			}

			if (pos >= end) {
				return;
			}

			//例如$Version、$Path等

			// Detect Special cookies
			if (bytes[pos] == '$') {
				isSpecial = true;
				pos++;
			}

			// Get the cookie/attribute name. This must be a token
			valueEnd = valueStart = nameStart = pos;
			pos = nameEnd = getTokenEndPosition(bytes, pos, end, version, true);

			    private static final int getTokenEndPosition(byte bytes[], int off, int end,
						int version, boolean isName){
					int pos = off;
					//1. 如果当前字符不是http分隔符，那么继续往前
					//2. 如果是v0，并且设置了“允许http分隔符出现在vo版本的cookie中”，
					//   并且当前字符不是等号，并且不是v0分隔符，那么继续往前
					//3. 如果不是cookie名称，并且当前字符是等号，并且设置了“允许等号出现在cookie值中”，那么继续往前
					while (pos < end &&
							(!CookieSupport.isHttpSeparator((char)bytes[pos]) ||
							 version == 0 &&
									CookieSupport.ALLOW_HTTP_SEPARATORS_IN_V0 &&
									bytes[pos] != '=' &&
									!CookieSupport.isV0Separator((char)bytes[pos]) ||
							 !isName && bytes[pos] == '=' &&
									 CookieSupport.ALLOW_EQUALS_IN_VALUE)) {
						pos++;
					}

					if (pos > end) {
						return end;
					}
					return pos;
				}

			// Skip whitespace
			while (pos < end && isWhiteSpace(bytes[pos])) {
				pos++;
			}

			// Check for an '=' -- This could also be a name-only
			// cookie at the end of the cookie header, so if we
			// are past the end of the header, but we have a name
			// skip to the name-only part.
			if (pos < (end - 1) && bytes[pos] == '=') {

				// Skip whitespace
				do {
					pos++;
				} while (pos < end && isWhiteSpace(bytes[pos]));

				if (pos >= end) {
					return;
				}

				// Determine what type of value this is, quoted value,
				// token, name-only with an '=', or other (bad)
				switch (bytes[pos]) {
				case '"': // Quoted Value
					isQuoted = true;
					valueStart = pos + 1; // strip "
					// getQuotedValue returns the position before
					// at the last quote. This must be dealt with
					// when the bytes are copied into the cookie
					valueEnd = getQuotedValueEndPosition(bytes, valueStart, end);
					    private static final int getQuotedValueEndPosition(byte bytes[], int off, int end){
							int pos = off;
							while (pos < end) {
								if (bytes[pos] == '"') {
									return pos;
								} else if (bytes[pos] == '\\' && pos < (end - 1)) {
									pos+=2;
								} else {
									pos++;
								}
							}
							// Error, we have reached the end of the header w/o a end quote
							return end;
						}
					// We need pos to advance
					pos = valueEnd;
					// Handles cases where the quoted value is
					// unterminated and at the end of the header,
					// e.g. [myname="value]
					if (pos >= end) {
						return;
					}
					break;
				case ';':
				case ',':
					// Name-only cookie with an '=' after the name token
					// This may not be RFC compliant
					valueStart = valueEnd = -1;
					// The position is OK (On a delimiter)
					break;
				default:
					if (version == 0 && !CookieSupport.isV0Separator((char) bytes[pos])
							&& CookieSupport.ALLOW_HTTP_SEPARATORS_IN_V0 || !CookieSupport.isHttpSeparator((char) bytes[pos])
							|| bytes[pos] == '=' && CookieSupport.ALLOW_EQUALS_IN_VALUE) {
						// Token
						valueStart = pos;
						// getToken returns the position at the delimiter
						// or other non-token character
						valueEnd = getTokenEndPosition(bytes, valueStart, end, version, false);
						// We need pos to advance
						pos = valueEnd;
					} else {
						// INVALID COOKIE, advance to next delimiter
						// The starting character of the cookie value was
						// not valid.
						UserDataHelper.Mode logMode = userDataLog.getNextMode();
						if (logMode != null) {
							String message = sm.getString("cookies.invalidCookieToken");
							switch (logMode) {
							case INFO_THEN_DEBUG:
								message += sm.getString("cookies.fallToDebug");
								//$FALL-THROUGH$
							case INFO:
								log.info(message);
								break;
							case DEBUG:
								log.debug(message);
							}
						}
						while (pos < end && bytes[pos] != ';' && bytes[pos] != ',') {
							pos++;
						}
						pos++;
						// Make sure no special avpairs can be attributed to
						// the previous cookie by setting the current cookie
						// to null
						sc = null;
						continue;
					}
				}
			} else {
				// Name only cookie
				valueStart = valueEnd = -1;
				pos = nameEnd;

			}

			// We should have an avpair or name-only cookie at this
			// point. Perform some basic checks to make sure we are
			// in a good state.

			// Skip whitespace
			while (pos < end && isWhiteSpace(bytes[pos])) {
				pos++;
			}

			// Make sure that after the cookie we have a separator. This
			// is only important if this is not the last cookie pair
			while (pos < end && bytes[pos] != ';' && bytes[pos] != ',') {
				pos++;
			}

			pos++;

			// All checks passed. Add the cookie, start with the
			// special avpairs first
			if (isSpecial) {
				isSpecial = false;
				// $Version must be the first avpair in the cookie header
				// (sc must be null)
				if (equals("Version", bytes, nameStart, nameEnd) && sc == null) {
					// Set version
					if (bytes[valueStart] == '1' && valueEnd == (valueStart + 1)) {
						version = 1;
					} else {
						// unknown version (Versioning is not very strict)
					}
					continue;
				}

				// We need an active cookie for Path/Port/etc.
				if (sc == null) {
					continue;
				}

				// Domain is more common, so it goes first
				if (equals("Domain", bytes, nameStart, nameEnd)) {
					sc.getDomain().setBytes(bytes, valueStart, valueEnd - valueStart);
					continue;
				}

				if (equals("Path", bytes, nameStart, nameEnd)) {
					sc.getPath().setBytes(bytes, valueStart, valueEnd - valueStart);
					continue;
				}

				// v2 cookie attributes - skip them
				if (equals("Port", bytes, nameStart, nameEnd)) {
					continue;
				}
				if (equals("CommentURL", bytes, nameStart, nameEnd)) {
					continue;
				}

				// Unknown cookie, complain
				UserDataHelper.Mode logMode = userDataLog.getNextMode();
				if (logMode != null) {
					String message = sm.getString("cookies.invalidSpecial");
					switch (logMode) {
					case INFO_THEN_DEBUG:
						message += sm.getString("cookies.fallToDebug");
						//$FALL-THROUGH$
					case INFO:
						log.info(message);
						break;
					case DEBUG:
						log.debug(message);
					}
				}
			} else { // Normal Cookie
				if (valueStart == -1 && !CookieSupport.ALLOW_NAME_ONLY) {
					// Skip name only cookies if not supported
					continue;
				}

				sc = addCookie();
				sc.setVersion(version);
				sc.getName().setBytes(bytes, nameStart, nameEnd - nameStart);

				if (valueStart != -1) { // Normal AVPair
					sc.getValue().setBytes(bytes, valueStart, valueEnd - valueStart);
					if (isQuoted) {
						// We know this is a byte value so this is safe
						unescapeDoubleQuotes(sc.getValue().getByteChunk());
							//去掉"\"号,也就是把(\\")换成(")
						    private static void unescapeDoubleQuotes(ByteChunk bc) {

								if (bc == null || bc.getLength() == 0 || bc.indexOf('"', 0) == -1) {
									return;
								}

								int src = bc.getStart();
								int end = bc.getEnd();
								int dest = src;
								byte[] buffer = bc.getBuffer();

								while (src < end) {
									if (buffer[src] == '\\' && src < end && buffer[src+1]  == '"') {
										src++;
									}
									buffer[dest] = buffer[src];
									dest ++;
									src ++;
								}
								bc.setEnd(dest);
							}
					}
				} else {
					// Name Only
					sc.getValue().setString("");
				}
				continue;
			}
		}
	}

	/**
	 * Given the starting position of a token, this gets the end of the
	 * token, with no separator characters in between.
	 * JVK
	 */