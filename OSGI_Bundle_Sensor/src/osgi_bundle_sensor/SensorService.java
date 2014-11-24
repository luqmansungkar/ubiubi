package osgi_bundle_sensor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import osgi_bundle_contextmanager.ContextManagerService;

public class SensorService {

	private ContextManagerService contextManagerService;
	private Random randomGenerator = new Random();
	private Timer timer;
	
//	public SensorService(ContextManagerService newContextManagerService){
//		
//	}
	
	public SensorService(ContextManagerService cms) {
		// TODO Auto-generated constructor stub
		timer = new Timer();
		this.contextManagerService = cms;
		run();
	}

	public void run(){
		timer.schedule(new TimerTask(){
			public void run() {
				contextManagerService.setTemperatur(getTemperature());
				contextManagerService.setWaktu(getTime());
				contextManagerService.setCuaca(getCuaca());
			}
		},0,60000);
	}
	
	private String getTemperature() {
		return Integer.toString(randomGenerator.nextInt(30));
	}
	
	private String getCuaca() {
		int i = randomGenerator.nextInt(2);
		switch (i) {
			case 0 : return "berawan";
			case 1 : return "hujan";
			default : return "cerah";
		}
	}
	
	private String getTime() {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	return ( sdf.format(cal.getTime()) );
	}
}
