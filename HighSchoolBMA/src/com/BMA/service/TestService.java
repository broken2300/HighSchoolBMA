package com.BMA.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMA.dao.TestDao;
import com.BMA.dao.UserDao;
import com.BMA.model.TestModel;
import com.BMA.model.UserModel;


@Service
@Transactional
public class TestService  {
	
	@Resource
	TestDao testDao;
	@Resource
	UserDao	userDao;

    public UserModel findTest(){
    	
    	String param = "username";
    	String valueString = "ban";
    	//if(userDao.selectUserByName(valueString) != null){
        	UserModel userModel = userDao.selectUserByString(param, valueString).get(0);
        	return userModel;
    	//}
    	//else {
			//return null;
		//}    	
	}

}