package model;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FriendDetails {
	String friendName;
	String address;
	Date birthday;
	String mobile;
	String email;

	public String getFriend_name() {
		return friendName;
	}

	public void setFriend_name(String friend_name) {
		this.friendName = friend_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_no() {
		return mobile;
	}

	public void setMobile_no(String mobile2) {
		this.mobile = mobile2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(String date) {
		try {
			this.birthday = new SimpleDateFormat("dd, MMM").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
