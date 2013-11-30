Tomcat-Research
==================

Tomcat源代码学习研究(包括代码注释、文档、用于代码分析的测试用例)


## 使用的Tomcat版本

保持与官方的[trunk](https://github.com/apache/tomcat)版本同步


## 构建与运行环境

需要JDK7以及[Apache Maven](http://maven.apache.org/)


## 生成Eclipse工程

mvn eclipse:eclipse <br><br>

在eclipse中导入 <br>
File->Import->General->Existing Projects into Workspace


## 运行Tomcat

在Eclipse中右击start-tomcat.launch这个文件，点Run As启动Tomcat，点Debug As可以调试Tomcat。

<p>最后，打开你的浏览器，输入 http://127.0.0.1:8080/examples/ 看看例子吧。
