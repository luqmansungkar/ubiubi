package osgi_bundle_gps;

import java.util.ArrayList;
import java.util.Random;

import osgi_bundle_contextmanager.ContextManagerService;

public class GPS_Service extends Thread {
	private int lokasi;
	private boolean isUse;
	private ContextManagerService CM_Service;
	
	public GPS_Service (ContextManagerService CM_Service_new)
	{
		this.CM_Service = CM_Service_new;
		this.lokasi = 3;
		this.isUse = true;
		CM_Service.setCurrentLocation(this.getLokasi());
		//run();
	}
	
	/*
	 * Method ini berfungsi untuk mengembalikan lokasi pengguna menggunakan string
	 * 
	 * @return String lokasi
	 */
	public String getLokasi()
	{
		switch (lokasi) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		case 3:
			return "D";
		case 4:
			return "E";			
		case 5:
			return "F";
		case 6:
			return "G";
		case 7:
			return "H";
		case 8:
			return "I";
		}
		return "Tidak ada di lokasi";
	}

	/*
	 * Method ini berfungsi untuk memindahkan lokasi pengguna
	 */
	public void PindahLokasi()
	{
		Random r = new Random();
		if(r.nextInt(2)==1)
		{
			int random = 0;
			switch (lokasi) {
			case 0:
				lokasi = 1 + r.nextInt(3);
				break;
			case 1:
				random = r.nextInt(5);
				if(random == 1) lokasi = 2+r.nextInt(3);
				else if (random == 2) lokasi = 0;
				else lokasi = random;
				break;
			case 2:
				random = r.nextInt(2);
				if(random == 0) lokasi = 0;
				else lokasi = 3;
				break;
			case 3:
				random = r.nextInt(5);
				if(random == 3) lokasi = random - r.nextInt(3);
				else lokasi = random;
				break;
			case 4:
				random = r.nextInt(7);
				if(random == 2 && random == 4)lokasi = r.nextInt(2);
				else lokasi = random;
				break;
			case 5:
				lokasi = 4+(2*(r.nextInt(3)));
				break;
			case 6:
				random = r.nextInt(3);
				if(random == 0) lokasi = 4;
				else if (random == 1) lokasi = 5;
				else lokasi = 8;
				break;
			case 7:
				lokasi = 4 + (4^(r.nextInt(2)));
				break;
			case 8:
				lokasi = 5 + r.nextInt(3);
				break;
			}
		}
	}
	
	public void run ()
	{
		while(isUse && (CM_Service!=null))
		{
			PindahLokasi();
			CM_Service.setCurrentLocation(this.getLokasi());
			
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
	public void printTempatMenarikAll()
	{
		ArrayList<String> tempatMenarik = new ArrayList<String>();
		tempatMenarik = CM_Service.getAllItemOfInterest();
		for(int ii=0;ii<tempatMenarik.size();ii++)
		{
			System.out.println(ii+". "+ tempatMenarik.get(ii));
		}
	}
	
	public void printTempatMenarikByLokasi(String lokasi)
	{
		ArrayList<String> tempatMenarik = new ArrayList<String>();
		tempatMenarik = CM_Service.getItemOfInterest(lokasi);
		for(int ii=0;ii<tempatMenarik.size();ii++)
		{
			System.out.println(ii+". "+ tempatMenarik.get(ii));
		}
	}
	
	public void printPetunjukArah(String lokasi, String tujuan)
	{
		String petunjukArah = CM_Service.getArah(lokasi, tujuan);
		System.out.println(petunjukArah);
	}
}
