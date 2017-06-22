package spms.servlets;

import spms.dao.SensorDao;
import spms.vo.Sensor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/sensor/info")
public class SensorInfoServlet extends HttpServlet {
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      SensorDao sensorDao = (SensorDao) sc.getAttribute("sensorDao");
      Sensor sensor = sensorDao.selectSensor(Integer.parseInt(request.getParameter("sensorId")));

      request.setAttribute("sensor", sensor);
      RequestDispatcher rd = request.getRequestDispatcher(
          "/view/sensor/SensorInfo.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
