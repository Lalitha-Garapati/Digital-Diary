package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserInformationServlet
 */
@WebServlet("/UserInformationServlet")
public class UserInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		UserDao userDao = new UserDao();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User users = userDao.searchUser(email, password);
		if (users.getEmailId().equals(email) && users.getPassword().equals(password)) {
			out.write("{\"status\":\"success\"}");
		} else {
			out.write("{\"status\":\"failure\"}");
		}
	}
}
