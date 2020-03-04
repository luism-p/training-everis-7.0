package com.liferay.training.senderPortlet.portlet;

import com.liferay.training.senderPortlet.constants.SenderPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

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
		"javax.portlet.display-name=Sender",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SenderPortletKeys.SENDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=message"
	},
	service = Portlet.class
)
public class SenderPortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		actionResponse.setRenderParameter(SenderPortletKeys.MESSAGE, actionRequest.getParameter(SenderPortletKeys.MESSAGE));
		super.processAction(actionRequest, actionResponse);
	}
}