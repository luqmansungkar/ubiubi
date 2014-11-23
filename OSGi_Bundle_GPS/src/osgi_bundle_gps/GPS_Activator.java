package osgi_bundle_gps;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

//import servis
/**
 * Kelas ini bertujuan untuk
 * 
 * @author Abdullah Izzuddiin A - 1106053546
 *
 */
public class GPS_Activator implements BundleActivator {
	private GPS_Service gps_service;
	private static BundleContext konteks;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		GPS_Activator.konteks = context;
		if(gps_service!=null)
		{
			ServiceRegistration registration = konteks.registerService(GPS_Service.class.getName(), gps_service, new Hashtable());
			System.out.println("Servis sudah didaftarkan");
		}
		System.out.println("GPS Start");
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		gps_service = null;
		System.out.println("Goodbye World!!");
	}
	
	@Override
	public Object addingService(ServiceReference reference)
	{
		ContextManager_Service CM_Service = (ContextManager_Service) konteks.getService(reference);
		if(gps_service == null)
		{
			gps_service = new GPS_Service(CM_Service);
			gps_service.start();
			return CM_Service;
		}
		else
		{
			return CM_Service;
		}
	}
	
	@Override
	public void modifiedService(ServiceReference reference, Object service)
	{
		gps_service.stop();
		
	}

	public Object stopService()
	{
		gps_service.stop();
		gps_service = null;	
	}
}
