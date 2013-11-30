1. org.apache.catalina.connector.Connector.parseBodyMethods

逗号分隔的http请求方法名，如POST，必需是大写。
此参数表示:请求行中什么样的http请求方法名才能解析请求体，
默认只有POST方法能解析请求体。
用在org.apache.catalina.connector.Request.parseParameters()这个方法中，
这个方法当调用Request.getParameter时会触发

但是不能包含TRACE，否则会抛:
throw new IllegalArgumentException(sm.getString("coyoteConnector.parseBodyMethodNoTrace"));
java.lang.IllegalArgumentException: TRACE method MUST NOT include an entity (see RFC 2616 Section 9.6),
但是在IntrospectionUtils.setProperty(Object, String, String, boolean) line: 390	
被忽略了同，启用if (log.isDebugEnabled())后才能看得到


2. useBodyEncodingForURI和URIEncoding参数
如果useBodyEncodingForURI设为true，那么URIEncoding参数无论设置什么都是不会起作用的
如果useBodyEncodingForURI设为true，则:
1) 看看有没有Content-Type头，取出里面的charset，
2) 看看用户是否调用过request.setCharacterEncoding(...);
如果1和2都设过，那么取2的，当从1和2能取到字符编码时就用他们指定的，
否则用ISO-8859-1

如果useBodyEncodingForURI设为false，就用URIEncoding参数来解析uri。

