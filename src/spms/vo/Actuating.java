package spms.vo;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class Actuating {
  protected int actuatingId;
  protected int actuatorId;
  protected String result;

  public int getActuatingId() {
    return actuatingId;
  }

  public Actuating setActuatingId(int actuatingId) {
    this.actuatingId = actuatingId;
    return this;
  }

  public int getActuatorId() {
    return actuatorId;
  }

  public Actuating setActuatorId(int actuatorId) {
    this.actuatorId = actuatorId;
    return this;
  }

  public String getResult() {
    return result;
  }

  public Actuating setResult(String result) {
    this.result = result;
    return this;
  }
}
