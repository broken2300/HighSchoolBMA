package com.BMA.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.TeacherwithSubjectModel;

@Repository ("teacherwithSubjectDao")
public class TeacherwithSubjectDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addTeacherwithSubject(int teacherid, int subjectid){
		Session session =sessionFactory.getCurrentSession();
		TeacherwithSubjectModel newteacherwithsubject = new TeacherwithSubjectModel();
		newteacherwithsubject.setTeacherid(teacherid);
		newteacherwithsubject.setSubjectid(subjectid);
		session.save(newteacherwithsubject);
		return newteacherwithsubject.getId();
	}
}
