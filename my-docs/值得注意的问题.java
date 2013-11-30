在webapps里头的应用加上META-INF\context.xml文件时，
会复制一份conf\Catalina\localhost，新复制的文件名是应用名，文件内容一样，
但是当修改META-INF\context.xml文件的内容时，conf\Catalina\localhost中的文件内容没有更新，
重新启动Tomcat时，使用的是conf\Catalina\localhost中的文件，而不是META-INF\context.xml文件。

如webapps\test\META-INF\context.xml

<Context antiResourceLocking="false" privileged="true">
	<Parameter name="myname" value="myvalue1" override="true" description="mydescription" />
	<Parameter name="myname" value="myvalue2" override="false" description="mydescription" />
</Context>

得到:
conf\Catalina\localhost\test.xml

<Context antiResourceLocking="false" privileged="true">
	<Parameter name="myname" value="myvalue1" override="true" description="mydescription" />
	<Parameter name="myname" value="myvalue2" override="false" description="mydescription" />
</Context>

也就是说conf\Catalina\localhost\test.xml是自动生成的，
但是修改任何一方都不会自动更新对方，
最后建议是使用conf\Catalina\localhost\test.xml的方式，
因为test\META-INF\context.xml一般只有在jar文件中，这种情形是一但部署后就不可能再修改了






org.apache.catalina.connector.Response实现了javax.servlet.http.HttpServletResponse，
调用setBufferSize后再用getBufferSize()得到的值可以不一样，
比如response.setBufferSize(100)，response.getBufferSize()却返回8192，
这里因为Response内部的OutputBuffer默认是8192，如果你设得比8192小，那么实际上会忽略掉的。

