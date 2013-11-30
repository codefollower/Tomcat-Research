conf/web.xml文件中定义了一个处理所有jsp页面的总servlet
<servlet>
        <servlet-name>jsp</servlet-name>
        <servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>
        <init-param>
            <param-name>fork</param-name>
            <param-value>false</param-value>
        </init-param>
        <init-param>
            <param-name>xpoweredBy</param-name>
            <param-value>false</param-value>
        </init-param>
        <load-on-startup>3</load-on-startup>
    </servlet>

如果在web-info\web.xml中定义了<jsp-file>类型的servlet，如下例子:
    <servlet>
      <servlet-name>form</servlet-name>
      <jsp-file>/form.jsp</jsp-file>
      <init-param>
          <param-name>jspFile</param-name>
          <param-value>haha.jsp</param-value>
      </init-param>
      <init-param>
          <param-name>myname</param-name>
          <param-value>myvalue</param-value>
      </init-param>
    </servlet>
每个这样的servlet被包装成一个org.apache.catalina.deploy.ServletDef实例，
这个ServletDef实例的servletClass字段是null，而jspFile字段是/form.jsp，
parameters是"jspFile=haha.jsp,myname=myvalue"，
当进行到org.apache.catalina.startup.ContextConfig.webConfig()->convertJsps()时，
会把这种<jsp-file>类型的servlet进行特殊处理，
把servletClass字段设为"org.apache.jasper.servlet.JspServlet"，
把上面conf/web.xml文件中那个jsp的所有init-param放到上面这个parameters中，
同时在这个parameters中put("jspFile", "/form.jsp");
之前这个parameters中如果也有"jspFile"这样的key，比如在这个例子中这个key的值是"haha.jsp"，
那么将会被"/form.jsp"替换，
这个put("jspFile", ...)是tomcat内置的行为，因此千万不要依赖名称为"jspFile"的<init-param>。

最后，这个ServletDef实例的jspFile字段被设为null。
这样在org.apache.jasper.servlet.JspServlet的init方法中可以通过
config.getInitParameter("jspFile")这行代码把原始的jsp文件取出来。

