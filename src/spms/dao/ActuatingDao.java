package spms.dao;

import spms.vo.Actuating;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class ActuatingDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public int updateActuating(Actuating actuating) throws Exception {
    String query = "UPDATE INTO ACTUATING(actuatorId, result) VALUES (?,?)";
    try (Connection connection = ds.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)){
      stmt.setInt(1, actuating.getActuatorId());
      stmt.setString(2, actuating.getResult());
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }
}
