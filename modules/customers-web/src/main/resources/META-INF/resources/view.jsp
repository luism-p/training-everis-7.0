<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ include file="./init.jsp" %>

<liferay-ui:success key="customer-deleted" message="Customer deled successfully!"/>
<liferay-ui:error key="could-not-delete" message="Customer not deleted!"/>

<portlet:renderURL var="editUrl">
	<portlet:param name="mvcPath" value="/edit.jsp"/>
	<portlet:param name="redirect" value="<%= themeDisplay.getURLCurrent()%>"/>
</portlet:renderURL>


<liferay-ui:search-container total="${fn:length(listCustomers)}">
	<liferay-ui:search-container-results results="${listCustomers}"/>
	<liferay-ui:search-container-row className="com.liferay.trainin.customers.model.Customer" modelVar="customer">
		<liferay-ui:search-container-column-text property="name"/>
		<liferay-ui:search-container-column-text property="address"/>
		<liferay-ui:search-container-column-text property="phoneNumber"/>
		<liferay-ui:search-container-column-text property="modifiedDate"/>
		<liferay-ui:search-container-column-text property="customerId"/>
		<liferay-ui:search-container-column-jsp path="/actions.jsp" cssClass="entry-action" valign="top" />
	</liferay-ui:search-container-row>
	<liferay:search-iterator />
</liferay-ui:search-container>

<aui:button-row>
	<aui:button onClick="${editUrl}" value="ADD"/>
</aui:button-row>