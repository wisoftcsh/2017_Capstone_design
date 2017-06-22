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

@WebServlet("/sensor/add")
public class SensorAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher(
        "/view/sensor/SensorForm.jsp");
    rd.forward(request, response);
  }

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      SensorDao sensorDao = (SensorDao) sc.getAttribute("sensorDao");

      sensorDao.insertSensor(new Sensor()
          .setSensorName(request.getParameter("sensorName"))
          .setDeviceId(Integer.parseInt(request.getParameter("deviceId")))
      );
      response.sendRedirect("/sensor/list");

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
