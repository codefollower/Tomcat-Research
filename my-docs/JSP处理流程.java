1)
预初始化:
org.apache.jasper.compiler.JspRuntimeContext
org.apache.jasper.runtime.JspFactoryImpl


Tomcat在初始化时，
会触发org.apache.catalina.core.JasperListener，
在此类的lifecycleEvent方法中加载org.apache.jasper.compiler.JspRuntimeContext，

然后在org.apache.jasper.compiler.JspRuntimeContext类的静态初始化块中
生成一个org.apache.jasper.runtime.JspFactoryImpl实例，
并调用javax.servlet.jsp.JspFactory类的setDefaultFactory静态文法，
org.apache.jasper.runtime.JspFactoryImpl是javax.servlet.jsp.JspFactory的子类。


在运行期间只生成一个JspFactoryImpl实例。
JspFactory这个工厂类用来生产javax.servlet.js.JspApplicationContext，
和javax.servlet.jsp.PageContext


2)处理JSP
所有jsp的处理首先必须通过org.apache.jasper.servlet.JspServlet，
org.apache.jasper.servlet.JspServlet也是一个HttpServlet,
Tomcat运行期间只有一个org.apache.jasper.servlet.JspServlet实例，
在Tomcat自动调用它的init方法时，
会生成一个org.apache.jasper.compiler.JspRuntimeContext实例，
在运行期间也只有一个org.apache.jasper.compiler.JspRuntimeContext实例。

所有的jsp文件会转换成一个Servlet，
被转换后的每个Servlet都用一个
org.apache.jasper.servlet.JspServletWrapper实例封装起来，
并把与jsp相关的uri(通常就是jsp文件名)与JspServletWrapper实例存入JspRuntimeContext

3)JSP的初始化(自动调用init方法):
Tomcat会为每个jsp生成一个Servlet文件，
并且在首次加载这个Servlet时调用它的_jspInit()方法，
在这个_jspInit()方法中做了如下事情：




调用JspFactory类的getJspApplicationContext方法就会得到一个
JspApplicationContext实例，
JspApplicationContext在运行期间也只有一个实例，
这个实例通过ServletContext的setAttribute保存起来，
ServletContext是一个全局的环境，在Tomcat运行期间一直存在，也只有一个实例，
ServletContext的实例引用是通过JspFactory类的getJspApplicationContext方法传递的，
ServletContext的setAttribute用key=JspApplicationContextImpl.class.getName()把
JspApplicationContext原唯一实例保存起来。

JspApplicationContext与ServletContext可以看成是同等级别的概念，
ServletContext管理所有的Servlet，
而JspApplicationContext管理所有的JSP。


JspApplicationContext用来生成:
javax.el.ExpressionFactory,
调用getExpressionFactory()方法会得到一个javax.el.ExpressionFactory实例，
这个javax.el.ExpressionFactory实例也只有一个，
javax.el.ExpressionFactory实例实际是
org.apache.el.ExpressionFactoryImpl的实例。

还可以通过addELResolver方法把
javax.el.ELResolver的子类加到JspApplicationContext中,
这些javax.el.ELResolver的子类是:
javax.servlet.jsp.el.ImplicitObjectELResolver
javax.el.MapELResolver
javax.el.ResourceBundleELResolver
javax.el.ListELResolver
javax.el.ArrayELResolver
javax.el.BeanELResolver
javax.servlet.jsp.el.ScopedAttributeELResolver

还可以通过addELContextListener方法把
javax.el.ELContextListener加到JspApplicationContext中。
(javax.el.ELContextListener目前在Tomcat中未找到具休实现类)


4)调用JSP生成的Servlet的_jspService方法:
此方法自动定义下面8个变量:
HttpServletRequest request
HttpServletResponse response
PageContext pageContext
HttpSession session
ServletContext application
ServletConfig config
JspWriter out
Object page = this;

page实际上就是生成的Servlet的实例本身，
PageContext通过JspFactory的getPageContext方法获得，
PageContext与每个jsp一一对应，
JspFactory的子类JspFactoryImpl有一个PageContextPool，
PageContext的实例可以从PageContextPool获取，
在执行完_jspService方法后再把PageContext的实例放回PageContextPool中。

下面这四个变量都是通过PageContext的实例得到
HttpSession session
ServletContext application
ServletConfig config
JspWriter out
实际上这4个变量可以直接从生成的Servlet的实例间接得到，
config = servlet.getServletConfig()
application = config.getServletContext()
HttpSession session=((HttpServletRequest) request).getSession();

JspWriter out = new org.apache.jasper.runtime.JspWriterImpl

config实际上是从javax.servlet.GenericServlet得到的