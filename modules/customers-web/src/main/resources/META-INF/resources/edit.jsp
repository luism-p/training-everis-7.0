<%@ include file="init.jsp"%>

<liferay-ui:success key="customer-added" message="Customer created successfully!"/>
<liferay-ui:success key="customer-update" message="Customer update successfully!"/>
<liferay-ui:error key="invalid-data" message="Please enter valid data!"/>

<%
    Customer customer = null;

%>
<portlet:actionURL var="actionEdit" name="<%=CustomersConstans.CUSTOMER_ACTION_COMMAND_EDIT%>"/>
<portlet:actionURL var="redirect" name="<%=ParamUtil.getString(request, "redirect")%>"/>
<portlet:renderURL var="cancelURL">
    <portlet:param name="mvpPath" value="/view.jsp"/>
</portlet:renderURL>

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
        </aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button href="${cancelURL}" type="cancel" />
    </aui:button-row>
</aui:form>
