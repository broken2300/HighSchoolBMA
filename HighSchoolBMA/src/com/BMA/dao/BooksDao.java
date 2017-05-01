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

import com.BMA.model.BooksModel;

@Repository("booksDao")
public class BooksDao {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;

		
		//return the first test info
		//public BookModel findTest(){
			//Session session = sessionFactory.getCurrentSession();
			//return (BookModel)session.get(BookModel.class, 1);
		//}
		
		public void addBook(BooksModel book)  {  
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
	  
	    public void delBook(int bookId) {  
        	Session session = sessionFactory.openSession();
	        Transaction tc = (Transaction) session.beginTransaction();  
	        BooksModel u = new BooksModel();
	        u.setId(bookId);
	        session.delete(u);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }   
	        session.close();  
	    }  
	  
	    public void updateBook(BooksModel Book) {  
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
	  
	    
	    public List<BooksModel> selectBookByString(String param, String value)  {  
	        List<BooksModel> Books = new ArrayList<BooksModel>();  
	        
        	Session session = sessionFactory.openSession();
    
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        String hqlString = " From BooksModel u where u."+ param + "='" + value+"'";
	        if(session.createQuery(hqlString) != null){
		        List list = session.createQuery(hqlString).list();  
		        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
		        	BooksModel u = (BooksModel) iterator.next();  
		            Books.add(u);  
		        }  
		        tc.commit();
		        session.close();  
		        return Books;  
	        }
	        else 
	        {
	        	tc.commit();
	        	return null;
	        }

	    }  
	    
	    public List<BooksModel> selectBookByInt(String param, int value)  {  
	        List<BooksModel> Books = new ArrayList<BooksModel>();  
	        
        	Session session = sessionFactory.openSession();
        	//Transaction tc = (Transaction) session.beginTransaction();  
	        
	        String hqlString = "From BooksModel u where u."+ param + "='" + value +"'";
	        List list = session.createQuery(hqlString).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	BooksModel u = (BooksModel) iterator.next();  
	            Books.add(u);  
	        }  
	       
	        session.close();  
	        return Books;  
	    }  
	    
	    public List<BooksModel> selectBookByName(String value)  {  
	        List<BooksModel> Books = new ArrayList<BooksModel>();  
	        
			//Session session = sessionFactory.getCurrentSession();
	        
	        	Session session = sessionFactory.openSession();
	        	Transaction tran=session.beginTransaction();
	        
	        List list = session.createQuery("From BooksModel u where u.name like ?").setParameter(0, value).list();  
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {  
	        	BooksModel u = (BooksModel) iterator.next();  
	            Books.add(u);  
	        } 
	        tran.commit();
	        session.close();

	        return Books;  
	    }  
	  
	    public BooksModel getBookByBookId(int BookId)  {  
        	Session session = sessionFactory.openSession();
        	Transaction tc = (Transaction) session.beginTransaction();  
	        //tc.begin();
	        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException  
	        //get 如果查不到记录，返回的是一个null  
        	BooksModel Book = (BooksModel)session.get(BooksModel.class, BookId);  
	        try {  
	            tc.commit();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        session.close();  
	        return Book;  
	    }  
}
