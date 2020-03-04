<%@ include file="/init.jsp" %>


<portlet:actionURL var="sendEvenetURL"/>

<aui:form action="${sendEvenetURL}">
	Say hello:

	<aui:button-row>
		<aui:button type="submit" value="!Hello"/>
	</aui:button-row>
</aui:form>