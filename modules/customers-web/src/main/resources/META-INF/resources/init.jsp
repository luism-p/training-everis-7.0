<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib prefix="liferay" uri="http://liferay.com/tld/ui" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@page import="com.liferay.trainin.customers.model.Customer"%>
<%@page import="com.liferay.training.customers.constants.CustomersConstans"%>
<%@page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="com.liferay.trainin.customers.service.CustomerLocalService" %>

<liferay-theme:defineObjects />
    <liferay-ui:success key="success" message="Greeting saved successfully!"/>
<portlet:defineObjects />