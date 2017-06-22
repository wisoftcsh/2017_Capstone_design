package spms.servlets;

import spms.dao.DeviceDao;
import spms.dao.SensorDao;
import spms.vo.Device;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sensor/list")
public class SensorListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      SensorDao sensorDao = (SensorDao) sc.getAttribute("sensorDao");
      DeviceDao deviceDao = (DeviceDao) sc.getAttribute("deviceDao");

      Device device = deviceDao.selectDevice(Integer.parseInt(request.getParameter("deviceId")));
      request.setAttribute("device", device);
      request.setAttribute("sensors", sensorDao.selectSensorList(Integer.parseInt(request.getParameter("deviceId"))));

      response.setContentType("text/html; charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher(
          "/view/sensor/SensorList.jsp");
      rd.include(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
