package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.FriendDetails;

public class FriendsDetailsDao {
	public boolean insertNewFriend(FriendDetails friendDetails) {
		boolean status = false;
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_diary", "root", "root");
			stmt = con.createStatement();
			System.out.println("hello");
			String sql = "insert into friends(friend_name,address,birthday,mobile_no,email) values('"
					+ friendDetails.getFriend_name() + "','" + friendDetails.getAddress() + "','"
					+ friendDetails.getBirthday() + "','" + friendDetails.getMobile_no() + "','"
					+ friendDetails.getEmail() + "')";
			int row = stmt.executeUpdate(sql);
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

	public ArrayList<FriendDetails> searchFriend() {
		ArrayList<FriendDetails> friendDetails = new ArrayList<FriendDetails>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_diary", "root", "root");
			stmt = con.createStatement();
			String sql = "select * from friends";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				FriendDetails friendDetails1 = new FriendDetails();
				friendDetails1.setFriend_name(rs.getString(1));
				friendDetails1.setAddress(rs.getString(2));
				friendDetails1.setBirthday(rs.getString(3));
				friendDetails1.setMobile_no(rs.getString(4));
				friendDetails1.setEmail(rs.getString(5));
				friendDetails.add(friendDetails1);
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException cnfe) {
			cnfe.printStackTrace();
		} catch (Exception sqle) {
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
		return friendDetails;
	}

}
