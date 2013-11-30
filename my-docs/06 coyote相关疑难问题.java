Http11Protocol
JIoEndpoint
Http11ConnectionHandler
RequestGroupInfo

这4个类是一一对应的，运行时都只有一个实例

Http11Processor
Request
Response
RequestInfo
是多例的，这4个实的实例个数一样，生存期也一样


org.apache.coyote.http11.InternalOutputBuffer.endRequest()被调用了两次，
第二次什么都没有输出
java.lang.Error
	at org.apache.coyote.http11.InternalOutputBuffer.endRequest(InternalOutputBuffer.java:160)
	at org.apache.coyote.http11.Http11Processor.actionInternal(Http11Processor.java:413)
	at org.apache.coyote.http11.AbstractHttp11Processor.action(AbstractHttp11Processor.java:773)
	at org.apache.coyote.Response.action(Response.java:170)
	at org.apache.coyote.Response.finish(Response.java:276)
	at org.apache.catalina.connector.OutputBuffer.close(OutputBuffer.java:286)
	at org.apache.catalina.connector.Response.finishResponse(Response.java:501)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:432)
	at org.apache.coyote.http11.Http11Processor.process(Http11Processor.java:278)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:515)
	at org.apache.tomcat.util.net.JIoEndpoint$SocketProcessor.run(JIoEndpoint.java:300)
	at java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
	at java.lang.Thread.run(Thread.java:619)
java.lang.Error
	at org.apache.coyote.http11.InternalOutputBuffer.endRequest(InternalOutputBuffer.java:160)
	at org.apache.coyote.http11.AbstractHttp11Processor.endRequest(AbstractHttp11Processor.java:1282)
	at org.apache.coyote.http11.Http11Processor.process(Http11Processor.java:312)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:515)
	at org.apache.tomcat.util.net.JIoEndpoint$SocketProcessor.run(JIoEndpoint.java:300)HTTP/1.1 200 OK
	at java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
	at java.lang.Thread.run(Thread.java:619)
