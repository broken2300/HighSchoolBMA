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

import com.BMA.model.TeacherwithSubjectModel;

@Repository("teacherwithSubjectDao")
public class TeacherwithSubjectDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public TsModel findTest(){
			//Session Session = SessionFactory.getCurrentSession();
			//return (TsModel)Session.get(TsModel.claTs, 1);
		//}
		
		public void addTs(TeacherwithSubjectModel Ts)  {  
        	Session Session = sessionFactory.openSession();
	        Transaction tc = (Transaction) Session.beginTransaction();  
	        Session.save(Ts);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        Session.close();  
	    }  
	  
	    public void delTs(int bsId) {  
        	Session Session = sessionFactory.openSession();
	        Transaction tc = (Transaction) Session.beginTransaction();  
	        TeacherwithSubjectModel u = new TeacherwithSubjectModel();
	        u.setId(bsId);
	        Session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        Session.close();  
	    }  
	  
	    public void updateTs(TeacherwithSubjectModel Ts) {  
        	Session Session = sessionFactory.openSession();
	        Transaction tc = (Transaction) Session.beginTransaction();  
	        Session.update(Ts);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        Session.close();  
	          
	    }  
	  
	    
	    /**
	     * param: Tsid or subjectid
	     */
	    public List<TeacherwithSubjectModel> selectTsByInt(String param, int value)  {  
	        List<TeacherwithSubjectModel> Tss = new ArrayList<TeacherwithSubjectModel>();  
	        
        	Session Session = sessionFactory.openSession();
        	//Transaction tc = (Transaction) Session.beginTransaction();  
	        
	        String hqlString = "From TeacherwithSubjectModel u where u."+ param + "='" + value +"'";
	        List list = Session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	TeacherwithSubjectModel u = (TeacherwithSubjectModel) iterator.next();  
	            Tss.add(u);  
	        }  
	       
	        Session.close();  
	        return Tss;  
	    }  
	    
	  
	    public TeacherwithSubjectModel getBSBybsId(int bsId)  {  
        	Session Session = sessionFactory.openSession();
        	Transaction tc = (Transaction) Session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	TeacherwithSubjectModel Ts = (TeacherwithSubjectModel)Session.get(TeacherwithSubjectModel.class, bsId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        Session.close();  
	        return Ts;  
	    }  
}
