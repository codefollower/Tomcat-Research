GET /examples/servlets/servlet/CookieExample HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
Cache-Control: max-age=0
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16
Accept: application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Encoding: gzip,deflate,sdch
Accept-Language: en-US,en;q=0.8
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.3


HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=ISO-8859-1
Content-Length: 408
Date: Wed, 20 Jul 2011 13:36:02 GMT

<html>
<body bgcolor="white">
<head>
<title>Cookies Example</title>
</head>
<body>
<h3>Cookies Example</h3>
Your browser isn't sending any cookies
<P>
Create a cookie to send to your browser<br>
<form action="CookieExample" method=POST>
Name:  <input type=text length=20 name=cookiename><br>
Value:  <input type=text length=20 name=cookievalue><br>
<input type=submit></form>
</body>
</html>

POST /examples/servlets/servlet/CookieExample HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
Referer: http://127.0.0.1:8080/examples/servlets/servlet/CookieExample
Content-Length: 30
Cache-Control: max-age=0
Origin: http://127.0.0.1:8080
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16
Content-Type: application/x-www-form-urlencoded
Accept: application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Encoding: gzip,deflate,sdch
Accept-Language: en-US,en;q=0.8
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.3


cookiename=111&cookievalue=222
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: 111="222-60000/paaa/bbb:ccc"; Version=1; Max-Age=60000; Expires=Thu, 21-Jul-2011 06:16:17 GMT; Path="/paaa/bbb:ccc"
Set-Cookie: 111222=222222
Content-Type: text/html;charset=ISO-8859-1
Content-Length: 495
Date: Wed, 20 Jul 2011 13:36:17 GMT

<html>
<body bgcolor="white">
<head>
<title>Cookies Example</title>
</head>
<body>
<h3>Cookies Example</h3>
Your browser isn't sending any cookies
<P>
You just sent the following cookie to your browser:<br>
Name:  111<br>Value:  222<P>
Create a cookie to send to your browser<br>
<form action="CookieExample" method=POST>
Name:  <input type=text length=20 name=cookiename><br>
Value:  <input type=text length=20 name=cookievalue><br>
<input type=submit></form>
</body>
</html>

GET /examples/servlets/servlet/CookieExample HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
Cache-Control: max-age=0
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16
Accept: application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Encoding: gzip,deflate,sdch
Accept-Language: en-US,en;q=0.8
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.3
Cookie: 111="222-60000/paaa/bbb:ccc"; 111222=222222


HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=ISO-8859-1
Content-Length: 593
Date: Wed, 20 Jul 2011 13:36:43 GMT

<html>
<body bgcolor="white">
<head>
<title>Cookies Example</title>
</head>
<body>
<h3>Cookies Example</h3>
Your browser is sending the following cookies:<br>
Cookie Name: 111<br>  Cookie Value: 222-60000/paaa/bbb:ccc<br>
  Cookie Path: null<br><br>
Cookie Name: 111222<br>  Cookie Value: 222222<br>
  Cookie Path: null<br><br>
<P>
Create a cookie to send to your browser<br>
<form action="CookieExample" method=POST>
Name:  <input type=text length=20 name=cookiename><br>
Value:  <input type=text length=20 name=cookievalue><br>
<input type=submit></form>
</body>
</html>