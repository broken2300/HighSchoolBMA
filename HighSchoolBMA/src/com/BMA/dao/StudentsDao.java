package com.BMA.dao;

import java.awt.List;
import java.sql.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.StudentsModel;

@Repository("studentsDao")
public class StudentsDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addStudents(String firstname, String lastname, String parent, Date birthday, String authority){

		Session session = sessionFactory.getCurrentSession();
		StudentsModel newstudent = new StudentsModel();
		newstudent.setFirstname(firstname);
		newstudent.setLastname(lastname);
		newstudent.setAuthority(authority);
		newstudent.setBirthday(birthday);
		newstudent.setParent(parent);
		session.save(newstudent);
		return newstudent.getId();
	}
	
}
