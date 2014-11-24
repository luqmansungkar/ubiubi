package osgi_bundle_sensor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SensorService {

	private Random randomGenerator = new Random();
	private Timer timer;
	
	public SensorService(){
		timer = new Timer();
	}
	
	public void run(){
		timer.schedule(new TimerTask(){
			public void run() {
				System.out.println("Hello World!!");
				System.out.println("temperature "+getTemperature());
				System.out.println("cuaca "+getCuaca());
				System.out.println("Time "+getTime());
			}
		},0,120000);
	}
	
	private int getTemperature() {
		return randomGenerator.nextInt(30);
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
