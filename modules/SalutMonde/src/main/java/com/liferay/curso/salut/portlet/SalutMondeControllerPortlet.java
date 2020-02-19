package com.liferay.curso.salut.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Html;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import com.liferay.curso.salut.constants.SalutMondeControllerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author acallego
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SalutMondeController",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SalutMondeControllerPortletKeys.SALUTMONDECONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SalutMondeControllerPortlet extends MVCPortlet {
	
	private static final Log log = LogFactoryUtil.getLog(SalutMondeControllerPortlet.class);

	@Reference
	private Html html;
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {
		
		log.info("Render ejecutado ---------------------");
		
		super.render(renderRequest, renderResponse);
	}
	
	public void saludar(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {
		log.info("Saludo en proceso ---------------------");
		
		String name, welcomeMessage;
		
		name = html.escape(ParamUtil.getString(request, "name")).trim();
		
		welcomeMessage = "Bienvenue " + name + ".\n" + "Comment ça va?";
		
		request.setAttribute("welcomeMessage", welcomeMessage);
		response.setRenderParameter("mvcPath", "/view.jsp");
		//response.setRenderParameter("mvcRenderCommandName", "/view.jsp");
	}
	
}