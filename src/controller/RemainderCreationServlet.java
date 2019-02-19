package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RemainderDetailsDao;
import model.RemainderDetails;

/**
 * Servlet implementation class RemainderCreationServlet
 */
@WebServlet("/RemainderCreationServlet")
public class RemainderCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemainderCreationServlet() {
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
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String date_day = request.getParameter("date_day");
		RemainderDetails remainderDetails = new RemainderDetails();
		remainderDetails.setTitle(title);
		remainderDetails.setDescription(description);
		remainderDetails.setDate_day(date_day);
		RemainderDetailsDao remainderDetailsDao = new RemainderDetailsDao();
		boolean status = remainderDetailsDao.insertNewRemainder(remainderDetails);
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
