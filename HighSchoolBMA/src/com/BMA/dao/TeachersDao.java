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

import com.BMA.model.TeachersModel;

@Repository("teachersDao")
public class TeachersDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public TeacherModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (TeacherModel)session.get(TeacherModel.class, 1);
		//}
		
		public void addTeacher(TeachersModel Teacher)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.save(Teacher);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void delTeacher(int TeacherId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        TeachersModel u = new TeachersModel();
	        u.setId(TeacherId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateTeacher(TeachersModel Teacher) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(Teacher);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	          
	    }  
	  
	  /**
	   *   
	   * @param param : firstname or lastname
	   * @param value
	   * @return
	   */
	    public List<TeachersModel> selectTeacherByString(String param, String value)  {  
	        List<TeachersModel> Teachers = new ArrayList<TeachersModel>();  
	        
        	Session session = sessionFactory.openSession();
    
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        String hqlString = " From TeachersModel u where u."+ param + "='" + value+"'";
	        if(param == null){
	        	hqlString = "From StudentModel";
	        }
	        if(session.createQuery(hqlString) != null){
		        List list = session.createQuery(hqlString).list();  
		        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
		        	TeachersModel u = (TeachersModel) iterator.next();  
		            Teachers.add(u);  
		        }  
		        tc.commit();
		        session.close();  
		        return Teachers;  
	        }
	        else 
	        {
	        	tc.commit();
	        	return null;
	        }

	    }  
	    
	    public List<TeachersModel> selectTeacherByName(String value)  {  
	        List<TeachersModel> Teachers = new ArrayList<TeachersModel>();  
	        
			//Session session = sessionFactory.getCurrentSession();
	        
	        	Session session = sessionFactory.openSession();
	        	Transaction tran=session.beginTransaction();
	        
	        List list = session.createQuery("From TeachersModel u where u.lastname like ?").setParameter(0, value).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	TeachersModel u = (TeachersModel) iterator.next();  
	            Teachers.add(u);  
	        } 
	        tran.commit();
	        session.close();

	        return Teachers;  
	    }  
	  
	    public TeachersModel getTeacherByTeacherId(int TeacherId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	TeachersModel Teacher = (TeachersModel)session.get(TeachersModel.class, TeacherId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Teacher;  
	    }  
}
