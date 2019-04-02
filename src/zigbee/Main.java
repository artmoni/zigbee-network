package zigbee;

import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.wpan.RxResponseIoSample;

public class Main {
	static String MY_PORT = "/dev/ttyUSB0"; 
	static XBee xbee = new XBee();
	
	public static void main (String[] args) throws XBeeException{
		system.out.println("test");
		xbee.open(MY_PORT, 9600);
		System.out.println("test");
		
		while (true) {
		    RxResponseIoSample ioSample = (RxResponseIoSample) xbee.getResponse();

		    System.out.println("We received a sample from " + ioSample.getSourceAddress());	
					
		    if (ioSample.containsAnalog()) {
		        System.out.println("10-bit temp reading (pin 19) is " + ioSample.getSamples()[0].getAnalog1());
		    }
		}
	}
}
