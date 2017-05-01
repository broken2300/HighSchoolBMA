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

import com.BMA.model.Staffs;

@Repository("staffsDao")
public class StaffsDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public StaffModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (StaffModel)session.get(StaffModel.class, 1);
		//}
		
		public void addStaff(Staffs Staff)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.save(Staff);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void delStaff(int StaffId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        Staffs u = new Staffs();
	        u.setId(StaffId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateStaff(Staffs Staff) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(Staff);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	          
	    }  
	  
	    
	    public List<Staffs> selectStaffByString(String param, String value)  {  
	        List<Staffs> Staffs = new ArrayList<Staffs>();  
	        
        	Session session = sessionFactory.openSession();
    
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        String hqlString = " From Staffs u where u."+ param + "='" + value+"'";
	        if(param == null){
	        	hqlString = "From StudentModel";
	        }
	        if(session.createQuery(hqlString) != null){
		        List list = session.createQuery(hqlString).list();  
		        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
		        	Staffs u = (Staffs) iterator.next();  
		            Staffs.add(u);  
		        }  
		        tc.commit();
		        session.close();  
		        return Staffs;  
	        }
	        else 
	        {
	        	tc.commit();
	        	return null;
	        }

	    }  
	    /**
	     * 
	     * @param param : firstname or lastname
	     * @param value
	     * @return
	     */
	    public List<Staffs> selectStaffByInt(String param, int value)  {  
	        List<Staffs> Staffs = new ArrayList<Staffs>();  
	        
        	Session session = sessionFactory.openSession();
        	//Transaction tc = (Transaction) session.beginTransaction();  
	        
	        String hqlString = "From Staffs u where u."+ param + "='" + value +"'";
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Staffs u = (Staffs) iterator.next();  
	            Staffs.add(u);  
	        }  
	       
	        session.close();  
	        return Staffs;  
	    }  
	    
	    public List<Staffs> selectStaffByName(String value)  {  
	        List<Staffs> Staffs = new ArrayList<Staffs>();  
	        
			//Session session = sessionFactory.getCurrentSession();
	        
	        	Session session = sessionFactory.openSession();
	        	Transaction tran=session.beginTransaction();
	        
	        List list = session.createQuery("From Staffs u where u.lastname like ?").setParameter(0, value).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	Staffs u = (Staffs) iterator.next();  
	            Staffs.add(u);  
	        } 
	        tran.commit();
	        session.close();

	        return Staffs;  
	    }  
	  
	    public Staffs getStaffByStaffId(int StaffId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	Staffs Staff = (Staffs)session.get(Staffs.class, StaffId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Staff;  
	    }  
}
