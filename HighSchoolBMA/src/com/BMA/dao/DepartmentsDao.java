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

import com.BMA.model.DepartmentsModel;

@Repository("departmentsDao")
public class DepartmentsDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public DepartmentModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (DepartmentModel)session.get(DepartmentModel.class, 1);
		//}
		
		public void addDepartment(DepartmentsModel Department)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.save(Department);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void delDepartment(int DepartmentId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        DepartmentsModel u = new DepartmentsModel();
	        u.setId(DepartmentId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateDepartment(DepartmentsModel Department) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(Department);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	          
	    }  

	    public List<DepartmentsModel> selectDepartmentByName(String value)  {  
	        List<DepartmentsModel> Departments = new ArrayList<DepartmentsModel>();  
	        
			//Session session = sessionFactory.getCurrentSession();
	        
	        	Session session = sessionFactory.openSession();
	        	Transaction tran=session.beginTransaction();
	        
	        List list = session.createQuery("From DepartmentsModel u where u.name like ?").setParameter(0, value).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	DepartmentsModel u = (DepartmentsModel) iterator.next();  
	            Departments.add(u);  
	        } 
	        tran.commit();
	        session.close();

	        return Departments;  
	    }  
	  
	    public DepartmentsModel getDepartmentByDepartmentId(int DepartmentId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	DepartmentsModel Department = (DepartmentsModel)session.get(DepartmentsModel.class, DepartmentId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Department;  
	    }  
}
