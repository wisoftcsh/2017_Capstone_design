package spms.listeners;

// 서버에서 제공하는 DataSource 사용하기
import spms.dao.ActuatingDao;
import spms.dao.ActuatorDao;
import spms.dao.DeviceDao;
import spms.dao.ProtectorDao;
import spms.dao.SensingDao;
import spms.dao.SensorDao;
import spms.dao.UserDao;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      ServletContext sc = event.getServletContext();
      
      InitialContext initialContext = new InitialContext();
      DataSource ds = (DataSource)initialContext.lookup(
          "java:comp/env/jdbc/space");

      UserDao userDao = new UserDao();
      userDao.setDataSource(ds);
      sc.setAttribute("userDao", userDao);

      ProtectorDao protectorDao = new ProtectorDao();
      protectorDao.setDataSource(ds);
      sc.setAttribute("protectorDao", protectorDao);

      DeviceDao deviceDao = new DeviceDao();
      deviceDao.setDataSource(ds);
      sc.setAttribute("deviceDao", deviceDao);

      SensorDao sensorDao = new SensorDao();
      sensorDao.setDataSource(ds);
      sc.setAttribute("sensorDao", sensorDao);

      SensingDao sensingDao = new SensingDao();
      sensingDao.setDataSource(ds);
      sc.setAttribute("sensingDao", sensingDao);

      ActuatorDao actuatorDao = new ActuatorDao();
      actuatorDao.setDataSource(ds);
      sc.setAttribute("actuatorDao", actuatorDao);

      ActuatingDao actuatingDao = new ActuatingDao();
      actuatingDao.setDataSource(ds);
      sc.setAttribute("actuatingDao", actuatingDao);

    } catch(Throwable e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}
