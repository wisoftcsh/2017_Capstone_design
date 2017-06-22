package spms.dao;

import spms.vo.Protector;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class ProtectorDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public List<Protector> selectProtectorList() throws Exception {
    String query = "SELECT * FROM protector ORDER BY protectorId ASC";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        ArrayList<Protector> protectors = new ArrayList<>();
        while (rs.next()) {
          protectors.add(new Protector()
              .setProtectorId(rs.getString("protectorId"))
              .setUserId(rs.getString("userId"))
              .setProtectorName(rs.getString("protectorName"))
              .setProtectorEmail(rs.getString("protectorEmail"))
              .setProtectorPhone(rs.getString("protectorEmail")));
        }
        return protectors;
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Protector selectProtector(String protectorId) throws Exception {
    String query = "SELECT * FROM protector WHERE protectorId =" + protectorId;
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return new Protector()
              .setProtectorId(rs.getString("protectorId"))
              .setUserId(rs.getString("userId"))
              .setProtectorName(rs.getString("protectorName"))
              .setProtectorEmail(rs.getString("protectorEmail"))
              .setProtectorPhone(rs.getString("protectorPhone"));
        } else {
          throw new Exception("해당 부모가 존재하지 않습니다");
        }
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public int deleteProtector(String protectorId) throws Exception {
    String query = "DELETE FROM protector WHERE protectorId=" + protectorId;
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }

  public int insertProtector(Protector protector) throws Exception {
    String query = "INSERT INTO PROTECTOR(protectorId, pPasswd, userId, protectorName, protectorEmail, protectorPhone)" +
        "VALUES (?,?,?,?,?,?)";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, protector.getProtectorId());
      stmt.setInt(2, protector.getpPasswd());
      stmt.setString(3, protector.getUserId());
      stmt.setString(4, protector.getProtectorName());
      stmt.setString(5, protector.getProtectorEmail());
      stmt.setString(6, protector.getProtectorPhone());
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }
}
