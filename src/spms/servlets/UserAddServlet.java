package spms.servlets;

import spms.dao.UserDao;
import spms.vo.User;

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

@WebServlet("/user/add")
public class UserAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher(
        "/view/user/UserAddForm.jsp");
    rd.forward(request, response);
  }

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      UserDao userDao = (UserDao) sc.getAttribute("userDao");

      userDao.insertUser(new User()
        .setUserId(request.getParameter("userId"))
        .setUserName(request.getParameter("userName"))
        .setuPasswd(Integer.parseInt(request.getParameter("uPasswd"))));

//      response.sendRedirect("login");
      response.sendRedirect("/main");
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
