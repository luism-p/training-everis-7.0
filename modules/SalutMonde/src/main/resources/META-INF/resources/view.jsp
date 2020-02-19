<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/init.jsp" %>

<portlet:actionURL var="actionURL" name="saludar" />

<c:if test="${welcomeMessage != null && welcomeMessage != ''}">
	<h1> <c:out value="${welcomeMessage}"/> </h1>
</c:if>

<aui:form action="<%= actionURL %>" method="post" name="fm">
	<aui:input label="name" id="name" name="name" type="text" placeholder="Señor x" required="true">
		<aui:validator name="required" />
		<aui:validator name="alpha" />
	</aui:input>
	
	<aui:button type="submit" value="Saludar" />
</aui:form>