package zigbee;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class ControlStation {
	final static private String MY_PORT = "/dev/ttyUSB0"; 
	static private XBee xbee = new XBee();
	
	public static void run () throws XBeeException {
		System.out.println("plouf");
		xbee.open(MY_PORT, 9600);
		loop();
	}
	
	public static void loop () throws XBeeException {
		while (true) {
			XBeeResponse response = xbee.getResponse();
			if(response.getApiId() == ApiId.ZNET_IO_SAMPLE_RESPONSE) {
				ZNetRxIoSampleResponse ioSample = (ZNetRxIoSampleResponse) response;

			    System.out.println("RESPONSE "+ ioSample);
				System.out.println("Received a sample from " + ioSample.getRemoteAddress64());
				
				System.out.println("Analog D0 (pin 20) 10-bit reading is " + ioSample.getAnalog0());
				System.out.println("Digital D4 (pin 11) is " + (ioSample.isD4On() ? "on" : "off"));
			}
		    
		}
	}
}
