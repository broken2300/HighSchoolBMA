package com.BMA.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.StudentwithSubjectModel;

@Repository ("studentwithSubjectDao")
public class StudentwithSubjectDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addStudentwithSubject(int studentid, int subjectid){
		Session session = sessionFactory.getCurrentSession();
		StudentwithSubjectModel newstudentwithsubject = new StudentwithSubjectModel();
		newstudentwithsubject.setStudentid(studentid);
		newstudentwithsubject.setSubjectid(subjectid);
		session.save(newstudentwithsubject);
		return newstudentwithsubject.getId();
	}
}
