package zigbee;

import java.util.HashMap;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class ControlStation {
	//final static private String MY_PORT = "/dev/ttyUSB0"; 
	final static private String MY_PORT = "SLAB_USBtoUART"; 
	private XBee xbee = new XBee();
	private HashMap<XBeeAddress64, Sensor> sensors = new HashMap<XBeeAddress64, Sensor>();
	
	public void run () {
		try {
			xbee.open(MY_PORT, 9600);
			loop();
		}catch(Exception e) {
			System.out.println("Error on opening port");
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void loop () throws XBeeException {
		while (true) {
			XBeeResponse response = xbee.getResponse();
			if(response.getApiId() == ApiId.ZNET_IO_SAMPLE_RESPONSE) {
				ZNetRxIoSampleResponse ioSample = (ZNetRxIoSampleResponse) response;
				if(!sensors.containsKey(ioSample.getRemoteAddress64())) {
					Sensor sensor = new Sensor(ioSample.getRemoteAddress64());
					sensors.put(ioSample.getRemoteAddress64(), sensor);
					System.out.println("Sensor added");
				}

			    System.out.println("RESPONSE "+ ioSample);
				System.out.println("Received a sample from " + ioSample.getRemoteAddress64());
				
				System.out.println("Analog D0 (pin 20) 10-bit reading is " + ioSample.getAnalog0());
				System.out.println("Digital D4 (pin 11) is " + (ioSample.isD4On() ? "on" : "off"));
			}
		    
		}
	}
}
