Tomcat中一些核心的组件都具有生命周期(也就是实现了org.apache.catalina.Lifecycle接口)，
可以认为Tomcat是一个事件驱动的组件化容器，
可以为每个具有生命周期的组件注册生命周期事件监听器(org.apache.catalina.LifecycleListener)，
可以监听如下13个事件(按事件先后发生的顺序):
 1. before_init
 2. after_init
 3. before_start
 4. configure_start
 5. start
 6. after_start

 ....
 7. periodic
 7. periodic
 7. periodic
 ....

 8. before_stop
 9. stop
10. configure_stop
11. after_stop
12. before_destroy
13. after_destroy

其中第7个periodic事件会周期性的发生(有个后台线程在运行，默认是10秒钟触发一次)，
特别需要注意的是，要触发destroy事件必须先设用stop，否则会出现无效的状态转换异常，
上面13个事件当调用Lifecycle接口中如下4个方法时触发:
init()->start()->stop()->destroy()

configure_start和configure_stop
在Context、Server、NamingResources这样的涉及的配置文件的地方触发。


