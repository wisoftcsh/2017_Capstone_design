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

@WebServlet("/user/info")
public class UserInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      UserDao userDao = (UserDao) sc.getAttribute("userDao");
      User user = userDao.selectUser(request.getParameter("userId"));

      request.setAttribute("user", user);
      RequestDispatcher rd = request.getRequestDispatcher(
          "/view/user/UserInfo.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
