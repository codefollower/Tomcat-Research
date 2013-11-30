public void registerComponent(Object bean, ObjectName oname, String type)
只有一个的type不为null(Catalina:type=Deployer,host=localhost)，
其他都为null

先扫描以下文件:
org/apache/catalina/mbeans/mbeans-descriptors.xml
org/apache/catalina/authenticator/mbeans-descriptors.xml
org/apache/catalina/core/mbeans-descriptors.xml
org/apache/catalina/mbeans-descriptors.xml
org/apache/catalina/deploy/mbeans-descriptors.xml
org/apache/catalina/loader/mbeans-descriptors.xml
org/apache/catalina/realm/mbeans-descriptors.xml
org/apache/catalina/session/mbeans-descriptors.xml
org/apache/catalina/startup/mbeans-descriptors.xml
org/apache/catalina/users/mbeans-descriptors.xml
org/apache/catalina/connector/mbeans-descriptors.xml
org/apache/catalina/valves/mbeans-descriptors.xml

再到
org/apache/jasper/servlet/mbeans-descriptors.xml

而org.apache.catalina.ha中没有mbeans-descriptors.xml，

ha目录中的
authenticator
deploy
session
tcp
默认没有加载

tribes.membership
中的默认也没有加载



只用到了两个:
org.apache.tomcat.util.modeler.modules.MbeansDescriptorsIntrospectionSource
通过反射取出方法

org.apache.tomcat.util.modeler.modules.MbeansDescriptorsDigesterSource
解析mbeans-descriptors.xml

StandardServer[8005]
Catalina:type=Server
null

org.apache.tomcat.util.buf.StringCache@4f9fdc
Catalina:type=StringCache
null

org.apache.catalina.mbeans.MBeanFactory@ca470
Catalina:type=MBeanFactory
null

org.apache.catalina.deploy.NamingResources@1ffc686
Catalina:type=NamingResources
null

StandardService[Catalina]
Catalina:type=Service
null

StandardEngine[Catalina]
Catalina:type=Engine
null

org.apache.catalina.core.StandardThreadExecutor@1aaf0b3
Catalina:type=Executor,name=tomcatThreadPool
null

Connector[HTTP/1.1-8080]
Catalina:type=Connector,port=8080
null

org.apache.coyote.http11.Http11Protocol@170888e
Catalina:type=ProtocolHandler,port=8080
null

org.apache.tomcat.util.net.JIoEndpoint@11563ff
Catalina:type=ThreadPool,name="http-bio-8080"
null

org.apache.coyote.RequestGroupInfo@1581593
Catalina:type=GlobalRequestProcessor,name="http-bio-8080"
null

org.apache.catalina.connector.MapperListener@16f0be8
Catalina:type=Mapper,port=8080
null

Connector[AJP/1.3-8009]
Catalina:type=Connector,port=8009
null


org.apache.coyote.ajp.AjpProtocol@176cad3
Catalina:type=ProtocolHandler,port=8009
null

org.apache.tomcat.util.net.JIoEndpoint@1fe1feb
Catalina:type=ThreadPool,name="ajp-bio-8009"
null

org.apache.coyote.RequestGroupInfo@e1899b
Catalina:type=GlobalRequestProcessor,name="ajp-bio-8009"
null

org.apache.catalina.connector.MapperListener@1113622
Catalina:type=Mapper,port=8009
null

Realm[LockOutRealm]
Catalina:type=Realm,realmPath=/realm0
null

Realm[UserDatabaseRealm]
Catalina:type=Realm,realmPath=/realm0/realm0
null

StandardEngine[Catalina].StandardHost[localhost]
Catalina:type=Host,host=localhost
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples]
Catalina:j2eeType=WebModule,name=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

org.apache.naming.resources.ResourceCache@15ad5c6
Catalina:type=Cache,host=localhost,context=/examples
null

WebappLoader[/examples]
Catalina:type=Loader,context=/examples,host=localhost
null

WebappClassLoader
  context: /examples
  delegate: false
  repositories:
    /WEB-INF/classes/
----------> Parent Classloader:
sun.misc.Launcher$AppClassLoader@9cab16

Catalina:type=WebappClassLoader,context=/examples,host=localhost
null

org.apache.catalina.deploy.NamingResources@50ca0c
Catalina:type=NamingResources,context=/examples,host=localhost
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[RequestInfoExample]
Catalina:j2eeType=Servlet,name=RequestInfoExample,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[CookieExample]
Catalina:j2eeType=Servlet,name=CookieExample,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[async0]
Catalina:j2eeType=Servlet,name=async0,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[async1]
Catalina:j2eeType=Servlet,name=async1,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[ServletToJsp]
Catalina:j2eeType=Servlet,name=ServletToJsp,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[async2]
Catalina:j2eeType=Servlet,name=async2,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[jsp]
Catalina:j2eeType=Servlet,name=jsp,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[async3]
Catalina:j2eeType=Servlet,name=async3,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[HelloWorldExample]
Catalina:j2eeType=Servlet,name=HelloWorldExample,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[RequestHeaderExample]
Catalina:j2eeType=Servlet,name=RequestHeaderExample,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[ChatServlet]
Catalina:j2eeType=Servlet,name=ChatServlet,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[CompressionFilterTestServlet]
Catalina:j2eeType=Servlet,name=CompressionFilterTestServlet,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[SessionExample]
Catalina:j2eeType=Servlet,name=SessionExample,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[default]
Catalina:j2eeType=Servlet,name=default,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[stock]
Catalina:j2eeType=Servlet,name=stock,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/examples].StandardWrapper[RequestParamExample]
Catalina:j2eeType=Servlet,name=RequestParamExample,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

