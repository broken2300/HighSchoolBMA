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

import com.BMA.model.StudentwithSubjectModel;

@Repository("studentwithSubjectDao")
public class StudentwithSubjectDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public SsModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (SsModel)session.get(SsModel.class, 1);
		//}
		
		public void addSs(StudentwithSubjectModel Ss)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.save(Ss);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void delSs(int bsId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        StudentwithSubjectModel u = new StudentwithSubjectModel();
	        u.setId(bsId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateSs(StudentwithSubjectModel Ss) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(Ss);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	          
	    }  
	  
	    
	    /**
	     * param: Ssid or subjectid
	     */
	    public List<StudentwithSubjectModel> selectSsByInt(String param, int value)  {  
	        List<StudentwithSubjectModel> Sss = new ArrayList<StudentwithSubjectModel>();  
	        
        	Session session = sessionFactory.openSession();
        	//Transaction tc = (Transaction) session.beginTransaction();  
	        
	        String hqlString = "From StudentwithSubjectModel u where u."+ param + "='" + value +"'";
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	StudentwithSubjectModel u = (StudentwithSubjectModel) iterator.next();  
	            Sss.add(u);  
	        }  
	       
	        session.close();  
	        return Sss;  
	    }  
	    
	  
	    public StudentwithSubjectModel getBSBybsId(int bsId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	StudentwithSubjectModel Ss = (StudentwithSubjectModel)session.get(StudentwithSubjectModel.class, bsId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Ss;  
	    }  
}
