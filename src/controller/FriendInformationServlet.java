package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.FriendsDetailsDao;
import model.FriendDetails;

/**
 * Servlet implementation class FriendInformationServlet
 */
@WebServlet("/FriendInformationServlet")
public class FriendInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FriendInformationServlet() {
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
		FriendsDetailsDao friendsDetailsDao = new FriendsDetailsDao();
		ArrayList<FriendDetails> friendDetails = friendsDetailsDao.searchFriend();
		Gson gson = new Gson();
		String jsonFormat = "{\"friends\":[";
		for (FriendDetails friendDetails2 : friendDetails) {
			jsonFormat += gson.toJson(friendDetails2) + ",";
			//System.out.println(jsonFormat);
		}
		jsonFormat = jsonFormat.substring(0, jsonFormat.lastIndexOf(','));
		jsonFormat += "]}";
		System.out.println(jsonFormat);
		out.write(jsonFormat);
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
