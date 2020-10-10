package com.everis.training.tools.portlet;

import com.everis.training.tools.constants.ToolsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author luism
 */

public interface ToolsPortlet {

	default String prueba(String str){
		str = str.toUpperCase();

		return str;
	}

	static String pruebaStatic(String str){
		str = str.toUpperCase();

		return str;
	}
}