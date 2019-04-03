package zigbee;

import java.io.IOException;

import com.rapplogic.xbee.api.XBeeException;

public class Main {
	
	public static void main(String[] args) throws XBeeException, IOException{
		ControlStation controlStation = new ControlStation();
        controlStation.run();
    }
}