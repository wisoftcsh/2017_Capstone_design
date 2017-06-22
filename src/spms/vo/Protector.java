package spms.vo;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class Protector {
  protected String protectorId;
  protected String userId;
  protected String protectorName;
  protected String protectorEmail;
  protected String protectorPhone;
  protected int pPasswd;

  public int getpPasswd() {
    return pPasswd;
  }

  public Protector setpPasswd(int pPasswd) {
    this.pPasswd = pPasswd;
    return this;
  }

  public String getUserId() {
    return userId;
  }

  public Protector setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public String getProtectorName() {
    return protectorName;
  }

  public Protector setProtectorName(String protectorName) {
    this.protectorName = protectorName;
    return this;
  }

  public String getProtectorEmail() {
    return protectorEmail;
  }

  public Protector setProtectorEmail(String protectorEmail) {
    this.protectorEmail = protectorEmail;
    return this;
  }

  public String getProtectorPhone() {
    return protectorPhone;
  }

  public Protector setProtectorPhone(String protectorPhone) {
    this.protectorPhone = protectorPhone;
    return this;
  }

  public String getProtectorId() {
    return protectorId;
  }

  public Protector setProtectorId(String protectorId) {
    this.protectorId = protectorId;
    return this;
  }
}
