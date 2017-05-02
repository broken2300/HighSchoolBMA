package com.BMA.dao;

import java.sql.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.StaffsModel;

@Repository("staffsDao")
public class StaffsDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addStaffs(String firstname, String lastname, Date birthday, String authority){
		Session session =sessionFactory.getCurrentSession();
		StaffsModel newstaff = new StaffsModel();
		newstaff.setFirstname(firstname);
		newstaff.setLastname(lastname);
		newstaff.setBirthday(birthday);
		newstaff.setAuthority(authority);
		session.save(newstaff);
		return newstaff.getId();
	}
}
