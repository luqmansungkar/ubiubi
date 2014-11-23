package osgi_bundle_gps;

import java.util.Hashtable;
import gui.UIHalamanLogin;
import osgi_bundle_contextmanager.ContextManagerService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

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
	private UIHalamanLogin lamanLoginUI;
	private ServiceTrackerCustomizer customTracker = new ServiceTrackerCustomizer(){
		@Override
		public Object addingService(ServiceReference reference)
		{
			ContextManagerService CM_Service = (ContextManagerService) konteks.getService(reference);
			if(gps_service == null)
			{
				gps_service = new GPS_Service(CM_Service);
				if(lamanLoginUI == null)
				{
					lamanLoginUI = new UIHalamanLogin(CM_Service, gps_service);
					lamanLoginUI.setVisible(true);
				}
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

		@Override
		public void removedService(ServiceReference reference, Object service) {
			// TODO Auto-generated method stub
			
		}
	};
	
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
	

}
