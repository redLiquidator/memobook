package com.example.demo.vo;

import java.util.Date;

public class User {
	private String user_id;
	private String authority;
	private Date create_date;
	private Date last_login_date;
	private String password;
  
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getLast_login_date() {
		return last_login_date;
	}
	public void setLastlogin_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
