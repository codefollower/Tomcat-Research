AbstractProcessor中定义的变量
adapter
endpoint

asyncStateMachine
request
response

前两者是全局的，不会回收(recycle)，后三者会回收，
其中request在回收InputBuffer时被间接回收，response在回收OutputBuffer时被间接回收

下面这6个变量在AbstractHttp11Processor中定义，每次都被回收
remoteAddr
remoteHost
remotePort

localAddr
localName
localPort

以下变量都不会回收
============================================================
pluggableFilterIndex 固定是4，没有改变，也不会回收



hostNameC



以下三个变量在每个子类的process方法重置
error
keepAlive
comet (BIO不支持comet，AJP协议都不支持comet)

以下4个变量在prepareRequest方法重置
http11
http09
contentDelimitation
expectation


BIO/NIO/APR (11项, 放在AbstractHttp11Processor中)
============================================================
restrictedUserAgents
maxKeepAliveRequests
connectionUploadTimeout
disableUploadTimeout
compressionMinSize
compressionLevel==compression("on"=1, "force"=2, "off"=0, "2048"=1(compressionMinSize=2048))
noCompressionUserAgents
compressableMimeTypes
socketBuffer
maxSavePostSize
server

BIO还有
keepAliveTimeout
(放在AbstractHttp11Processor中，
这个变量没有必要，可以像NIO一样直接从endpoint.getKeepAliveTimeout()取得)

disableKeepAlivePercentage (放在Http11Processor中)


APR还有 (放在Http11AprProcessor中)
clientCertProvider

除了maxKeepAliveRequests外，
其他10个变理在每次createProcessor时都是从AbstractHttp11Protocol取的
maxKeepAliveRequests在AbstractHttp11Processor中默认值是-1，但是从AbstractEndpoint取时是100，
所以如果没有配这11个变量的值，默认值都是AbstractEndpoint或AbstractHttp11Protocol中的值，
并不是AbstractHttp11Processor中的值。

//排序后的变量
compressableMimeTypes = "text/html,text/xml,text/plain"
compressionLevel== "off" compression("on"=1, "force"=2, "off"=0, "2048"=1(compressionMinSize=2048))
compressionMinSize = 2048
connectionUploadTimeout = 300000 (5 * 60 * 1000) 相当于上传超时时间是5分钟
disableUploadTimeout = true 禁用上传超时时间(这时用socketTimeout)
maxKeepAliveRequests = 100 (从AbstractEndpoint中取)
maxSavePostSize = 4 * 1024 (4k)
noCompressionUserAgents = null
restrictedUserAgents = null
server = null
socketBuffer = 9000

在AbstractHttp11Processor中有三个变量值不同，其他都相同
disableUploadTimeout = false
maxKeepAliveRequests = -1
socketBuffer = -1

