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

import com.BMA.model.StudentsModel;

@Repository("studentsDao")
public class StudentsDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public StudentModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (StudentModel)session.get(StudentModel.class, 1);
		//}
		
		public void addStudent(StudentsModel Student)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.save(Student);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void delStudent(int StudentId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        StudentsModel u = new StudentsModel();
	        u.setId(StudentId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateStudent(StudentsModel Student) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(Student);  
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
	    public List<StudentsModel> selectStudentByString(String param, String value)  {  
	        List<StudentsModel> Students = new ArrayList<StudentsModel>();  
	        
        	Session session = sessionFactory.openSession();
    
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        String hqlString = " From StudentsModel u where u."+ param + "='" + value+"'";
	        if(param == null){
	        	hqlString = "From StudentModel";
	        }
	        if(param == null){
	        	hqlString = "From StudentModel";
	        }
	        if(session.createQuery(hqlString) != null){
		        List list = session.createQuery(hqlString).list();  
		        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
		        	StudentsModel u = (StudentsModel) iterator.next();  
		            Students.add(u);  
		        }  
		        tc.commit();
		        session.close();  
		        return Students;  
	        }
	        else 
	        {
	        	tc.commit();
	        	return null;
	        }

	    }  
	    
	    public List<StudentsModel> selectStudentByName(String value)  {  
	        List<StudentsModel> Students = new ArrayList<StudentsModel>();  
	        
			//Session session = sessionFactory.getCurrentSession();
	        
	        	Session session = sessionFactory.openSession();
	        	Transaction tran=session.beginTransaction();
	        
	        List list = session.createQuery("From StudentsModel u where u.lastname like ?").setParameter(0, value).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	StudentsModel u = (StudentsModel) iterator.next();  
	            Students.add(u);  
	        } 
	        tran.commit();
	        session.close();

	        return Students;  
	    }  
	  
	    public StudentsModel getStudentByStudentId(int StudentId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	StudentsModel Student = (StudentsModel)session.get(StudentsModel.class, StudentId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Student;  
	    }  
}
