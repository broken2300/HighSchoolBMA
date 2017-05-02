package com.BMA.dao;

import java.sql.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.TeachersModel;

@Repository("teachesrDao")
public class TeachersDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addTeachers(String firstname, String lastname, Date birthday, String authority){
		Session session = sessionFactory.getCurrentSession();
		TeachersModel newteacher = new TeachersModel();
		newteacher.setFirstname(firstname);
		newteacher.setLastname(lastname);
		newteacher.setBirthday(birthday);
		newteacher.setAuthority(authority);
		session.save(newteacher);
		return newteacher.getId();
		
	}

}
