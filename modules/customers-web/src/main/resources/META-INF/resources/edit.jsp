
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
        <aui:input id="name" name="name" type="text" value="${customerName}">
            <aui:validator name="required" errorMessage="please enter valid name"/>
         </aui:input>
        <aui:input id="address" name="address" type="text" value="${customerAddress}">
            <aui:validator name="required" errorMessage="please enter valid address"/>
        </aui:input>
        <aui:input id="phoneNumber" name="phoneNumber" type="text" value="${customerPhone}">
            <aui:validator name="required" errorMessage="please enter valid phone"/>
            <aui:validator name="custom" errorMessage="please enter valid phone">
                function (val,fieldNode,ruleValue) {
                    return /(\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}/.test(val);
                }
            </aui:validator>
        </aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button href="<%=redirect%>" type="cancel" />
    </aui:button-row>
</aui:form>
