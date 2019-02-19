package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.RemainderDetails;

public class RemainderDetailsDao {
	public boolean insertNewRemainder(RemainderDetails remainderDetails) {
		boolean status = false;
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_diary", "root", "root");
			stmt = con.createStatement();
			String sql = "insert into remainder(title,description,date_day) values('" + remainderDetails.getTitle()
					+ "','" + remainderDetails.getDescription() + "','" + remainderDetails.getDate_day() + "')";

			int row = stmt.executeUpdate(sql);
			System.out.println(row);
			if (row != 0) {
				status = true;
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return status;
	}

	@SuppressWarnings("null")
	public ArrayList<RemainderDetails> searchRemainder() {
		ArrayList<RemainderDetails> remainderDetails2 = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_diary", "root", "root");
			stmt = con.createStatement();
			String sql = "select * from remainder";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				RemainderDetails remainderDetails21 = new RemainderDetails();
				remainderDetails21.setTitle(rs.getString(1));
				System.out.println(rs.getString(1));
				remainderDetails21.setDescription(rs.getString(2));
				System.out.println(rs.getString(2));
				/*remainderDetails21.setDate_day(rs.getString(3));
				System.out.println(rs.getString(3));*/
				remainderDetails2.add(remainderDetails21);
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return remainderDetails2;
	}

}