org.apache.catalina.authenticator.FormAuthenticator[/examples]
Catalina:type=Valve,context=/examples,host=localhost,name=FormAuthenticator
null

org.apache.catalina.core.StandardContextValve[/examples]
Catalina:type=Valve,context=/examples,host=localhost,name=StandardContextValve
null

org.apache.catalina.session.StandardManager[/examples]
Catalina:type=Manager,context=/examples,host=localhost
null

ApplicationFilterConfig[name=Compression Filter, filterClass=compressionFilters.CompressionFilter]
Catalina:j2eeType=Filter,name=Compression Filter,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

ApplicationFilterConfig[name=Set Character Encoding, filterClass=filters.SetCharacterEncodingFilter]
Catalina:j2eeType=Filter,name=Set Character Encoding,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

ApplicationFilterConfig[name=Timing filter, filterClass=filters.ExampleFilter]
Catalina:j2eeType=Filter,name=Timing filter,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

ApplicationFilterConfig[name=haha, filterClass=WebFilterTest]
Catalina:j2eeType=Filter,name=haha,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

ApplicationFilterConfig[name=Request Dumper Filter, filterClass=org.apache.catalina.filters.RequestDumperFilter]
Catalina:j2eeType=Filter,name=Request Dumper Filter,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

org.apache.jasper.servlet.JspServlet@15e2075
Catalina:type=JspMonitor,name=jsp,WebModule=//localhost/examples,J2EEApplication=none,J2EEServer=none
null

org.apache.catalina.valves.ErrorReportValve[localhost]
Catalina:type=Valve,host=localhost,name=ErrorReportValve
null

org.apache.catalina.core.StandardHostValve[localhost]
Catalina:type=Valve,host=localhost,name=StandardHostValve
null

org.apache.catalina.startup.HostConfig@a522a6
Catalina:type=Deployer,host=localhost
org.apache.catalina.startup.HostConfig

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/docs]
Catalina:j2eeType=WebModule,name=//localhost/docs,J2EEApplication=none,J2EEServer=none
null

org.apache.naming.resources.ResourceCache@787c16
Catalina:type=Cache,host=localhost,context=/docs
null

WebappLoader[/docs]
Catalina:type=Loader,context=/docs,host=localhost
null

WebappClassLoader
  context: /docs
  delegate: false
  repositories:
----------> Parent Classloader:
org.apache.catalina.loader.StandardClassLoader@18020cc

Catalina:type=WebappClassLoader,context=/docs,host=localhost
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/docs].StandardWrapper[jsp]
Catalina:j2eeType=Servlet,name=jsp,WebModule=//localhost/docs,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[/docs].StandardWrapper[default]
Catalina:j2eeType=Servlet,name=default,WebModule=//localhost/docs,J2EEApplication=none,J2EEServer=none
null

org.apache.catalina.deploy.NamingResources@19ba640
Catalina:type=NamingResources,context=/docs,host=localhost
null

org.apache.catalina.core.StandardContextValve[/docs]
Catalina:type=Valve,context=/docs,host=localhost,name=StandardContextValve
null

org.apache.catalina.session.StandardManager[/docs]
Catalina:type=Manager,context=/docs,host=localhost
null

org.apache.jasper.servlet.JspServlet@1fe571f
Catalina:type=JspMonitor,name=jsp,WebModule=//localhost/docs,J2EEApplication=none,J2EEServer=none
null


StandardEngine[Catalina].StandardHost[localhost].StandardContext[]
Catalina:j2eeType=WebModule,name=//localhost/,J2EEApplication=none,J2EEServer=none
null

org.apache.naming.resources.ResourceCache@109ea96
Catalina:type=Cache,host=localhost,context=/
null

WebappLoader[]
Catalina:type=Loader,context=/,host=localhost
null

WebappClassLoader
  context: 
  delegate: false
  repositories:
    /WEB-INF/classes/
----------> Parent Classloader:
org.apache.catalina.loader.StandardClassLoader@18020cc

Catalina:type=WebappClassLoader,context=/,host=localhost
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[].StandardWrapper[jsp]
Catalina:j2eeType=Servlet,name=jsp,WebModule=//localhost/,J2EEApplication=none,J2EEServer=none
null

StandardEngine[Catalina].StandardHost[localhost].StandardContext[].StandardWrapper[default]
Catalina:j2eeType=Servlet,name=default,WebModule=//localhost/,J2EEApplication=none,J2EEServer=none
null

org.apache.catalina.deploy.NamingResources@18e261d
Catalina:type=NamingResources,context=/,host=localhost
null

org.apache.catalina.core.StandardContextValve[]
Catalina:type=Valve,context=/,host=localhost,name=StandardContextValve
null

org.apache.catalina.session.StandardManager[]
Catalina:type=Manager,context=/,host=localhost
null

org.apache.jasper.servlet.JspServlet@1552b76
Catalina:type=JspMonitor,name=jsp,WebModule=//localhost/,J2EEApplication=none,J2EEServer=none
null

org.apache.catalina.core.StandardEngineValve[Catalina]
Catalina:type=Valve,name=StandardEngineValve
null
