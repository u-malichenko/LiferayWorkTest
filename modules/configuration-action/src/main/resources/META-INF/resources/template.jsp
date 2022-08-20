<%@include file = "init.jsp" %>
<%@ page import="com.liferay.blade.samples.configurationaction.lang.LanguageTemplateConfigurationDisplayContext" %>

<%
    LanguageTemplateConfigurationDisplayContext
            languageTemplateConfigurationDisplayContext = (LanguageTemplateConfigurationDisplayContext)request.getAttribute(LanguageTemplateConfigurationDisplayContext.class.getName());

    String currentTemplateName = languageTemplateConfigurationDisplayContext.getCurrentTemplateName();
%>

<aui:select label="<%= HtmlUtil.escape(languageTemplateConfigurationDisplayContext.getFieldLabel()) %>" name="ddmTemplateKey" value="<%= currentTemplateName %>">

    <%
        for (String[] templateValue : languageTemplateConfigurationDisplayContext.getTemplateValues()) {
    %>

    <aui:option label="<%= templateValue[1] %>" selected="<%= currentTemplateName.equals(templateValue[0]) %>" value="<%= templateValue[0] %>" />

    <%
        }
    %>

</aui:select>