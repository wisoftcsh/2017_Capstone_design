package spms.dao;

import spms.vo.Sensing;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class SensingDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public int insertSensing(Sensing sensing) throws Exception {
    String query = "INSERT INTO SENSING(sensorId, sensingValue) VALUES (?,?)";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)){
      stmt.setInt(1, sensing.getSensorId());
      stmt.setDouble(2, sensing.getSensingValue());
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }

  public List<Sensing> selectSensingList(int sensorId) throws Exception {
    String query = "SELECT * FROM sensing WHERE sensorId=" + sensorId + " ORDER BY inputtime DESC LIMIT 100";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
      try (ResultSet rs = stmt.executeQuery()) {
        ArrayList<Sensing> sensings = new ArrayList<>();
        while (rs.next()) {
          sensings.add(new Sensing()
              .setSensorId(rs.getInt("sensorId"))
              .setSensingValue(Double.parseDouble(rs.getString("sensingValue"))));
        }
        return sensings;
      }
    } catch (Exception e) {
      throw e;
    }
  }
}
