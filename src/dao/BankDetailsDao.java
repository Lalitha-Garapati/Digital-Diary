package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.BankDetails;

public class BankDetailsDao {
	public boolean insertNewAccount(BankDetails bankDetails) {
		boolean status = false;
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_diary", "root", "root");
			stmt = con.createStatement();
			System.out.println(bankDetails.getLocation());
			String sql = "insert into bankAccount(user_name, account_no, bank_name, location) values('"
					+ bankDetails.getUser_name() + "','" + bankDetails.getAccount_no() +"','"
					+ bankDetails.getBank_name() + "','" + bankDetails.getLocation() + "')";
			System.out.println("Location" + bankDetails.getLocation() + "\n");
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

	public ArrayList<BankDetails> searchAccount() {
		ArrayList<BankDetails> bankDetails = new ArrayList<BankDetails>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_diary", "root", "root");
			stmt = con.createStatement();
			String sql = "select * from bankAccount";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BankDetails bankDetails2 = new BankDetails();
				bankDetails2.setUser_name(rs.getString(1));
				bankDetails2.setAccount_no(rs.getString(2));
				bankDetails2.setBank_name(rs.getString(3));
				bankDetails2.setLocation(rs.getString(4));
				bankDetails.add(bankDetails2);
				System.out.println(bankDetails);
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
		return bankDetails;
	}
}
