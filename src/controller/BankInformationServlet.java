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

import dao.BankDetailsDao;
import model.BankDetails;

/**
 * Servlet implementation class BankInformationServlet
 */
@WebServlet("/BankInformationServlet")
public class BankInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankInformationServlet() {
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
		BankDetailsDao bankDetailsDao = new BankDetailsDao();
		ArrayList<BankDetails> bankDetails = bankDetailsDao.searchAccount();
		Gson gson = new Gson();
		String jsonFormat = "{\"accounts\":[";
		for (BankDetails bankDetails2 : bankDetails) {
			jsonFormat += gson.toJson(bankDetails2) + ",";
		}
		jsonFormat = jsonFormat.substring(0,jsonFormat.lastIndexOf(','));
		jsonFormat += "]}";
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
