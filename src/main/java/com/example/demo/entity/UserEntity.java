package com.example.demo.entity;

@Entity 
//this is a way of telling jpa&hibernate that this is not an normal java class. the object of this class will be responsible for the 
//updation of the operation
@Table(name="user")
public class UserEntity {
	
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Id  //treated as a primary key.
	@Column(name="user_id")
	int user_id;
	
	@Column(name="create_date")
	String create_date;
	@Column(name="lastLogin_date")
	String lastLogin_date;
	@Column(name="authority")
	String authority;
	@Column(name="password")
	String password;
}
