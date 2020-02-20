
<%@ include file="init.jsp"%>

<%
    String redirect = ParamUtil.getString(request, "redirect");
    Customer customer = null;

%>
<portlet:actionURL var="actionEdit" name="<%=CustomersConstans.CUSTOMER_ACTION_COMMAND_EDIT%>"/>

<aui:form action="${actionEdit}">
    <aui:model-context bean="<%=customer%>" model="<%=Customer.class%>"/>
    <aui:input name="redirect" type="hidden" value="<%=themeDisplay.getURLCurrent()%>" />
    <aui:input name="customerId" type="hidden" value="${customerId}"/>

    <aui:fieldset>
        <aui:input id="name" name="name" type="text" value="${customerName}"/>
        <aui:input id="address" name="address" type="text" value="${customerAddress}"/>
        <aui:input id="phoneNumber" name="phoneNumber" type="text" value="${customerPhone}"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button href="<%=redirect%>" type="cancel" />
    </aui:button-row>
</aui:form>
