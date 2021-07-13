package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
//this is a way of telling jpa&hibernate that this is not an normal java class. the object of this class will be responsible for the 
//updation of the operation
@Table(name="memo")
public class MemoEntity {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
	@Id  //treated as a primary key.
	@Column(name="id")
	int id;
	
	@Column(name="content")
	String content;
	@Column(name="create_date")
	String create_date;
	@Column(name="update_date")
	String update_date;

	
	
	

}
