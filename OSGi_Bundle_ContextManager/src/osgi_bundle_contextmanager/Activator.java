package osgi_bundle_contextmanager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		//this.context = context;
		ContextManagerService contextService = new ContextManagerService();
		ServiceRegistration registration = context.registerService(ContextManagerService.class.getName(), contextService, new Hashtable());
		System.out.println("Mulai broh");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("masukan anda : "+br.readLine());
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!! haha");
	}

}
