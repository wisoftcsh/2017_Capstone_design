package spms.servlets;

import spms.dao.DeviceDao;
import spms.vo.Device;

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
@WebServlet("/device/info")
public class DeviceInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      DeviceDao deviceDao = (DeviceDao) sc.getAttribute("deviceDao");
      Device device = deviceDao.selectDevice(Integer.parseInt(request.getParameter("deviceId")));

      request.setAttribute("device", device);
      RequestDispatcher rd = request.getRequestDispatcher(
          "/view/device/DeviceInfo.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
