package com.BMA.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.BMA.model.TestModel;


@Repository("testDao")
public class TestDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	
	//return the first test info
	public TestModel findTest(){
		Session session = sessionFactory.getCurrentSession();
		return (TestModel)session.get(TestModel.class, 1);
	}
}
