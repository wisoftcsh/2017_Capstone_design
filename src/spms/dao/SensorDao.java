package spms.dao;

import spms.vo.Sensor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SensorDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public List<Sensor> selectSensorList(int deviceId) throws Exception {
    String query = "SELECT * FROM sensor WHERE deviceId=" + deviceId + " ORDER BY sensorId ASC";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        ArrayList<Sensor> sensors = new ArrayList<>();
        while (rs.next()) {
          sensors.add(new Sensor()
              .setSensorId(rs.getInt("sensorId"))
              .setSensorName(rs.getString("sensorName"))
              .setDeviceId(rs.getInt("deviceId")));
        }
        return sensors;
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Sensor selectSensor(int sensorId) throws Exception {
    String query = "SELECT * FROM sensor WHERE sensorId=" + sensorId;
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return new Sensor()
              .setSensorId(rs.getInt("sensorId"))
              .setSensorName(rs.getString("sensorName"))
              .setDeviceId(rs.getInt("deviceId"));
        } else {
          throw new Exception("해당 번호의 센서를 찾을 수 없습니다.");
        }
      } catch (Exception e) {
        throw e;
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public int deleteSensor(int sensorId) throws Exception {
    String query = "DELETE FROM sensor WHERE sensorId=" + sensorId;
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }

  public int insertSensor(Sensor sensor) throws Exception {
    String query = "INSERT INTO SENSOR(deviceId, sensorName)" + " VALUES (?,?)";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, sensor.getDeviceId());
      stmt.setString(2, sensor.getSensorName());
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;
    }
  }
}
