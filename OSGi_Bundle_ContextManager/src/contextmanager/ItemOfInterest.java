package contextmanager;

import java.util.ArrayList;

public class ItemOfInterest {
	private String nama;
	private String lokasi;
	private String informasi;
	private ArrayList<String> services;
	
	public ItemOfInterest(String nama, String lokasi, String informasi,
			ArrayList<String> services) {
		super();
		this.nama = nama;
		this.lokasi = lokasi;
		this.informasi = informasi;
		this.services = services;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	public String getInformasi() {
		return informasi;
	}

	public void setInformasi(String informasi) {
		this.informasi = informasi;
	}

	public ArrayList<String> getServices() {
		return services;
	}

	public void setServices(ArrayList<String> services) {
		this.services = services;
	}
	
	
}
