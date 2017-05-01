package com.BMA.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BMA.dao.StaffsDao;
import com.BMA.dao.StudentsDao;
import com.BMA.dao.TeachersDao;
import com.BMA.dao.TestDao;
import com.BMA.dao.UserDao;
import com.BMA.model.Staffs;
import com.BMA.model.StudentsModel;
import com.BMA.model.TeachersModel;
import com.BMA.model.TestModel;
import com.BMA.model.UserModel;


@Service
@Transactional
public class UserService  {
	
	@Resource
	TestDao testDao;
	@Resource
	UserDao	userDao;
	@Resource
	StudentsDao studentsDao;
	@Resource
	TeachersDao teachersDao;
	@Resource
	StaffsDao staffsDao;

	//Register
	public int RegisterUserAsStaff(Staffs staff, UserModel user){
		try {
			userDao.addUser(user);
			staffsDao.addStaff(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int RegisterUserAsStudent(StudentsModel student, UserModel user){
		try {
			userDao.addUser(user);
			studentsDao.addStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int RegisterUserAsTeacher(TeachersModel teacher, UserModel user){
		try {
			userDao.addUser(user);
			teachersDao.addTeacher(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//Authorize
	public int AuthorizeTeacher(int teacherId){
		try {
			TeachersModel teachersModel = teachersDao.getTeacherByTeacherId(teacherId);
			if(teachersModel == null)
			{
				return -1;
			}
			else{
				teachersModel.setAuthority("teacher");
				teachersDao.updateTeacher(teachersModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int AuthorizeStudent(int StudentId){
		try {
			StudentsModel studentsModel = studentsDao.getStudentByStudentId(StudentId);
			if(studentsModel == null)
			{
				return -1;
			}
			else{
				studentsModel.setAuthority("student");
				studentsDao.updateStudent(studentsModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int AuthorizeStaff(int StaffId){
		try {
			Staffs staffs = staffsDao.getStaffByStaffId(StaffId);
			if(staffs == null)
			{
				return -1;
			}
			else{
				staffs.setAuthority("staff");
				staffsDao.updateStaff(staffs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//Update
	public int UpdateStudent(StudentsModel studentsModel){
		try {
			studentsDao.updateStudent(studentsModel);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int UpdateTeacher(TeachersModel teachersModel){
		try {
			teachersDao.updateTeacher(teachersModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//Find
	public List<StudentsModel> FindStudent(String param, String value){
		try {
			return studentsDao.selectStudentByString(param, value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<TeachersModel> FindTeacher(String param, String value){
		try {
			return teachersDao.selectTeacherByString(param, value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Staffs> findStaffs(String param, String value){
		try {
			return staffsDao.selectStaffByString(param, value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//Find no authorize
	public List<StudentsModel> FindStudentNoAuthorized(){
		try {
			return studentsDao.selectStudentByString("authority", null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<TeachersModel> FindTeacher(){
		try {
			return teachersDao.selectTeacherByString("authority",null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Staffs> findStaffs(){
		try {
			return staffsDao.selectStaffByString("authority",null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//TODO: 
	//User Part 
	public UserModel getUserByUsername(String username){
		List<UserModel> users = userDao.selectUserByName(username);
		if(users != null && !users.isEmpty()){
			return users.get(0);
		}
		else{
			return null;
		}
	}
	public boolean UserExist(String username){
		return userDao.isExitByName(username);
	}
	public boolean UserLogIn(String username, String password){
		UserModel userModel = userDao.selectUserByName(username).get(0);
		if(userModel == null){
			return false;
		}
		else {
			if(userModel.getPassword().equals(password)){
				return true;
			}
			else {
				return false;
			}
		}
	}
	public StudentsModel getStudentByUser(UserModel user){
		return studentsDao.getStudentByStudentId(user.getUserid());
	}
	public TeachersModel getTeacherByUser(UserModel user){
		return teachersDao.getTeacherByTeacherId(user.getUserid());
	}
	public Staffs getStaffByUser(UserModel user){
		return staffsDao.getStaffByStaffId(user.getUserid());
	}
	
	//add User
	public int addUser(UserModel user){
		try {
			userDao.addUser(user);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public int addStaff(Staffs studentsModel){
		try {
			staffsDao.addStaff(studentsModel);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public int addTeacher(TeachersModel studentsModel){
		try {
			teachersDao.addTeacher(studentsModel);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public int addStudent(StudentsModel studentsModel){
		try {
			studentsDao.addStudent(studentsModel);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}