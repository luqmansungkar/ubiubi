package osgi_bundle_preferencerepository;

public class EntryPreference {
	String name;
	LinkedArrayList hm;
	
	public EntryPreference(){
		this.name="";
		hm = new LinkedArrayList();
	}
	
	public EntryPreference(String name, LinkedArrayList hm){
		this.name = name;
		this.hm = hm;
		
	}
	
	public String getName(){
		return this.name;
		
	}
	
	public String findPriority(String[] data){
		int min = 10;
		int temp = 0;
		for(int i=1;i<data.length-1;i++){
			temp = hm.findPositionOccured(data[i]);
			if(temp < min && temp!= -1)
				min = temp;
			
		}
		
		if(min>=0 && min<=2)
			return hm.findValuePosition(min);
		else
			return "Tidak ada preferensi";
	}
	
}
