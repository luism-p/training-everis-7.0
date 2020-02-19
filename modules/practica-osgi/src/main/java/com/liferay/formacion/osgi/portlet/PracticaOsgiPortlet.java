package com.liferay.formacion.osgi.portlet;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import greeting.sevice.Greeting;

/**
 * @author LuisMiguelPerezPache
 */
@Component(
	immediate = true,
	property = {
			"osgi.command.scope=testScope",
			"osgi.command.function=listProjects"
	},
	service = Object.class
)
public class PracticaOsgiPortlet {
	
	@Reference
	private Greeting _greeting;
	
	public void listProjects() {
		_greeting.greet("Everis");
	}
}