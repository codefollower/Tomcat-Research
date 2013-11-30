AbstractAjpProtocol

tomcatAuthentication = true
requiredSecret = null
packetSize = 8k (如果设定的值小于8k，那么还是会用8k)

apache与tomcat之间的连接一直处于打开状态(SoTimeout默认是-1)


AbstractAjpProcessor的字段
=================================
这三个字段的大于都是packetSize
requestHeaderMessage 用于接收请求头
responseHeaderMessage 先用于发送响应头，然后再复用多次用来发送响应体
bodyMessage 用于接收请求体


