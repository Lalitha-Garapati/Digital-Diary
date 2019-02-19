package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class UserDao {

	public boolean insertNewUser(User user) {
		boolean status = false;
		Connection con = null;
		Statement stmt = null;
		int row;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_diary", "root", "root");
			stmt = con.createStatement();
			String sql = "insert into user(name, emailId, password) values('" + user.getName() + "','"
					+ user.getEmailId() + "','" + user.getPassword() + "')";
			row = stmt.executeUpdate(sql);
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

	public User searchUser(String emailId, String password) {
		User user = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_diary", "root", "root");
			stmt = con.createStatement();
			String sql = "select name, emailId, password from user where emailId = '" + emailId + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				user = new User();
				user.setEmailId(rs.getString(2));
				user.setPassword(rs.getString(3));
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
		return user;

	}
}
