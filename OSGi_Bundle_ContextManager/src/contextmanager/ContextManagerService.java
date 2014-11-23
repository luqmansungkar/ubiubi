package contextmanager;

import java.util.ArrayList;
import java.util.HashMap;

public class ContextManagerService {
	private ArrayList<ItemOfInterest> iois;
	
	public ContextManagerService(){
		
	}
	
	public ArrayList<String> getItemOfInterest(String kota){
		ArrayList<String> hasil = new ArrayList<String>();
		for (int i = 0; i < iois.size(); i++) {
			if (iois.get(i).getLokasi().equals(kota)) {
				hasil.add(iois.get(i).getNama());
			}
		}
		return hasil;
	}
	
	public String getIoiInformation(String nama){
		
		String info = "";
		
		for (int i = 0; i < iois.size(); i++) {
			if (iois.get(i).getNama().equals(nama)) {
				info = iois.get(i).getInformasi();
			}
		}
		
		return info;
	}
	
	public String getArah(String lokasi, String tujuan){
		String direction = tujuan+" berada di ";
		
		HashMap<String, String> listArah = new HashMap<String, String>();
		
		switch (lokasi) {
		case "A":
			listArah.put("B", "Timur");
			listArah.put("C", "Barat Daya");
			listArah.put("D", "Selatan");
			listArah.put("E", "Tenggara");
			listArah.put("F", "Tenggara");
			listArah.put("G", "Tenggara");
			listArah.put("H", "Selatan");
			listArah.put("I", "Tenggara");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		case "B":
			listArah.put("A", "Barat");
			listArah.put("C", "Barat Daya");
			listArah.put("D", "Barat Daya");
			listArah.put("E", "Selatan");
			listArah.put("F", "Selatan");
			listArah.put("G", "Tenggara");
			listArah.put("H", "Barat Daya");
			listArah.put("I", "Selatan");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		case "C":
			listArah.put("A", "Timur Laut");
			listArah.put("B", "Timur Laut");
			listArah.put("D", "Timur");
			listArah.put("E", "Timur");
			listArah.put("F", "Tenggara");
			listArah.put("G", "Tenggara");
			listArah.put("H", "Tenggara");
			listArah.put("I", "Tenggara");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		case "D":
			listArah.put("A", "Utara");
			listArah.put("B", "Timur Laut");
			listArah.put("C", "Barat");
			listArah.put("E", "Selatan");
			listArah.put("F", "Tenggara");
			listArah.put("G", "Tenggara");
			listArah.put("H", "Selatan");
			listArah.put("I", "Tenggara");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		case "E":
			listArah.put("A", "Barat Laut");
			listArah.put("B", "Utara");
			listArah.put("C", "Barat");
			listArah.put("D", "Barat");
			listArah.put("F", "Selatan");
			listArah.put("G", "Tenggara");
			listArah.put("H", "Barat Daya");
			listArah.put("I", "Selatan");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		case "F":
			listArah.put("A", "Barat Laut");
			listArah.put("B", "Utara");
			listArah.put("C", "Barat Laut");
			listArah.put("D", "Barat Laut");
			listArah.put("E", "Utara");
			listArah.put("G", "Barat");
			listArah.put("H", "Barat Daya");
			listArah.put("I", "Selatan");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		case "G":
			listArah.put("A", "Barat Laut");
			listArah.put("B", "Barat Laut");
			listArah.put("C", "Barat Laut");
			listArah.put("D", "Barat Laut");
			listArah.put("E", "Barat Laut");
			listArah.put("F", "Barat");
			listArah.put("H", "Barat Daya");
			listArah.put("I", "Barat Daya");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		case "H":
			listArah.put("A", "Utara");
			listArah.put("B", "Timur Laut");
			listArah.put("C", "Barat Laut");
			listArah.put("D", "Utara");
			listArah.put("E", "Timur Laut");
			listArah.put("F", "Timur Laut");
			listArah.put("G", "Timur Laut");
			listArah.put("I", "Timur");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		case "I":
			listArah.put("A", "Barat Laut");
			listArah.put("B", "Utara");
			listArah.put("C", "Barat Laut");
			listArah.put("D", "Barat Laut");
			listArah.put("E", "Utara");
			listArah.put("F", "Utara");
			listArah.put("G", "Barat Laut");
			listArah.put("H", "Barat");
			listArah.put(lokasi, "lokasi anda sekarang");
			break;
		default:
			break;
		}
		
		if (lokasi.equals(tujuan)) {
			direction += listArah.get(lokasi);
		}else{
			direction += listArah.get(lokasi)+" dari lokasi anda sekarang.";
		}
		
		return  direction;
	}
	
	
	/*
	 * mengirim saran ke gps(user pref) sx: jika context sarankan service
	 * 
	 * memanggil prefRepository(username, waktu, cuaca, temp, lokasi){
	 *   return (daftar services <-> lokasi sekarang)
	 * }
	 * 
	 * --getItemofInterest(lokasi){ret nama;}
	 * 
	 * --getDetailIoi(name){ret information}
	 * 
	 * --getArah(lokasi){ret nama ada di mana}
	 */
}
