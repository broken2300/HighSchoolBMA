package com.BMA.model;


import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

import org.apache.struts2.components.Set;

@Entity
@Table( name = "bookwithsubject")

public class BookwithSubjectModel {

	@Id  
    @Column(name = "id")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id ;
	@Column(name = "bookid")
	int bookid;
	@Column(name = "subjectid")
	int subjectid;
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public int getId() {
		return id;
	}
	
	
}
