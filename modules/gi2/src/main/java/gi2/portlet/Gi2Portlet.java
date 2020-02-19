package gi2.portlet;

import greeting.sevice.Greeting;


import org.osgi.service.component.annotations.Component;

/**
 * @author LuisMiguelPerezPache
 */
@Component(
	immediate = true,
	property = {

	},
	service = Greeting.class
)
public class Gi2Portlet implements Greeting {

	@Override
	public void greet(String name) {
		System.out.println(name);
		
	}
}