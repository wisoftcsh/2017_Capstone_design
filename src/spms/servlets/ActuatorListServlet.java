package spms.servlets;

import spms.dao.ActuatorDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by choiseonho on 2017. 5. 29..
 */
public class ActuatorListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      ActuatorDao actuatorDao = (ActuatorDao) sc.getAttribute("actuatorDao");

      request.setAttribute("protectors", actuatorDao.selectActuatorList());

      response.setContentType("text/html; charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher(
          "/view/actuator/ActuatorList.jsp");
      rd.include(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
