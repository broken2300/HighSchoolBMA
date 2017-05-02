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

import com.BMA.model.SubjectsModel;

@Repository("subjectsDao")
public class SubjectsDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public SubjectModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (SubjectModel)session.get(SubjectModel.class, 1);
		//}
		
		public int addSubject(SubjectsModel Subject)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        int i = (Integer) session.save(Subject);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	        return i;
	    }  
	  
	    public void delSubject(int SubjectId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        SubjectsModel u = new SubjectsModel();
	        u.setId(SubjectId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateSubject(SubjectsModel Subject) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(Subject);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	          
	    }  
	    
	    public List<SubjectsModel> selectSubjectByName(String value)  {  
	        List<SubjectsModel> Subjects = new ArrayList<SubjectsModel>();  
	        
			//Session session = sessionFactory.getCurrentSession();
	        
	        	Session session = sessionFactory.openSession();
	        	Transaction tran=session.beginTransaction();
	        
	        List list = session.createQuery("From SubjectsModel u where u.name like ?").setParameter(0, value).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	SubjectsModel u = (SubjectsModel) iterator.next();  
	            Subjects.add(u);  
	        } 
	        tran.commit();
	        session.close();

	        return Subjects;  
	    }  
	  
	    public SubjectsModel getSubjectBySubjectId(int SubjectId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	SubjectsModel Subject = (SubjectsModel)session.get(SubjectsModel.class, SubjectId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Subject;  
	    }  
}
