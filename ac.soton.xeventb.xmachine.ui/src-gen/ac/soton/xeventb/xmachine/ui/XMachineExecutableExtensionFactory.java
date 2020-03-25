/*
 * generated by Xtext 2.17.1
 */
package ac.soton.xeventb.xmachine.ui;

import ac.soton.xeventb.xmachine.ui.internal.XmachineActivator;
import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class XMachineExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(XmachineActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		XmachineActivator activator = XmachineActivator.getInstance();
		return activator != null ? activator.getInjector(XmachineActivator.AC_SOTON_XEVENTB_XMACHINE_XMACHINE) : null;
	}

}
