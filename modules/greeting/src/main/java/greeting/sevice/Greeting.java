package greeting.sevice;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public interface Greeting {
	public void greet(String name);
}
