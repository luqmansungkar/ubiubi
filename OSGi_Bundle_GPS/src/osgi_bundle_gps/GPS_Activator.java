package osgi_bundle_gps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
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
	private BufferedReader bf;
	private static BundleContext konteks;	
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		GPS_Activator.konteks = context;
		ContextManagerService cm_service = new ContextManagerService();
		if(gps_service==null)
		{
			gps_service = new GPS_Service(cm_service);
		}
		else if(gps_service!=null)
		{
			ServiceRegistration registration = konteks.registerService(GPS_Service.class.getName(), gps_service, new Hashtable());
			System.out.println("Servis sudah didaftarkan");
		}
		
		bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Selamat Datang");
		System.out.println("Apa yang bisa kami bantu?");
		System.out.println("1. Informasi Tempat Menarik");
		System.out.println("2. Tempat Menarik di lokasi Anda");
		System.out.println("3. Petunjuk Arah ke Tempat Tujuan Anda");
		System.out.println("Exit");
		int pilihan = Integer.parseInt(bf.readLine());
		eksekusiPilihan(pilihan);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		gps_service = null;
		System.out.println("Goodbye World!!");
	}
	
	public void eksekusiPilihan(int pilihan)
	{
		System.out.println("jaa");
		switch (pilihan) {
		case 1:
			gps_service.printTempatMenarikAll();
			break;
		case 2:
			gps_service.printTempatMenarikByLokasi(gps_service.getLokasi());
			break;
		case 3:
			System.out.println("Saat ini, Anda sedang berada di kota "+ gps_service.getLokasi());
			System.out.println("Pilih kota tujuan Anda sekarang");
			for(int ii = 0; ii< 9; ii++)
			{
				if(((char)(65+ii))!= (gps_service.getLokasi().charAt(0))) 
					System.out.println((char)(65+ii));
			}
			String kotaPilihan = null;
			try {
				System.out.print("Tulis Kota Tujuan Anda: ");
				kotaPilihan = bf.readLine();
			} catch (Exception e) {
				
			}
			gps_service.printPetunjukArah(gps_service.getLokasi(),kotaPilihan);
			break;
		}
	}
}
