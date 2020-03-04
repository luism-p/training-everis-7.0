package com.liferay.training.eventsenderportlet.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.training.eventsenderportlet.constants.EventSenderPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author LuisMiguelPerezPache
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EventSender",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EventSenderPortletKeys.EVENTSENDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-publishing-event=say.hello;keyEvent"
	},
	service = Portlet.class
)
public class EventSenderPortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String message = ParamUtil.get(actionRequest, "message", StringPool.BLANK);
		QName qname = new QName("keyEvent", "say.hello");
		actionResponse.setEvent(qname, message);
		super.processAction(actionRequest, actionResponse);
	}
}