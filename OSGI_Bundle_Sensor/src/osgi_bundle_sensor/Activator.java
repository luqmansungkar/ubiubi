package osgi_bundle_sensor;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import osgi_bundle_contextmanager.*;

public class Activator implements BundleActivator {
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		ServiceReference ref = context.getServiceReference(ContextManagerService.class.getName());
		
		SensorService sensorService = new SensorService((ContextManagerService) context.getService(ref));
		ServiceRegistration registration = context.registerService(SensorService.class.getName(), sensorService, new Hashtable());
		System.out.println("Jalankan Bundle Sensor");
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}
	
	
}
