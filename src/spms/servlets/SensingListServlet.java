package spms.servlets;

import spms.dao.SensingDao;

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
@WebServlet("/sensing/list")
public class SensingListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      SensingDao sensingDao = (SensingDao) sc.getAttribute("sensingDao");

      request.setAttribute("sensings", sensingDao.selectSensingList(Integer.parseInt(request.getParameter("sensorId"))));

      response.setContentType("text/html; charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher(
          "/view/sensing/SensingList.jsp");
      rd.include(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
