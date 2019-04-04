package zigbee;

import com.rapplogic.xbee.api.XBeeAddress64;

public class Sensor {
	
	private XBeeAddress64 sensorAddress;

	Sensor(XBeeAddress64 sensorAddress){
		this.setAddress(sensorAddress);
	}

	public XBeeAddress64 getAddress() {
		return sensorAddress;
	}

	public void setAddress(XBeeAddress64  sensorAddress) {
		this.sensorAddress = sensorAddress;
	}
	
	/*
	 * public SensorResult getMovement() { //SensorResult result = new
	 * SensorResult(); return result; }
	 */
}
