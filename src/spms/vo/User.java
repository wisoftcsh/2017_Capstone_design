package spms.vo;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class User {
  protected String userId;
  protected String userName;
  protected int uPasswd;

  public int getuPasswd() {
    return uPasswd;
  }

  public User setuPasswd(int uPasswd) {
    this.uPasswd = uPasswd;
    return this;
  }

  public String getUserId() {
    return userId;
  }

  public User setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public User setUserName(String userName) {
    this.userName = userName;
    return this;
  }
}
