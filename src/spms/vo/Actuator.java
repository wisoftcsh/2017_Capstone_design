package spms.vo;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class Actuator {
  protected int actuatorId;
  protected int deviceId;
  protected String actuatorName;

  public int getActuatorId() {
    return actuatorId;
  }

  public Actuator setActuatorId(int actuatorId) {
    this.actuatorId = actuatorId;
    return this;
  }

  public int getDeviceId() {
    return deviceId;
  }

  public Actuator setDeviceId(int deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  public String getActuatorName() {
    return actuatorName;
  }

  public Actuator setActuatorName(String actuatorName) {
    this.actuatorName = actuatorName;
    return this;
  }
}
