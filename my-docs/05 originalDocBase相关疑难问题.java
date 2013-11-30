originalDocBase与antiResourceLocking="true"相关，

当org.apache.catalina.startup.ContextConfig.lifecycleEvent(LifecycleEvent event)处理完
BEFORE_START_EVENT、CONFIGURE_START_EVENT事件后
当antiResourceLocking="true"时，会把应用copy一份到temp目录中，防止原来的被琐住了，
这样context.docBase改为temp目录中的那个新目录，
而originalDocBase就是最初的目录，

当org.apache.catalina.startup.ContextConfig.lifecycleEvent(LifecycleEvent event)
处理完AFTER_START_EVENT后，

originalDocBase是temp目录中的那个新目录
context.docBase改为最初的目录

当org.apache.catalina.startup.ContextConfig.lifecycleEvent(LifecycleEvent event)
处理到CONFIGURE_STOP_EVENT时，再把两者调过来，
context.docBase改为temp目录中的那个新目录，
originalDocBase是最初的目录，
最后调用org.apache.catalina.startup.ContextConfig.configureStop()，
取出context.docBase的值，因为是temp目录中的那个新目录，所以要把它删了。