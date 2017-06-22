package spms.servlets;

import spms.dao.ProtectorDao;
import spms.vo.Protector;

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
@WebServlet("/protector/info")
public class ProtectorInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      ProtectorDao protectorDao = (ProtectorDao) sc.getAttribute("protectorDao");
      Protector protector = protectorDao.selectProtector(request.getParameter("protectorId"));

      request.setAttribute("protector", protector);
      RequestDispatcher rd = request.getRequestDispatcher(
          "/view/protector/ProtectorInfo.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
