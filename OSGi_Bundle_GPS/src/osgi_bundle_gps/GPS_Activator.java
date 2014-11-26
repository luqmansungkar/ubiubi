package osgi_bundle_gps;

import gui.*;

import java.io.BufferedReader;
import java.util.Hashtable;

import javax.swing.JFrame;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import osgi_bundle_contextmanager.ContextManagerService;

//import servis
/**
 * Kelas ini bertujuan untuk
 * 
 * @author Abdullah Izzuddiin A - 1106053546
 *
 */
public class GPS_Activator implements BundleActivator {
	private GPS_Service gps_service;
	private ContextManagerService cms;
	private BufferedReader bf;
	private static BundleContext konteks;
	private ServiceTracker tracker;
	private LoginPageUI layar;
	private ServiceTrackerCustomizer customTracker = new ServiceTrackerCustomizer() {
		@Override
		public Object addingService(ServiceReference reference) {
			// TODO Auto-generated method stub
			ContextManagerService cm_service = (ContextManagerService) konteks.getService(reference);
			cms = cm_service;
			if(gps_service == null)
			{
				gps_service = new GPS_Service(cm_service);
				gps_service.start();
				if (layar == null) {
					layar = new LoginPageUI(cms);
					layar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			                layar.setResizable(false);
					layar.setVisible(true);
				}
				return cm_service;
			}
			else
			{
				return cm_service;
			}
		}

		@Override
		public void modifiedService(ServiceReference reference, Object object) {
			// TODO Auto-generated method stub
			gps_service.stop();
			try {
				gps_service.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
			ContextManagerService cm_service = (ContextManagerService) konteks.getService(reference);
			
			gps_service = new GPS_Service(cm_service);
			gps_service.start();
			if (layar == null) {
				layar = new LoginPageUI(cms);
				layar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                layar.setResizable(false);
				layar.setVisible(true);
			}
		}

		@Override
		public void removedService(ServiceReference arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		konteks = context;
		
		tracker = new ServiceTracker(context, ContextManagerService.class.getName(), customTracker);
		tracker.open();
		
		if(gps_service!=null)
		{
			ServiceRegistration registration = konteks.registerService(GPS_Service.class.getName(), gps_service, new Hashtable());
		}
		
		
		
		
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
