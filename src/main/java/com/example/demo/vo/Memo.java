package com.example.demo.vo;

import java.util.Date;
import java.util.List;

public class Memo {
	private int id;
	private String content;
	private Date create_date;
	private Date update_date;
	private String writer;
	
	 List<UserFile> fileList;
	 
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
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	 public List<UserFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<UserFile> fileList) {
		this.fileList = fileList;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	

}
