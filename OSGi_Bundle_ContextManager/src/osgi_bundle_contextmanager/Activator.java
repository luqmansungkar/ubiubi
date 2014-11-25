package osgi_bundle_contextmanager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import osgi_bundle_preferencerepository.PreferenceRepositoryService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private PreferenceRepositoryService prefRepo;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		ServiceReference ref = context.getServiceReference(PreferenceRepositoryService.class.getName());
		prefRepo = (PreferenceRepositoryService) context.getService(ref);
		ContextManagerService contextService = new ContextManagerService(prefRepo);
		ServiceRegistration registration = context.registerService(ContextManagerService.class.getName(), contextService, new Hashtable());
		System.out.println("Mulai Context Manager");
		//contextService.getSaran();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!! haha");
	}

}
