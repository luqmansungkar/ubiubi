package osgi_bundle_preferencerepository;

import java.util.Vector;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
public class PreferenceRepositoryService {
	File fi;
	BufferedReader br;
	Vector<EntryPreference> ep;
	
	public PreferenceRepositoryService(){
		loadPreferenceDatabase();
	}
	
	public void loadPreferenceDatabase(){
		fi = new File("input2.txt");
		ep = new Vector<EntryPreference>();
		try{
			br = new BufferedReader(new FileReader(fi));
			String isi ="";
			String name="";
			LinkedArrayList servPref= new LinkedArrayList();
			int count = 0;
			int pos = 0;
			String spl[];
			while((isi=br.readLine())!=null){
				pos = 0;
				count++;
				spl = isi.split(": ");
				name = spl[1];
				try{
				isi = br.readLine();
					while((isi.trim().length())!=0){
						spl = isi.split("pref-[0-9]:\\sjika\\s|\\ssarankan\\s");
						servPref.putObject(spl[1],spl[2]);
						pos++;
						isi = br.readLine();
					}
				}
				catch(Exception e){}
				finally{
					EntryPreference i = new EntryPreference(name, servPref);
					ep.add(i);
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public String getPreference(String pref){
		String data[] = pref.split(",");
		String com = "";
		for(EntryPreference e:ep){
			//com+="Username : "+e.getName()+"\n";
			if((e.getName()).equalsIgnoreCase(data[0])){
				String prior = e.findPriority(data);
				//com+="Keadaan context : \n";
				for(int i=0;i<data.length;i++){
					com+= data[i]+"-";
				}
				com+="\n";
				return com+prior;
					
				}
			else
				continue;
		}
		
		return "Tidak ada tempat yang dipreferensikan";
		
	}
}
