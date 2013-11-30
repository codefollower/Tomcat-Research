new URLClassLoader(urls)这样得到的parent默认会是sun.misc.Launcher$AppClassLoader
new URLClassLoader(urls, null)这样得到的parent才是null

org.apache.catalina.startup.Bootstrap.initClassLoaders()中
commonLoader的parent是sun.misc.Launcher$AppClassLoader
