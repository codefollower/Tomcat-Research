1. google浏览器(chrome)
(注: 第一个动态请求单独用一个Socket，这个动态请求返回的响应页面中包含两个图片，再单独用一个Socket访问，
最后一个很特殊，是一个/favicon.ico，而且是chrome自动加)
accept: Socket[addr=/127.0.0.1,port=2418,localport=8080]
GET /examples/servlets/servlet/SessionExample HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/533.4 (KHTML, like Gecko) Chrome/5.0.375.99 Safari/533.4
Cache-Control: max-age=0
Accept: application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Encoding: gzip,deflate,sdch
Accept-Language: zh-CN,zh;q=0.8
Accept-Charset: GBK,utf-8;q=0.7,*;q=0.3
Cookie: JSESSIONID=93007527E8B83190F8239F46300DC05C


accept: Socket[addr=/127.0.0.1,port=2419,localport=8080]
GET /examples/servlets/images/code.gif HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/533.4 (KHTML, like Gecko) Chrome/5.0.375.99 Safari/533.4
Referer: http://127.0.0.1:8080/examples/servlets/servlet/SessionExample
Cache-Control: max-age=0
If-Modified-Since: Fri, 10 Dec 2010 15:35:18 GMT
If-None-Match: W/"292-1291995318250"
Accept: */*
Accept-Encoding: gzip,deflate,sdch
Accept-Language: zh-CN,zh;q=0.8
Accept-Charset: GBK,utf-8;q=0.7,*;q=0.3
Cookie: JSESSIONID=93007527E8B83190F8239F46300DC05C


GET /examples/servlets/images/return.gif HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/533.4 (KHTML, like Gecko) Chrome/5.0.375.99 Safari/533.4
Referer: http://127.0.0.1:8080/examples/servlets/servlet/SessionExample
Cache-Control: max-age=0
If-Modified-Since: Fri, 10 Dec 2010 15:35:18 GMT
If-None-Match: W/"1231-1291995318219"
Accept: */*
Accept-Encoding: gzip,deflate,sdch
Accept-Language: zh-CN,zh;q=0.8
Accept-Charset: GBK,utf-8;q=0.7,*;q=0.3
Cookie: JSESSIONID=93007527E8B83190F8239F46300DC05C


GET /favicon.ico HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/533.4 (KHTML, like Gecko) Chrome/5.0.375.99 Safari/533.4
Accept: */*
Accept-Encoding: gzip,deflate,sdch
Accept-Language: zh-CN,zh;q=0.8
Accept-Charset: GBK,utf-8;q=0.7,*;q=0.3


2. 遨游浏览器(Maxthon)
(注: 第一个动态请求和第一张图片单独用一个Socket，另一张图片再单独用一个Socket访问)

accept: Socket[addr=/127.0.0.1,port=2439,localport=8080]
GET /examples/servlets/servlet/SessionExample HTTP/1.1
Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash, application/x-ms-application, application/x-ms-xbap, application/vnd.ms-xpsdocument, application/xaml+xml, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, application/QVOD, application/QVOD, */*
Accept-Language: zh-cn
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)
Host: 127.0.0.1:8080
Connection: Keep-Alive


GET /examples/servlets/images/code.gif HTTP/1.1
Accept: */*
Referer: http://127.0.0.1:8080/examples/servlets/servlet/SessionExample
Accept-Language: zh-cn
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)
Host: 127.0.0.1:8080
Connection: Keep-Alive
Cookie: JSESSIONID=3EE8725ABF1B7960363C28BEBBA86D63


accept: Socket[addr=/127.0.0.1,port=2440,localport=8080]
GET /examples/servlets/images/return.gif HTTP/1.1
Accept: */*
Referer: http://127.0.0.1:8080/examples/servlets/servlet/SessionExample
Accept-Language: zh-cn
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)
Host: 127.0.0.1:8080
Connection: Keep-Alive
Cookie: JSESSIONID=3EE8725ABF1B7960363C28BEBBA86D63