package com.BMA.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.BookwithSubjectModel;

@Repository("bookwithSubjectDao")
public class BookwithSubjectDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addBookwithSubject(int bookid, int subjectid){
		Session session = sessionFactory.getCurrentSession();
		BookwithSubjectModel newbookwithsubject =new BookwithSubjectModel(); 
		newbookwithsubject.setBookid(bookid);
		newbookwithsubject.setSubjectid(subjectid);
		session.save(newbookwithsubject);
		return newbookwithsubject.getId();
		
	}
}
