package com.BMA.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.HasAnnotation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMA.dao.BooksDao;
import com.BMA.dao.CheckDao;
import com.BMA.dao.UserDao;
import com.BMA.model.BooksModel;
import com.BMA.model.LogModel;
import com.BMA.model.UserModel;

@Service
@Transactional
public class BookService {
	
	@Resource
	BooksDao booksDao;
	@Resource
	UserDao userDao;
	@Resource
	CheckDao checkDao;
	
	//checkout
	/**
	 * 
	 * @param book
	 * @param user
	 * @return -1: erorr
	 * 		   -2: book has been check out
	 */
	public int checkoutSingle(BooksModel book, UserModel user){
		List<LogModel> checkModelList = checkDao.selectCheckByInt("bookid", book.getId());
		if(checkModelList.size() ==0){
			LogModel checkModel = new LogModel();
			checkModel.setAuthority(user.getAuthority());
			checkModel.setBookid(book.getId());
			checkModel.setUserid(user.getId());
			checkModel.setReturndate(null);
			checkModel.setCheckdate(new java.sql.Date(new java.util.Date().getTime()));
			try {
				checkDao.addCheck(checkModel);
				return 0;
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}			
		}
		else {
			return -2;
		}
	}
	/**
	 * 
	 * @param book
	 * @param user
	 * @return -1: erorr
	 * 		   -2: book has been check out
	 */		   
	public int checkoutBooks(List<BooksModel> books, UserModel user){
		List<LogModel> checkList = new ArrayList<LogModel>();
		
		for (BooksModel book : books) {
			List<LogModel> checkModelList = checkDao.selectCheckByInt("bookid", book.getId());
			if(checkModelList.size() == 0){
				LogModel checkModel = new LogModel();
				checkModel.setAuthority(user.getAuthority());
				checkModel.setBookid(book.getId());
				checkModel.setUserid(user.getUserid());
				checkModel.setReturndate(null);
				checkModel.setCheckdate(new java.sql.Date(new java.util.Date().getTime()));
				try {
					checkDao.addCheck(checkModel);
				} catch (Exception e) {
					e.printStackTrace();
					return -1;
				}			
			}
			else {
				return -2;
			}
		}
		return 0;
	}
	
	//find
	public List<BooksModel> findBooksByName(String value){
		List<BooksModel> bookList = booksDao.selectBookByName(value);
		return bookList;
	}
	
	public List<BooksModel> findBooksByAuthor(String value){
		List<BooksModel> bookList = booksDao.selectBookByString("author", value);
		return bookList;
	}
	
	//return
	public int returnBook(BooksModel book){
		LogModel checkModel = checkDao.selectCheckByInt("bookid", book.getId()).get(0);
		if(checkModel == null){
			return -1;
		}
		else{
			checkModel.setReturndate(new java.sql.Date(new java.util.Date().getTime()));
			checkDao.updateCheck(checkModel);
			return 0;
		}
	}
	
	//checkList
	public List<LogModel> getAllcheckList(){
		return checkDao.selectCheckByInt(null, 0);
	}
	
	public List<LogModel> getNoReturnList(){
		List<LogModel> list = checkDao.selectCheckByInt(null, 0);
		List<LogModel> returnList = new ArrayList<LogModel>();
		for (LogModel checkModel : list) {
			if(checkModel.getReturndate() == null){
				returnList.add(checkModel);
			}
		}
		return returnList;
	}
	
	public List<LogModel> getReturnedList(){
		List<LogModel> list = checkDao.selectCheckByInt(null, 0);
		List<LogModel> returnList = new ArrayList<LogModel>();
		for (LogModel checkModel : list) {
			if(checkModel.getReturndate() != null){
				returnList.add(checkModel);
			}
		}
		return returnList;
	}
	
	public List<LogModel> getUserCheckList(int id){
		List<LogModel> list = checkDao.selectCheckByInt("userid", id);
		List<LogModel> returnList = new ArrayList<LogModel>();
		for (LogModel checkModel : list) {
			if(checkModel.getReturndate() == null){
				returnList.add(checkModel);
			}
		}
		return returnList;
	}
	
	public LogModel getLogModel(int id){
		LogModel logModel = checkDao.getCheckByCheckId(id);
		return logModel;
	}
	
	public void updateLog(LogModel logModel){
		checkDao.updateCheck(logModel);
	}
	
	public BooksModel getBooksModel(int id){
		return booksDao.getBookByBookId(id);
	}

}
