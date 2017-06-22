package spms.dao;

import spms.vo.Device;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class DeviceDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public List<Device> selectDeviceList() throws Exception {

    String query = "SELECT * FROM device ORDER BY deviceId ASC";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try(ResultSet rs = stmt.executeQuery()){
        ArrayList<Device> devices = new ArrayList<>();
        while (rs.next()) {
          devices.add(new Device()
              .setDeviceId(rs.getInt("deviceId"))
              .setDeviceName(rs.getString("DeviceName"))
              .setUserId(rs.getString("userId")));
        }
        return devices;
      } catch (Exception e){
        throw e;
      }
    } catch (Exception e) {
      throw e;

    }
  }

  public Device selectDevice(int deviceId) throws Exception {
    String query = "SELECT * FROM device WHERE deviceId =" + deviceId;
    try (Connection connection = ds.getConnection();
          PreparedStatement stmt = connection.prepareStatement(query)){
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return new Device()
              .setDeviceId(rs.getInt("deviceId"))
              .setDeviceName(rs.getString("deviceName"))
              .setUserId(rs.getString("userId"));
        } else {
          throw new Exception("해당 부모가 존재하지 않습니다");
        }
      }catch (Exception e){
        throw e;
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public int deleteDevice(int deviceId) throws Exception {
    String query = "DELETE FROM device WHERE deviceId=" + deviceId;
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)){
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }

  public int insertDevice(Device device) throws Exception {
    String query = "INSERT INTO DEVICE(deviceName, userId) VALUES (?,?)";
    try(Connection connection = ds.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, device.getDeviceName());
      stmt.setString(2, device.getUserId());
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }
}
