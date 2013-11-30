1.
ContextName类4个变量的含义:
    private final String baseName;
    private final String path;
    private final String version;
    private final String name;
对于"aaa#bbb##1.0.0"这样的目录名:
baseName = aaa#bbb##1.0.0
path     = /aaa/bbb
name     = /aaa/bbb##1.0.0
version  = 1.0.0

baseName就是最原始的目录名
name比path多了一个版本号，
两个连续的##之后是版本号，单个#号表示目录分隔符


2.
HostConfig类有这个变量:
	protected boolean deployXML = false;
    protected boolean copyXML = false;
    protected boolean unpackWARs = false;

StandardHost也有三个变量
    private boolean deployXML = true;
    private boolean copyXML = false;
    private boolean unpackWARs = true;


HostConfig类是一个LifecycleListener, 默认是StandardHost的LifecycleListener，
在lifecycleEvent方法中会默认用StandardHost的三个字段的值覆盖HostConfig类里头的。

deployXML的意思是: 部署web应用时，是否按META-INF\context.xml文件部署，
比如: 
tomcat\webapps\host-manager\META-INF\context.xml
tomcat\webapps\manager\META-INF\context.xml


copyXML的意思是: 
当deployXML=true时，是否把META-INF\context.xml复制到tomcat\conf\<engine>\<host>目录当中，
并且context.xml文件名变成"应用名.xml"

比如，tomcat\webapps\manager\META-INF\context.xml当deployXML=true且copyXML=true时，
会复制到tomcat\conf\Catalina\localhost\manager.xml


3.
HostConfig.deployDirectory

会把
E:\Tomcat7-SVN\launch\webapps\aaa#bbb##1.0.0这个绝对路径名和它的最近一次目录修改时间放到deployedApp.redeployResources
同样会把E:\Tomcat7-SVN\launch\conf\Catalina\localhost\aaa#bbb##1.0.0.xml
或者E:\Tomcat7-SVN\launch\webapps\aaa#bbb##1.0.0\META-INF\context.xml也放到deployedApp.redeployResources

接着通过HostConfig.addWatchedResources，
把可能会reload的资源加到deployedApp.reloadResources
比如: E:\Tomcat7-SVN\launch\webapps\aaa#bbb##1.0.0\WEB-INF\web.xml


DeployedApplication代表一个已部署的应用，DeployedApplication与应用是一一对应关系，
redeployResources的级别比reloadResources要大，前者是针对应用，后者是应用中的某些资源
两者都是map，key是绝对路径名，value是long类型


最后再调用HostConfig.addGlobalRedeployResources:
看看下面两个文件是否存在，存在的话加入redeployResources
E:\Tomcat7-SVN\launch\conf\Catalina\localhost\context.xml.default (这个默认性况下不存在)
E:\Tomcat7-SVN\launch\conf\context.xml

