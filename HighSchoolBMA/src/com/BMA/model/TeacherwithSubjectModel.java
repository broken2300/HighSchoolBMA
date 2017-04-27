package com.BMA.model;

import java.sql.Date;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

import org.apache.struts2.components.Set;

@Entity
@Table( name = "teacherwithsubject")
public class TeacherwithSubjectModel {

	@Id  
    @Column(name = "id")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id ;
	@Column (name = "teacherid")
	int teacherid;
	@Column (name = "subjectid")
	int subjectid;
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
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
