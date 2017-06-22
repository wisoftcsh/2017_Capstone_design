package spms.servlets;

import spms.dao.SensingDao;
import spms.vo.Sensing;

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
@WebServlet("/sensing/add")
public class SensingAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      SensingDao sensingDao = (SensingDao) sc.getAttribute("sensingDao");
      sensingDao.insertSensing(new Sensing()
          .setSensingValue(Double.parseDouble(request.getParameter("sensingValue")))
          .setSensorId(Integer.parseInt(request.getParameter("sensorId")))
      );
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
