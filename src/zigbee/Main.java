package zigbee;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.wpan.RxResponseIoSample;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;

public class Main {
	static String MY_PORT = "/dev/ttyUSB0"; 
	static XBee xbee = new XBee();
	
	public static void main (String[] args) throws XBeeException{

		xbee.open(MY_PORT, 9600);
		
		XBeeResponse response = xbee.getResponse();

		while (true) {
			if (response.getApiId() == ApiId.ZNET_IO_SAMPLE_RESPONSE) {
				ZNetRxIoSampleResponse ioSample = (ZNetRxIoSampleResponse) response;
				System.out.println("RESPONSE "+ ioSample);
				System.out.println("Received a sample from " + ioSample.getRemoteAddress64());
				

				System.out.println("Analog D0 (pin 20) 10-bit reading is " + ioSample.getAnalog0());
				System.out.println("Digital D4 (pin 11) is " + (ioSample.isD4On() ? "on" : "off"));
			}
		}
	}
	
	
}