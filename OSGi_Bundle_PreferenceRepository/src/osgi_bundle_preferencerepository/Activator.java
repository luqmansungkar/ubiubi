package osgi_bundle_preferencerepository;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		PreferenceRepositoryService prs = new PreferenceRepositoryService();
		ServiceRegistration registration = context.registerService(PreferenceRepositoryService.class.getName(), prs, new Hashtable());
		System.out.println("Jalankan Preference Repository");
		System.out.println(prs.getPreference("Izza,25,hujan,12:00"));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}
