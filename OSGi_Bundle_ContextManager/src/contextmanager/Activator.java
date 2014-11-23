package contextmanager;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World!! haha");
		BufferedReader br = null;
		String json = "";
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Luqman Sungkar\\workspaceSecond\\ContextManager\\src\\contextmanager\\tes.json"));
			json = br.readLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		JSONObject obj = new JSONObject(json);
		JSONArray arr = obj.getJSONArray("phoneNumber");
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr.getJSONObject(i).getString("type"));
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!! haha");
	}

}
