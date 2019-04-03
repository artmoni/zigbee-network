package zigbee;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.goebl.david.Webb;

public class StoreData {
	final private String URL = "https://jsonplaceholder.typicode.com/posts/";
	
	public void storeData(long sensorId, long timestamp) throws IOException {
		URL url = new URL(URL);
		/*
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("GET");
		OutputStreamWriter out = new OutputStreamWriter(
		httpCon.getOutputStream());
		System.out.println(httpCon.getResponseCode());
		System.out.println(httpCon.getResponseMessage());
		out.close();
		*/
		Webb webb = Webb.create();
		webb.post(URL)
		        .param("sensorId", sensorId)
		        .param("timestamp", timestamp)
		        .ensureSuccess()
		        .asVoid();
	}
}
