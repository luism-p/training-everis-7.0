<%@ include file="init.jsp"%>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    Customer customer = null;

    if(row != null){
        customer = (Customer)row.getObject();
    }
%>

<portlet:renderURL var="editUrl">
    <portlet:param name="mvcPath" value="/edit.jsp"/>
    <portlet:param name="redirect" value="<%= themeDisplay.getURLCurrent()%>"/>
    <portlet:param name="customerId" value="<%= customer%>"/>

</portlet:renderURL>
<portlet:actionURL var="removeUrl" name="<%=CustomersConstans.CUSTOMER_ACTION_COMMAND_REMOVE%>">
    <portlet:param name="redirect" value="<%= themeDisplay.getURLCurrent()%>"/>
    <portlet:param name="customerId" value="<%= String.valueOf(customer.getCustomerId())%>"/>
</portlet:actionURL>

<liferay-ui:icon-menu>
    <liferay-ui:icon iconCssClass="icon-edit" message="edit" url="${editUrl}" />
    <liferay-ui:icon iconCssClass="icon-remove" message="remove" url="${removeUrl}" />
</liferay-ui:icon-menu>