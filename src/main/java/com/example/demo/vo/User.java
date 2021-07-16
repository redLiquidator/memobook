package com.example.demo.vo;

public class User {
	private int user_id;
	private String authority;
	private String create_date;
	private String lastlogin_date;
	private String password;
  
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getLastlogin_date() {
		return lastlogin_date;
	}
	public void setLastlogin_date(String lastlogin_date) {
		this.lastlogin_date = lastlogin_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
