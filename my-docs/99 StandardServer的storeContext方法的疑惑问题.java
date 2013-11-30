org.apache.catalina.core.StandardServer的如下两个方法是不可用的:
storeConfig
storeContext
这个要用到tomcat5.5中的一个分开的模块:storeconfig
但是在Tomcat7中目前没有。


其中的:
    public synchronized void storeContext(Context context) throws Exception {
        
        ObjectName sname = null;    
        try {
           sname = new ObjectName("Catalina:type=StoreConfig");
           if(mserver.isRegistered(sname)) {
               mserver.invoke(sname, "store",
                   new Object[] {context}, 
                   new String [] { "java.lang.String"});
           } else
               log.error("StoreConfig mbean not registered" + sname);
        } catch (Throwable t) {
            ExceptionUtils.handleThrowable(t);
            log.error(t);
        }
 
    }
"java.lang.String"是用来指明当用jconsole来查看时，输入一个类名字符串，然后让Mbean的classloader去加载他，
这里并不是说store方法的参数是string类型，看起来的确非常迷惑，new Object[] {context}是org.apache.catalina.Context的对像，
按理说new String [] { "java.lang.String"})应改成new String [] { "org.apache.catalina.Context"})才对，
实际上并不是这样.