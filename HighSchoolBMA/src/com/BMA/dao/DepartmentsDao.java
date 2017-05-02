package com.BMA.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.DepartmentsModel;

@Repository("departmentsDao")
public class DepartmentsDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int addDepartments(String name){
		Session session = sessionFactory.getCurrentSession();
		DepartmentsModel newdepartment = new DepartmentsModel();
		newdepartment.setName(name);
		session.save(newdepartment);
		return newdepartment.getId();
	}
}
