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

import com.BMA.model.BookwithSubjectModel;

@Repository("bookswithSubjectDao")
public class BookswithSubjectDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public BookModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (BookModel)session.get(BookModel.class, 1);
		//}
		
		public void addBook(BookwithSubjectModel book)  {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.save(book);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void delBook(int bsId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        BookwithSubjectModel u = new BookwithSubjectModel();
	        u.setId(bsId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateBook(BookwithSubjectModel Book) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        session.update(Book);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	          
	    }  
	  
	    
	    /**
	     * param: bookid or subjectid
	     */
	    public List<BookwithSubjectModel> selectBookByInt(String param, int value)  {  
	        List<BookwithSubjectModel> Books = new ArrayList<BookwithSubjectModel>();  
	        
        	Session session = sessionFactory.openSession();
        	//Transaction tc = (Transaction) session.beginTransaction();  
	        
	        String hqlString = "From BookwithSubjectModel u where u."+ param + "='" + value +"'";
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	BookwithSubjectModel u = (BookwithSubjectModel) iterator.next();  
	            Books.add(u);  
	        }  
	       
	        session.close();  
	        return Books;  
	    }  
	    
	  
	    public BookwithSubjectModel getBSBybsId(int bsId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	BookwithSubjectModel Book = (BookwithSubjectModel)session.get(BookwithSubjectModel.class, bsId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Book;  
	    }  
}
