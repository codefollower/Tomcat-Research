1. 默认用StandardManager
把session数据保存到work\Catalina\localhost\examples\SESSIONS.ser
SESSIONS.ser中存放了多个session的数据。

启动Tomcat时，调用org.apache.catalina.session.StandardManager.load()，
把SESSIONS.ser中的数据反序列化回来，生成多个StandardSession实例。
停止Tomcat时，调用org.apache.catalina.session.StandardManager.unload()把所有session序列化保存到SESSIONS.ser。
注意在eclipse中按红色方块的Terminate按钮是无法触发session的保存的，必需运行tomcat\bin\shutdown.bat才可以。

2. PersistentManager
可以把session数据保存到文件中(也就是FileStore的方式)，一个session对应一个文件，文件名是sessionId + ".session"，
也可以把session数据保存到数据库中(也就是JDBCStore的方式)。

StandardManager与PersistentManager的差别是:
session的反序列化并不是在启动Tomcat时做的，
也就是说org.apache.catalina.session.PersistentManagerBase.load()这个方法其实是没有用的，
".session"文件的读取会延迟到真正访问这个session时才去读，也就是调用request.getSession方法时，
如果上一次建立了一个socket，那么tomcat会通过cookie的方式把sessionId发给浏览器，
然后浏览器下一次请求时同样通过cookie把sessionId带回来，如:
Cookie: JSESSIONID=3EE8725ABF1B7960363C28BEBBA86D63
最后根据这个JSESSIONID就可以查看相关的".session"文件了。

StandardManager与PersistentManager都是在tomcat关闭时把session保存起来。


