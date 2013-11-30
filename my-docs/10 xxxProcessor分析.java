AbstractProcessor涓畾涔夌殑鍙橀噺
adapter
endpoint

asyncStateMachine
request
response

鍓嶄袱鑰呮槸鍏ㄥ眬鐨勶紝涓嶄細鍥炴敹(recycle)锛屽悗涓夎�浼氬洖鏀讹紝
鍏朵腑request鍦ㄥ洖鏀禝nputBuffer鏃惰闂存帴鍥炴敹锛宺esponse鍦ㄥ洖鏀禣utputBuffer鏃惰闂存帴鍥炴敹

涓嬮潰杩�涓彉閲忓湪AbstractHttp11Processor涓畾涔夛紝姣忔閮借鍥炴敹
remoteAddr
remoteHost
remotePort

localAddr
localName
localPort

浠ヤ笅鍙橀噺閮戒笉浼氬洖鏀�
============================================================
pluggableFilterIndex 鍥哄畾鏄�锛屾病鏈夋敼鍙橈紝涔熶笉浼氬洖鏀�



hostNameC



浠ヤ笅涓変釜鍙橀噺鍦ㄦ瘡涓瓙绫荤殑process鏂规硶閲嶇疆
error
keepAlive
comet (BIO涓嶆敮鎸乧omet锛孉JP鍗忚閮戒笉鏀寔comet)

浠ヤ笅4涓彉閲忓湪prepareRequest鏂规硶閲嶇疆
http11
http09
contentDelimitation
expectation


BIO/NIO/APR (11椤� 鏀惧湪AbstractHttp11Processor涓�
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

BIO杩樻湁
keepAliveTimeout
(鏀惧湪AbstractHttp11Processor涓紝
杩欎釜鍙橀噺娌℃湁蹇呰锛屽彲浠ュ儚NIO涓�牱鐩存帴浠巈ndpoint.getKeepAliveTimeout()鍙栧緱)

disableKeepAlivePercentage (鏀惧湪Http11Processor涓�


APR杩樻湁 (鏀惧湪Http11AprProcessor涓�
clientCertProvider

闄や簡maxKeepAliveRequests澶栵紝
鍏朵粬10涓彉鐞嗗湪姣忔createProcessor鏃堕兘鏄粠AbstractHttp11Protocol鍙栫殑
maxKeepAliveRequests鍦ˋbstractHttp11Processor涓粯璁ゅ�鏄�1锛屼絾鏄粠AbstractEndpoint鍙栨椂鏄�00锛�
鎵�互濡傛灉娌℃湁閰嶈繖11涓彉閲忕殑鍊硷紝榛樿鍊奸兘鏄疉bstractEndpoint鎴朅bstractHttp11Protocol涓殑鍊硷紝
骞朵笉鏄疉bstractHttp11Processor涓殑鍊笺�

//鎺掑簭鍚庣殑鍙橀噺
compressableMimeTypes = "text/html,text/xml,text/plain"
compressionLevel== "off" compression("on"=1, "force"=2, "off"=0, "2048"=1(compressionMinSize=2048))
compressionMinSize = 2048
connectionUploadTimeout = 300000 (5 * 60 * 1000) 鐩稿綋浜庝笂浼犺秴鏃舵椂闂存槸5鍒嗛挓
disableUploadTimeout = true 绂佺敤涓婁紶瓒呮椂鏃堕棿(杩欐椂鐢╯ocketTimeout)
maxKeepAliveRequests = 100 (浠嶢bstractEndpoint涓彇)
maxSavePostSize = 4 * 1024 (4k)
noCompressionUserAgents = null
restrictedUserAgents = null
server = null
socketBuffer = 9000

鍦ˋbstractHttp11Processor涓湁涓変釜鍙橀噺鍊间笉鍚岋紝鍏朵粬閮界浉鍚�
disableUploadTimeout = false
maxKeepAliveRequests = -1
socketBuffer = -1

