package spms.vo;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class Sensing {
  protected int sensingId;
  protected int sensorId;
  protected double sensingValue;

  public int getSensingId() {
    return sensingId;
  }

  public Sensing setSensingId(int sensingId) {
    this.sensingId = sensingId;
    return this;
  }

  public int getSensorId() {
    return sensorId;
  }

  public Sensing setSensorId(int sensorId) {
    this.sensorId = sensorId;
    return this;
  }

  public double getSensingValue() {
    return sensingValue;
  }

  public Sensing setSensingValue(double sensingValue) {
    this.sensingValue = sensingValue;
    return this;
  }
}
