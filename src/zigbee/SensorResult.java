package zigbee;

public class SensorResult {
	private long sensorId;
	private long timestamp;
	
	SensorResult(long sensorId){
		this.sensorId = sensorId;
	}
	
	SensorResult(long sensorId, long timestamp){
		this.sensorId = sensorId;
		this.timestamp = timestamp;
	}
	
	public long getSensorId() {
		return sensorId;
	}
	public void setSensorId(long sensorId) {
		this.sensorId = sensorId;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
