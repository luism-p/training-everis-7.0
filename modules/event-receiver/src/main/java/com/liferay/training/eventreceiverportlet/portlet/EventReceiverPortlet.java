package com.liferay.training.eventreceiverportlet.portlet;

import com.liferay.training.eventreceiverportlet.constants.EventReceiverPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

/**
 * @author LuisMiguelPerezPache
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EventReceiver",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EventReceiverPortletKeys.EVENTRECEIVER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-processing-event=say.hello;http://my.events.tld/ns"
	},
	service = Portlet.class
)
public class EventReceiverPortlet extends MVCPortlet {

	@ProcessEvent(qname ="{http://my.events.tld/ns}say.hello")
	public void receiveEvent(EventRequest eventRequest, EventResponse eventResponse){

		Event event = eventRequest.getEvent();
		String message = (String) event.getValue();
		eventResponse.setRenderParameter("message", message);
	}
}