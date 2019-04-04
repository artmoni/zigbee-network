package zigbee;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.goebl.david.Webb;
import org.json.JSONObject;
import com.rapplogic.xbee.api.XBeeAddress64;

public class StoreData {
	final private String URL = "http://163.172.141.214:8002/saveMove/sensor/";
	
	//public void storeData(long sensorId) throws IOException {
	public JSONObject storeData(XBeeAddress64 macAddress) throws IOException {
		Webb webb = Webb.create();
		return	webb.get(URL+macAddress)
		        //.param("macAddress", macAddress)
		        .ensureSuccess()
		        .asJsonObject()
			.getBody();		
	}
}
