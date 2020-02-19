package greeting.service.impl.portlet;


import org.osgi.service.component.annotations.Component;
import greeting.sevice.Greeting;

/**
 * @author LuisMiguelPerezPache
 */
@Component(
	immediate = true,
	property = {

	},
	service = Greeting.class
)
public class GreetingImplPortlet implements Greeting {

	@Override
	public void greet(String name) {
		System.out.println("Hola " +name);
		
	}
}