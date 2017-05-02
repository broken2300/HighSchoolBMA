package com.BMA.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.BMA.model.UserModel;

@Repository("userDao")
public class UserDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public UserModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (UserModel)session.get(UserModel.class, 1);
		//}
		
		public int addUser(UserModel user)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        int i =(Integer) session.save(user);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	        return i;
	    }  
	  
	    public void delUser(int userId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        UserModel u = new UserModel();
	        u.setUserid(userId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateUser(UserModel user) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(user);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	          
	    }  
	  
	    //todo
	    
	    public List<UserModel> selectUserByString(String param, String value)  {  
	        List<UserModel> users = new ArrayList<UserModel>();  
	        
        	Session session = sessionFactory.openSession();
    
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        String hqlString = " From UserModel u where u."+ param + "='" + value+"'";
	        if(param == null){
	        	hqlString = "From StudentModel";
	        }
	        if(session.createQuery(hqlString) != null){
		        List list = session.createQuery(hqlString).list();  
		        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
		        	UserModel u = (UserModel) iterator.next();  
		            users.add(u);  
		        }  
		        tc.commit();
		        session.close();  
		        return users;  
	        }
	        else 
	        {
	        	tc.commit();
	        	return null;
	        }

	    }  
	    
	    public List<UserModel> selectUserByInt(String param, int value)  {  
	        List<UserModel> users = new ArrayList<UserModel>();  
	        
        	Session session = sessionFactory.openSession();
        	//Transaction tc = (Transaction) session.beginTransaction();  
	        
	        String hqlString = "From UserModel u where u."+ param + "='" + value +"'";
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	UserModel u = (UserModel) iterator.next();  
	            users.add(u);  
	        }  
	       
	        session.close();  
	        return users;  
	    }  
	    
	    public List<UserModel> selectUserByName(String value)  {  
	        List<UserModel> users = new ArrayList<UserModel>();  
	        
			//Session session = sessionFactory.getCurrentSession();
	        
	        	Session session = sessionFactory.openSession();
	        	Transaction tran=session.beginTransaction();
	        
	        List list = session.createQuery("From UserModel u where u.username like ?").setParameter(0, value).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	UserModel u = (UserModel) iterator.next();  
	            users.add(u);  
	        } 
	        tran.commit();
	        session.close();

	        return users;  
	    }  
	  
	    public UserModel getUserByUserId(int userId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
	        UserModel user = (UserModel)session.get(UserModel.class, userId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return user;  
	    }  
	  
	    public boolean isExitByName(String userName)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        List user = (List)session.createQuery("From UserModel u where u.userName=:userName").setString("userName", userName).list();  
	        if(user.size()>0){  
	            try {  
	                tc.commit();  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	            session.close();  
	            return true;  
	        }  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return false;  
	    }
}
