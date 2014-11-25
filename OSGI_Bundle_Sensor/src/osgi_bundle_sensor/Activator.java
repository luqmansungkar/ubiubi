package osgi_bundle_sensor;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import osgi_bundle_contextmanager.*;

public class Activator implements BundleActivator {
	
	SensorService sensorService;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Jalankan Bundle Sensor");
		ServiceReference ref = context.getServiceReference(ContextManagerService.class.getName());
		
		ContextManagerService cms = (ContextManagerService) context.getService(ref);
		//System.out.println(cms.getArah("A", "B"));
		
		sensorService = new SensorService(cms);
		ServiceRegistration registration = context.registerService(SensorService.class.getName(), sensorService, new Hashtable());
		
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}
	
	
}
