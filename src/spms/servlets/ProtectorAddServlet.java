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
@WebServlet("/protector/add")
public class ProtectorAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher(
        "/view/protector/ProtectorForm.jsp");
    rd.forward(request, response);
  }

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      ProtectorDao protectorDao = (ProtectorDao) sc.getAttribute("protectorDao");

      protectorDao.insertProtector(new Protector()
          .setProtectorId(request.getParameter("protectorId"))
          .setUserId(request.getParameter("userId"))
          .setProtectorName(request.getParameter("protectorName"))
          .setProtectorEmail(request.getParameter("protectorEmail"))
          .setProtectorPhone(request.getParameter("protectorPhone"))
          .setpPasswd(Integer.parseInt(request.getParameter("pPasswd")))
      );
      response.sendRedirect("/protector/list");
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
