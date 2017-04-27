package com.BMA.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

import org.apache.struts2.components.Set;

@Entity
@Table( name = "books")

public class BooksModel {

	@Id  
    @Column(name = "id")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	int id ;
	@Column(name = "name")
	String name;
	@Column(name = "author")
	String author;
	@Column(name = "ISBN")
	String ISBN;
	@Column(name = "edition")
	int edition;
	
	public BooksModel() {
		
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	
}
