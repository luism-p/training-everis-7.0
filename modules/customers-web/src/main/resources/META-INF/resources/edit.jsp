<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ include file="init.jsp"%>

<%


    String redirect = ParamUtil.getString(request, "redirect");
    Customer customer = (Customer) request.getAttribute("customerId");
    //long customerId = ParamUtil.getLong(request, "customerId", -1L);
    //if(customerId >= 0){
       // customer = customerLocalService.fetchCustomer(customerId);
   // }

%>
<portlet:actionURL var="actionEdit" name="<%=CustomersConstans.CUSTOMER_ACTION_COMMAND_EDIT%>"/>

<aui:form action="${actionEdit}">
    <aui:model-context bean="<%=customer%>" model="<%=Customer.class%>"/>
    <aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=customer == null ? Constants.ADD: Constants.UPDATE %>" />
    <aui:input name="redirect" type="hidden" value="<%=themeDisplay.getURLCurrent()%>" />
    <aui:input name="customerId" type="hidden" />

    <aui:fieldset>
        <aui:input id="name" name="name" type="text"/>
        <aui:input id="address" name="address" type="text"/>
        <aui:input id="phoneNumber" name="phoneNumber" type="text"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button href="<%=redirect%>" type="cancel" />
    </aui:button-row>
</aui:form>
