package spms.vo;

public class Sensor {
  protected int sensorId;
  protected int deviceId;
  protected String sensorName;

  public int getSensorId() {
    return sensorId;
  }

  public Sensor setSensorId(int sensorId) {
    this.sensorId = sensorId;
    return this;
  }

  public int getDeviceId() {
    return deviceId;
  }

  public Sensor setDeviceId(int deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  public String getSensorName() {
    return sensorName;
  }

  public Sensor setSensorName(String sensorName) {
    this.sensorName = sensorName;
    return this;
  }
}
