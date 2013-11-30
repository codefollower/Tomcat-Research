web.xml

	<login-config>
      <auth-method>DIGEST</auth-method>
      <realm-name>Example Form-Based Authentication Area</realm-name>
    </login-config>



GET /examples/jsp/security/protected/ HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16
Accept: application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Encoding: gzip,deflate,sdch
Accept-Language: en-US,en;q=0.8
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.3


HTTP/1.1 401 Unauthorized
Server: Apache-Coyote/1.1
Cache-Control: private
Expires: Thu, 01 Jan 1970 08:00:00 CST
WWW-Authenticate: Digest realm="Example Form-Based Authentication Area", qop="auth", nonce="1312210283109:d3364423d1b00490a173737b81cf8ec3", opaque="FF67E330005AC64D3436BCD21EFFDDFC"
Content-Type: text/html;charset=utf-8
Content-Length: 960
Date: Mon, 01 Aug 2011 14:51:23 GMT

<html><head><title>Apache Tomcat/@VERSION@ - Error report</title><style><!--H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;} H2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;} H3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;} BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;} B {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;} P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}A {color : black;}A.name {color : black;}HR {color : #525D76;}--></style> </head><body><h1>HTTP Status 401 - </h1><HR size="1" noshade="noshade"><p><b>type</b> Status report</p><p><b>message</b> <u></u></p><p><b>description</b> <u>This request requires HTTP authentication ().</u></p><HR size="1" noshade="noshade"><h3>Apache Tomcat/@VERSION@</h3></body></html>
GET /examples/jsp/security/protected/ HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
Authorization: Digest username="tomcat", realm="Example Form-Based Authentication Area", nonce="1312210283109:d3364423d1b00490a173737b81cf8ec3", uri="/examples/jsp/security/protected/", response="6697b253a634905e6180d99554297fac", opaque="FF67E330005AC64D3436BCD21EFFDDFC", qop=auth, nc=00000001, cnonce="7704e39de4a1a8c8"
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16
Accept: application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Encoding: gzip,deflate,sdch
Accept-Language: en-US,en;q=0.8
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.3


HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Cache-Control: private
Expires: Thu, 01 Jan 1970 08:00:00 CST
Set-Cookie: JSESSIONID=542178B14B48DD75216C0A7A6EF127A6; Path=/examples/; HttpOnly
Content-Type: text/html;charset=ISO-8859-1
Content-Length: 812
Date: Mon, 01 Aug 2011 14:58:37 GMT



GET /examples/jsp/security/protected/ HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
Cache-Control: max-age=0
Authorization: Digest username="tomcat", realm="Example Form-Based Authentication Area", nonce="1312210708250:07638438d9768d4b57314ae248afae45", uri="/examples/jsp/security/protected/", response="b2c16583101e54e9df57556978e7caa8", opaque="FF67E330005AC64D3436BCD21EFFDDFC", qop=auth, nc=00000002, cnonce="1de945f472e348d6"
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16
Accept: application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Encoding: gzip,deflate,sdch
Accept-Language: en-US,en;q=0.8
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.3
Cookie: JSESSIONID=542178B14B48DD75216C0A7A6EF127A6


HTTP/1.1 401 Unauthorized
Server: Apache-Coyote/1.1
Cache-Control: private
Expires: Thu, 01 Jan 1970 08:00:00 CST
WWW-Authenticate: Digest realm="Example Form-Based Authentication Area", qop="auth", nonce="1312210895750:6e1027ae542612cab8768996e1835e52", opaque="BECE6E7C1874B3DDCE5E29AB6B2E99B0"
Content-Type: text/html;charset=utf-8
Content-Length: 960
Date: Mon, 01 Aug 2011 15:01:35 GMT

<html><head><title>Apache Tomcat/@VERSION@ - Error report</title><style><!--H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;} H2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;} H3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;} BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;} B {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;} P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}A {color : black;}A.name {color : black;}HR {color : #525D76;}--></style> </head><body><h1>HTTP Status 401 - </h1><HR size="1" noshade="noshade"><p><b>type</b> Status report</p><p><b>message</b> <u></u></p><p><b>description</b> <u>This request requires HTTP authentication ().</u></p><HR size="1" noshade="noshade"><h3>Apache Tomcat/@VERSION@</h3></body></html>
GET /examples/jsp/security/protected/ HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
Cache-Control: max-age=0
Authorization: Digest username="tomcat", realm="Example Form-Based Authentication Area", nonce="1312210895750:6e1027ae542612cab8768996e1835e52", uri="/examples/jsp/security/protected/", response="34d8042a3a6b24ce91d26588d1679bd5", opaque="BECE6E7C1874B3DDCE5E29AB6B2E99B0", qop=auth, nc=00000001, cnonce="e7e86b6bfb23ff8a"
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16
Accept: application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Encoding: gzip,deflate,sdch
Accept-Language: en-US,en;q=0.8
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.3
Cookie: JSESSIONID=542178B14B48DD75216C0A7A6EF127A6


HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Cache-Control: private
Expires: Thu, 01 Jan 1970 08:00:00 CST
Set-Cookie: JSESSIONID=EB2FEA0DA5191F6A078C6BF5B6652B9D; Path=/examples/; HttpOnly
Content-Type: text/html;charset=ISO-8859-1
Content-Length: 724
Date: Mon, 01 Aug 2011 15:01:35 GMT



<html>
<head>
<title>Protected Page for Examples</title>
</head>
<body bgcolor="white">

You are logged in as remote user
<b>tomcat</b>
in session <b>EB2FEA0DA5191F6A078C6BF5B6652B9D</b><br><br>


    Your user principal name is
    <b>tomcat</b>
    <br><br>




To check whether your username has been granted a particular role,
enter it here:
<form method="GET" action='index.jsp'>
<input type="text" name="role" value="">
</form>
<br><br>

If you have configured this app for form-based authentication, you can log
off by clicking
<a href='index.jsp?logoff=true'>here</a>.
This should cause you to be returned to the logon page after the redirect
that is performed.

</body>
</html>