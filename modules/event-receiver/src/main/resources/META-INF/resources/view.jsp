<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ include file="/init.jsp" %>

<c:set var="message" value="<%=ParamUtil.getString(request, "message")%>"/>

<c:if test="${not empty message}">
	Message reveiver:
	<c:out value="${message}"/>
</c:if>
