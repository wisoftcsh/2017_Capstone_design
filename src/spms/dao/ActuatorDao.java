package spms.dao;

import spms.vo.Actuator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class ActuatorDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public List<Actuator> selectActuatorList() throws Exception {
    String query = "SELECT * FROM actuator ORDER BY actuatorId ASC";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        ArrayList<Actuator> actuators = new ArrayList<>();

        while (rs.next()) {
          actuators.add(new Actuator()
              .setActuatorId(Integer.parseInt(rs.getString("actuatorId")))
              .setActuatorName(rs.getString("actuatorName"))
              .setDeviceId(Integer.parseInt(rs.getString("deviceId"))));
        }
        return actuators;
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Actuator selectActuator(int actuatorId) throws Exception {
    String query = "SELECT * FROM actuator WHERE actuatorId =" + actuatorId;
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return new Actuator()
              .setActuatorId(Integer.parseInt(rs.getString("actuatorId")))
              .setActuatorName(rs.getString("actuatorName"))
              .setDeviceId(Integer.parseInt(rs.getString("deviceId")));
        } else {
          throw new Exception("해당 부모가 존재하지 않습니다");
        }
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public int deleteActuator(int actuatorId) throws Exception {
    String query = "DELETE FROM actuator WHERE actuatorId=" + actuatorId;
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query);){
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }

  public int insertActuator(Actuator actuator) throws Exception {
    String query = "INSERT INTO ACTUATOR(deviceId, actuatorName) VALUES (?,?)";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)){
      stmt.setInt(1, actuator.getDeviceId());
      stmt.setString(2, actuator.getActuatorName());
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }
}
