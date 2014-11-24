package osgi_bundle_preferencerepository;

import java.util.ArrayList;

public class LinkedArrayList {
	ArrayList<String> key;
	ArrayList<String> value;
	public LinkedArrayList(){
		key = new ArrayList<String>();
		value = new ArrayList<String>();
	}
	
	public void putObject(String a, String b){
		key.add(a);
		value.add(b);
	}
	
	public String findValue(String keyStr){
		int pos = 0;
		for(String k : key){
			if(k.equalsIgnoreCase(keyStr))
				return value.get(pos);
			pos++;
		}
		return "";
	}
	
	public int findPositionOccured(String keyStr){
		int pos = 0;
		for(String k : key){
			if(k.equalsIgnoreCase(keyStr))
				return pos;
			pos++;
		}
		return -1;
	}
	
	public int findMatchedPosition(String keyStr, String valStr){
		int pos = 0;
		for(String k : key){
			if((k.equalsIgnoreCase(keyStr))&&((value.get(pos)).equalsIgnoreCase(valStr)))
				return pos;
			pos++;
		}
		return -1;
	}
	
	public String findValuePosition(int pos){
		return value.get(pos);
		
	}
}