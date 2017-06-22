package spms.dao;

import spms.vo.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class UserDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public int insertUser(User user) throws Exception {
    String query = "INSERT INTO USER(userId, userName, uPasswd) VALUES (?,?,?)";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, user.getUserId());
      stmt.setString(2, user.getUserName());
      stmt.setInt(3, user.getuPasswd());
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }

  public List<User> selectUserList() throws Exception {
    String query = "SELECT * FROM user ORDER BY userId ASC";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        ArrayList<User> users = new ArrayList<>();
        while (rs.next()) {
          users.add(new User()
              .setUserName(rs.getString("userName"))
              .setUserId(rs.getString("userId"))
          );
        }
        return users;
      } catch (Exception e) {
        throw e;
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public User selectUser(String userId) throws Exception {
    String query = "SELECT * FROM user WHERE userid =" + userId;
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return new User()
              .setUserId(rs.getString("userId"))
              .setUserName(rs.getString("userName"));
        } else {
          throw new Exception("해당 아이디가 존재하지 않습니다");
        }
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public int deleteUser(String userId) throws Exception {
    String query = "DELETE FROM user WHERE userId=" + userId;
    try (Connection connection = ds.getConnection();
    PreparedStatement stmt = connection.prepareStatement(query)) {
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }
}
