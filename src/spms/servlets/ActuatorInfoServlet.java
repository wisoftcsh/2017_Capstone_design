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

@WebServlet("/actuator/list")
public class ActuatorInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      ActuatorDao actuatorDao = (ActuatorDao) sc.getAttribute("actuatorDao");
      Actuator actuator = actuatorDao.selectActuator(Integer.parseInt(request.getParameter("actuatorId")));

      request.setAttribute("actuator", actuator);
      RequestDispatcher rd = request.getRequestDispatcher(
          "/view/actuator/ActuatorInfo.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
