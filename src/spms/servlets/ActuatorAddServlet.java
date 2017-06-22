package spms.servlets;

import spms.dao.ActuatorDao;
import spms.vo.Actuator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
@WebServlet("/actuator/add")
public class ActuatorAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher(
        "/view/actuator/ActuatorForm.jsp");
    rd.forward(request, response);
  }

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      ActuatorDao actuatorDao = (ActuatorDao) sc.getAttribute("actuatorDao");

      actuatorDao.insertActuator(new Actuator()
          .setActuatorId(Integer.parseInt(request.getParameter("actuatorId")))
          .setActuatorName(request.getParameter("actuatorName"))
          .setDeviceId(Integer.parseInt(request.getParameter("deviceId"))));
      response.sendRedirect("/actuator/list");
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
