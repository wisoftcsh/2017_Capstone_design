package spms.servlets;

import spms.dao.ActuatingDao;
import spms.dao.ActuatorDao;
import spms.vo.Actuating;
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
@WebServlet("/actuator/actuating")
public class ActuatingUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      ActuatingDao actuatingDao = (ActuatingDao) sc.getAttribute("actuatorDao");

      actuatingDao.updateActuating(new Actuating()
          .setResult(request.getParameter("result"))
          .setActuatorId(Integer.parseInt(request.getParameter("actuatorId"))));
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
