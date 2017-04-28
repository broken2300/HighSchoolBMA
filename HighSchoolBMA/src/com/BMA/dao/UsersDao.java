package com.BMA.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.UsersModel;

@Repository("usersDao")
public class UsersDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addUsers(String username, String password, String authority, int userid){
		Session session = sessionFactory.getCurrentSession();
		UsersModel newuser = new UsersModel();
		newuser.setUsername(username);
		newuser.setPassword(password);
		newuser.setUserid(userid);
		session.save(newuser);
		return newuser.getId();
	}
}
