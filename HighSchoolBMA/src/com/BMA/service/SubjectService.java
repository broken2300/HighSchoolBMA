package com.BMA.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.HasAnnotation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMA.dao.BooksDao;
import com.BMA.dao.BookswithSubjectDao;
import com.BMA.dao.StudentwithSubjectDao;
import com.BMA.dao.SubjectsDao;
import com.BMA.dao.TeacherwithSubjectDao;
import com.BMA.model.*;


@Service
@Transactional
public class SubjectService {
	
	@Resource
	SubjectsDao subjectsDao;
	@Resource
	BookswithSubjectDao bookswithSubjectDao;
	@Resource
	StudentwithSubjectDao studentwithSubjectDao;
	@Resource
	TeacherwithSubjectDao teacherwithSubjectDao;
	@Resource
	BooksDao booksDao;
	
	//add
	public int addSubject(SubjectsModel subjectsModel){
		try {
			return subjectsDao.addSubject(subjectsModel);
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int addBs(BookwithSubjectModel bookwithSubjectModel){
		try {
			bookswithSubjectDao.addBook(bookwithSubjectModel);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
			// TODO: handle exception
		}
	}
	
	public int addTs(TeacherwithSubjectModel bookwithSubjectModel){
		try {
			teacherwithSubjectDao.addTs(bookwithSubjectModel);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
			// TODO: handle exception
		}
	}
	
	//delete
	public int delSubject(SubjectsModel subjectsModel){
		try {
			subjectsDao.delSubject(subjectsModel.getId());
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//update
	public int updateSubject(SubjectsModel subjectsModel){
		try {
			subjectsDao.updateSubject(subjectsModel);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//todo: UPDATE BOOK-SUBJECT RELATION 
	
	//find
	public List<SubjectsModel> getSubjectByStudent(StudentsModel student){
		List<SubjectsModel> returnList= new ArrayList<SubjectsModel>();
		List<StudentwithSubjectModel> tsList = studentwithSubjectDao.selectSsByInt("studentid", student.getId());
		for (StudentwithSubjectModel studentwithSubjectModel : tsList) {
			SubjectsModel subjectsModel = subjectsDao.getSubjectBySubjectId(studentwithSubjectModel.getSubjectid());
			returnList.add(subjectsModel);
		}
		return returnList;	}
	
	public List<SubjectsModel> getSubjectByTeacher(TeachersModel student){
		List<SubjectsModel> returnList= new ArrayList<SubjectsModel>();
		List<TeacherwithSubjectModel> tsList = teacherwithSubjectDao.selectTsByInt("teacherid", student.getId());
		for (TeacherwithSubjectModel teacherwithSubjectModel : tsList) {
			SubjectsModel subjectsModel = subjectsDao.getSubjectBySubjectId(teacherwithSubjectModel.getSubjectid());
			returnList.add(subjectsModel);
		}
		return returnList;
	}
	
	public List<BooksModel> getBooksBySubject(SubjectsModel subjectsModel){
		List<BooksModel> returnList= new ArrayList<BooksModel>();
		List<BookwithSubjectModel> tsList = bookswithSubjectDao.selectBookByInt("subjectid", subjectsModel.getId());
		for (BookwithSubjectModel bookwithSubjectModel : tsList) {
			BooksModel booksModel = booksDao.getBookByBookId(bookwithSubjectModel.getBookid());
			returnList.add(booksModel);
		}
		return returnList;
	}
}
