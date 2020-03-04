<%@ page import="com.liferay.training.senderPortlet.constants.SenderPortletKeys" %>
<%@ include file="/init.jsp" %>


<portlet:actionURL var="sendMessageURL"/>

<aui:form action="${sendMessageURL}">
    send a message:
    <aui:input name="<%=SenderPortletKeys.MESSAGE%>" value=""/>
    <aui:button-row>
        <aui:button type="submit" value="send"/>
    </aui:button-row>
</aui:form>
