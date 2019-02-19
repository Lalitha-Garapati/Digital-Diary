package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FriendsDetailsDao;
import model.FriendDetails;

/**
 * Servlet implementation class FriendsCreationServlet
 */
@WebServlet("/FriendsCreationServlet")
public class FriendsCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FriendsCreationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String friendName = request.getParameter("friendName");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		FriendDetails friendDetails = new FriendDetails();
		friendDetails.setFriend_name(friendName);
		friendDetails.setAddress(address);
		friendDetails.setBirthday(birthday);
		friendDetails.setMobile_no(mobile);
		friendDetails.setEmail(email);
		FriendsDetailsDao friendsDetailsDao = new FriendsDetailsDao();
		boolean status = friendsDetailsDao.insertNewFriend(friendDetails);
		if (status) {
			out.write("{\"status\": \"success\"}");
		} else {
			out.write("{\"status\": \"failure\"}");
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
