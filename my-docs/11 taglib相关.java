org.apache.catalina.startup.WebRuleSet
final class TaglibLocationRule extends Rule {

    final boolean isServlet24OrLater;
    
    public TaglibLocationRule(boolean isServlet24OrLater) {
        this.isServlet24OrLater = isServlet24OrLater;
    }
    
    @Override
    public void begin(String namespace, String name, Attributes attributes)
            throws Exception {
        WebXml webXml = (WebXml) digester.peek(digester.getCount() - 1);
        // If we have a public ID, this is not a 2.4 or later webapp
        boolean havePublicId = (webXml.getPublicId() != null);
        // havePublicId and isServlet24OrLater should be mutually exclusive
        if (havePublicId == isServlet24OrLater) {
            throw new IllegalArgumentException(
                    "taglib definition not consistent with specification version");
        }
    }
}

servlet2.4+，不能在web.xml中直接使用<taglib>,
必须放在<jsp-config>中