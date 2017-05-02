package com.BMA.dao;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.BMA.model.LogModel;;;

@Repository("checkDao")
public class CheckDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public CheckModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (CheckModel)session.get(CheckModel.class, 1);
		//}
		
		public void addCheck(LogModel Check)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.save(Check);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void delCheck(int CheckId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        LogModel u = new LogModel();
	        u.setId(CheckId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateCheck(LogModel Check) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(Check);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	          
	    }  
	    
	    /**
	     * 
	     * @param param : userid or bookid
	     * @param value
	     * @return
	     */
	    public List<LogModel> selectCheckByInt(String param, int value)  {  
	        List<LogModel> Checks = new ArrayList<LogModel>();  
	        
        	Session session = sessionFactory.openSession();
        	List list ;
        	//Transaction tc = (Transaction) session.beginTransaction();  
	        
	        String hqlString;
	        if(param == null){
	        	hqlString = "From LogModel";
	        	list =  session.createQuery(hqlString).list();
	        }
	        else {
	        	hqlString = "From LogModel where "+ param + "=?";
		        list = session.createQuery(hqlString).setParameter(0, value).list();
			}
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	LogModel u = (LogModel) iterator.next();  
	            Checks.add(u);  
	        }  
	       
	        session.close();  
	        return Checks;  
	    }  
	  
	    public LogModel getCheckByCheckId(int CheckId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	LogModel Check = (LogModel)session.get(LogModel.class, CheckId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Check;  
	    }  
}
