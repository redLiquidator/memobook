package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Id  //treated as a primary key.
	@Column(name="id")
	int id;
	
	@Column(name="content")
	String content;
	@Column(name="create_date")
	Date create_date;
	@Column(name="update_date")
	Date update_date;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="file_id",insertable=false,updatable=false)
	List<FileEntity> fileEntity;
	
	public List<FileEntity> getFileEntity(){
		return fileEntity; 
		}
	public void setFileEntity(List<FileEntity> fileEntity){
		this.fileEntity = fileEntity;
	}

	  //referencedkey is only for primary key
	  @ManyToOne(cascade = CascadeType.ALL)  
	  @JoinColumn(name = "id", insertable =false,updatable = false) 
	  UserEntity userEntity;
	 

	
	
	

}
