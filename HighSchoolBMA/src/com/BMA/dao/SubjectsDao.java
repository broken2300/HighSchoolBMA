package com.BMA.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.SubjectsModel;

@Repository("subjectsDao")
public class SubjectsDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addSubjects(String name){
		Session session = sessionFactory.getCurrentSession();
		SubjectsModel newsubject = new SubjectsModel();
		newsubject.setName(name);
		session.save(newsubject);
		return newsubject.getId();
		
	}
}
