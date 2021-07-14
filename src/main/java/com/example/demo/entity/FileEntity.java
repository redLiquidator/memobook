package com.example.demo.entity;


@Entity 
//this is a way of telling jpa&hibernate that this is not an normal java class. the object of this class will be responsible for the 
//updation of the operation
@Table(name="file")
public class FileEntity {
	
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	@Id  //treated as a primary key.
	@Column(name="file_id")
	int file_id;
	
	@Column(name="create_date")
	String create_date;
	@Column(name="filepath")
	String filepath;

}
