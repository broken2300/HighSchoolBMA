package com.BMA.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.BooksModel;

@Repository("booksDao")
public class BooksDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addBooks(String name, String author, int edition, String ISBN){
		Session session = sessionFactory.getCurrentSession();
		BooksModel newbook =new BooksModel();
		newbook.setName(name);
		newbook.setAuthor(author);
		newbook.setEdition(edition);
		newbook.setISBN(ISBN);
		session.save(newbook);
		return newbook.getId();
	}
}
