在编译JSP时，每个EL表达式要进行这样的转换:
每个EL表达式都要转成proprietaryEvaluate调用，如:
org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:escapeXml(param[\"foo\"])}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));

1) 如果EL表达式中有方法调用:
如jsp\jsp2\el\functions.jsp中的:
${fn:escapeXml(param["foo"])}，
会按方法调用的嵌套层次构造一个:
org.apache.jasper.runtime.ProtectedFunctionMapper
然后把这个ProtectedFunctionMapper实例传给proprietaryEvaluate方法,

这是${fn:escapeXml(param["foo"])}在编译jsp后生成的Servlet的代码片段:
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;
static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:escapeXml", org.apache.taglibs.standard.functions.Functions.class, "escapeXml", new Class[] {java.lang.String.class});
}
上面这个因为只有一个fn:escapeXml，所以调用getMapForFunction得到的ProtectedFunctionMapper，
在它内部只会用到Method theMethod字段，

而对于:${my:reverse(my:reverse(fn:escapeXml(param["foo"])))}
虽然嵌套了三层，但是实际上只有:my:reverse和fn:escapeXml
在编译jsp后生成的Servlet的代码片段如下:
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_1;
static {
	_jspx_fnmap_1= org.apache.jasper.runtime.ProtectedFunctionMapper.getInstance();
  _jspx_fnmap_1.mapFunction("my:reverse", jsp2.examples.el.Functions.class, "reverse", new Class[] {java.lang.String.class});

  _jspx_fnmap_1.mapFunction("fn:escapeXml", org.apache.taglibs.standard.functions.Functions.class, "escapeXml", new Class[] {java.lang.String.class});
  
}

这里用ProtectedFunctionMapper.getInstance()得到一个实例，
然后在调用mapFunction方法，
这样得到的ProtectedFunctionMapper在内部会用一个HashMap<String,Method> fnmap来存放方法，


ProtectedFunctionMapper两种情况分开对待，一定程试上可以提高Method的查找速度。



2) 如果EL表达式中没有方法调用:
像jsp\jsp2\el\basic-arithmetic.jsp中的那些el表达式，
此时生成的proprietaryEvaluate方法，传给functionMap参数的值都是null

另外，PageContext pageContext字段就是对应jsp生成后的Servlet对应的PageContext，
每个jsp都独立的对应一个PageContext。

proprietaryEvaluate内部都是生成ValueExpression，而没有MethodExpression