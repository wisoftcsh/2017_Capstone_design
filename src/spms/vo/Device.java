package spms.vo;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class Device {
  protected int deviceId;
  protected String userId;
  protected String deviceName;

  public int getDeviceId() {
    return deviceId;
  }

  public Device setDeviceId(int deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  public String getUserId() {
    return userId;
  }

  public Device setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public Device setDeviceName(String deviceName) {
    this.deviceName = deviceName;
    return this;
  }
}
