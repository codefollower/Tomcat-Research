org.apache.tomcat.util.net.NioEndpoint.Poller类的字段

ConcurrentLinkedQueue<Runnable> events其实都是PollerEvent类型
addEvent方法可以加入Runnable，但是这个方法目前没在别处调用，
都是在NioEndpoint中调用，调用addEvent方法时都是用PollerEvent类型做为参数




