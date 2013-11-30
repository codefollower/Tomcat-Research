第一种:
手动调用response.getWriter().flush()或Response.flushBuffer()方法
response.getWriter().write("aaa");
response.getWriter().flush();
或response.flushBuffer();

response.getWriter().flush()与response.flushBuffer()的差别是
response.flushBuffer()会把appCommitted设为true,
不过两种情况下response.isCommitted()都会返回true。

第二种:
org.apache.catalina.connector.OutputBuffer默认是8k，
如果写满了，会自动写回响应消息。

第三种:
也就是正常情况，在执行完servlet后，
容器会调用response.finishResponse，
response.finishResponse调用OutputBuffer.close，
OutputBuffer.close会触发一系列事情，最后写回响应消息。