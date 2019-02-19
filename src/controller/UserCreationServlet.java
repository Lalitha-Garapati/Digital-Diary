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

@WebServlet("/UserCreationServlet")
public class UserCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);
		UserDao userDao = new UserDao();
		boolean status = userDao.insertNewUser(user);
		if (status) {
			out.write("{\"status\": \"success\"}");
		} else {
			out.write("{\"status\": \"failure\"}");
		}
	}

}
