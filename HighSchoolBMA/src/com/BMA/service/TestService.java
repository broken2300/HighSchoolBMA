package com.BMA.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMA.dao.TestDao;
import com.BMA.model.TestModel;


@Service
public class TestService  {
	
	@Resource(name="testDao")
	TestDao testDao;

    public TestModel findTest(){
    	return testDao.findTest();	
	}

}
