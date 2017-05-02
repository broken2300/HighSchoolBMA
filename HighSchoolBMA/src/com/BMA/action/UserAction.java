package com.BMA.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.apache.commons.validator.Msg;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;

import com.BMA.dao.StaffsDao;
import com.BMA.model.BooksModel;
import com.BMA.model.BookwithSubjectModel;
import com.BMA.model.LogModel;
import com.BMA.model.Staffs;
import com.BMA.model.StudentsModel;
import com.BMA.model.SubjectsModel;
import com.BMA.model.TeachersModel;
import com.BMA.model.TeacherwithSubjectModel;
import com.BMA.model.TestModel;
import com.BMA.model.UserModel;
import com.BMA.service.BookService;
import com.BMA.service.SubjectService;
import com.BMA.service.TestService;
import com.BMA.service.UserService;
import com.BMA.view.BookAndLogModel;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.core.ReturnInstruction.Return;


@Action(value = "UserAction", results = {
		@Result(name = "index", location = "/index.jsp"),
		@Result(name = "operationSuccess", location = "/staffMain.jsp"),
		@Result(name = "operationSuccess2", location = "/userMain.jsp"),
		
		@Result(name = "loginFailed", location = "/loginFailed.jsp"),
		@Result(name = "registerSuccess", location = "/registerSuccess.jsp"),
		@Result(name = "regitserFailed", location = "/registerFailed.jsp"),
		
		@Result(name = "error", location = "/error.jsp"),
		
		@Result(name = "noAuthor", location = "/noAuthor.jsp"),
		@Result(name = "staffList", location = "/staffList.jsp"),
		@Result(name = "studentList", location = "/studentList.jsp"),
		@Result(name = "teacherList", location = "/teacherList.jsp"),

		@Result(name = "bookLog", location = "/bookLog.jsp"),

		@Result(name = "bookList", location = "/bookList.jsp"),
		@Result(name = "checkSuccess", location = "/checkSuccess.jsp"),
		@Result(name = "checkFailed", location = "/checkFailed.jsp"),
		@Result(name = "mybookList", location = "/mybookList.jsp"),
		@Result(name = "returnSuccess", location = "/returnSuccess.jsp"),
		@Result(name = "checkRefer", location = "/checkRefer.jsp"),
		@Result(name = "setSubject", location = "/setSubject.jsp"),

		
}
)
public class UserAction extends ActionSupport{
	
	@Resource
	private TestService testService;
	@Resource
	private UserService userService;
	@Resource
	private BookService bookService;
	@Resource
	private SubjectService subjectService;
	
	//param
	List<BooksModel> booksList;
	BooksModel book;
	UserModel user;
	String username;
	String password;
	String firstname;
	String lastname;
	String authority;	
	String paramString;
	int id;
	String name;
	String author;
	

	public String login(){
		boolean flag = false;
		System.out.println(user.getUsername());
		UserModel userModel = userService.getUserByUsername(user.getUsername());
		//check authorization
		String authority = new String();
		
		Staffs staffs = new Staffs();
		StudentsModel student = new StudentsModel();
		TeachersModel teacher = new TeachersModel();
		if(userModel.getAuthority().equals("staff")){
			staffs = userService.getStaffByUser(userModel);
			authority = staffs.getAuthority();
			
		}
		if(userModel.getAuthority().equals("student")){
			student = userService.getStudentByUser(userModel);
			authority = student.getAuthority();			
		}
		if(userModel.getAuthority().equals("teacher")){
			teacher = userService.getTeacherByUser(userModel);
			authority = teacher.getAuthority();
		}
		if(userModel != null && user.getPassword().equals(userModel.getPassword()) && !authority.equals("NO")){
			ServletActionContext.getRequest().getSession()
			.setAttribute("user", userModel);
			if(authority.equals("staff")){

				return "operationSuccess";
			}
			else {
				return "operationSuccess2";
			}
		}
		else {
			return "loginFailed";
		}
	}
	
	public String Logout(){
		ServletActionContext.getRequest().getSession()
		.setAttribute("user", null);
		return "index";
	}
	
	public String register(){
		try {
			UserModel userModel = new UserModel();
			userModel.setAuthority(authority);
			userModel.setPassword(password);
			userModel.setUsername(username);
			
			userModel.setUserid(userModel.getId());

			int userid =userService.addUser(userModel);
			if(authority.equals("staff")){
				Staffs staffs = new Staffs();
				staffs.setId(userid);
				staffs.setAuthority("NO");
				staffs.setFirstname(firstname);
				staffs.setLastname(lastname);
				userService.addStaff(staffs);
			}
			if(authority.equals("teacher")){
				TeachersModel teacher = new TeachersModel();
				teacher.setId(userid);
				teacher.setAuthority("NO");
				teacher.setFirstname(firstname);
				teacher.setLastname(lastname);
				userService.addTeacher(teacher);
			}
			if(authority.equals("student")){
				StudentsModel student = new StudentsModel();
				student.setId(userid);
				student.setAuthority("NO");
				student.setFirstname(firstname);
				student.setLastname(lastname);
				userService.addStudent(student);
			}
			return "registerSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "regitserFailed";
		}		
	}
	

	//Book log
	public String bookLog(){
		List<LogModel> list = bookService.getAllcheckList();
		ServletActionContext.getRequest().getSession()
		.setAttribute("list", list);
		return "bookLog";
		
	}
	
	//Authorization
	public String getAuthorizationStaffList(){
		UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(tempUser.getAuthority().equals("staff")){
			List<Staffs> list = userService.findStaffs();
			ServletActionContext.getRequest().getSession()
			.setAttribute("list", list);
			return "staffList";
		}
		else{
			return "noAuthor";
		}
	}
	
	public String getAuthorizationStudentList(){
		UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(tempUser.getAuthority().equals("staff")){
			List<StudentsModel> list = userService.FindStudentNoAuthorized();
			ServletActionContext.getRequest().getSession()
			.setAttribute("list", list);
			return "studentList";
		}
		else{
			return "noAuthor";
		}
	}
	
	public String getAuthorizationTeacherList(){
		UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(tempUser.getAuthority().equals("staff")){
			List<TeachersModel> list = userService.FindTeacher();
			ServletActionContext.getRequest().getSession()
			.setAttribute("list", list);
			return "teacherList";
		}
		else{
			return "noAuthor";
		}
	}
	
	public String authorizationStaff(){
		try {
			userService.AuthorizeStaff(id);
			return "operationSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String authorizationTeacher(){
		try {
			userService.AuthorizeTeacher(id);
			return "operationSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String authorizationStudent(){
		try {
			userService.AuthorizeStudent(id);
			return "operationSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//books
		//find book
	public String getbooksByAuthor(){
		List<BooksModel> list = bookService.findBooksByAuthor(author);
		ServletActionContext.getRequest().getSession()
		.setAttribute("list", list);
		return "bookList";
	}
	
	public String getbooksByName(){
		List<BooksModel> list = bookService.findBooksByName(name);
		ServletActionContext.getRequest().getSession()
		.setAttribute("list", list);
		return "bookList";
	}
	
	public String getAllBook(){
		List<BooksModel> list = bookService.findBooksByName("ALL");
		ServletActionContext.getRequest().getSession()
		.setAttribute("list", list);
		return "bookList";
	}
	
		//checkout
	public String checkout(){
		BooksModel booksModel = bookService.getBooksModel(id);
		UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
		int i =bookService.checkoutSingle(booksModel, tempUser);
		if(i== 0){
			return "checkSuccess";			
		}
		else{
			String msgString = new String();
			if(i == -1)
				msgString = "data Error";
			if(i == -2)
				msgString = "Book has been check out";
			ServletActionContext.getRequest().getSession()
			.setAttribute("msg", msgString);
			return "checkFailed";
		}
	}
	
	//return
	public String myBookList(){
		UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		List<BookAndLogModel> list = new ArrayList<BookAndLogModel>();

		List<LogModel> logList = bookService.getUserCheckList(tempUser.getId());
		
		List<BooksModel> bookList = new ArrayList<BooksModel>();
		
		for (LogModel logModel : logList) {
			bookList.add(bookService.getBooksModel(logModel.getBookid()));
		}
		
		for( int i = 0; i<logList.size(); i++){
			BookAndLogModel model = new BookAndLogModel();
			model.setBooksModel(bookList.get(i));
			model.setLogModel(logList.get(i));
			list.add(model);
		}
		
		//ServletActionContext.getRequest().getSession()
		//.setAttribute("list", logList);
		ServletActionContext.getRequest().getSession()
		.setAttribute("list", list);
		return "mybookList";
	}
	public String Returnbook(){
		LogModel logModel = bookService.getLogModel(id);
		if(logModel !=null){
			logModel.setReturndate(new java.sql.Date(new java.util.Date().getTime()));
			bookService.updateLog(logModel);
			return "returnSuccess";
		}
		else{
			return "error";
		}
	}
	
	//Reference
	public String checkRefer(){
		try {
			UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
			List<SubjectsModel> list1 = new ArrayList<SubjectsModel>();
			List<BooksModel> list2 = new ArrayList<BooksModel>();
			String author = tempUser.getAuthority();
			if(author.equals("student")){
				StudentsModel student = userService.getStudentByUser(tempUser);
				list1 = subjectService.getSubjectByStudent(student);
				for (SubjectsModel subjectsModel : list1) {
					list2= subjectService.getBooksBySubject(subjectsModel);
				}
			}
			else if(author.equals("teacher")){
				TeachersModel teacher = userService.getTeacherByUser(tempUser);
				list1 =subjectService.getSubjectByTeacher(teacher);
				for (SubjectsModel subjectsModel : list1) {
					list2= subjectService.getBooksBySubject(subjectsModel);
				}
			}
			List<LogModel> logList = bookService.getUserCheckList(tempUser.getId());
			ServletActionContext.getRequest().getSession()
			.setAttribute("list1", list1);
			ServletActionContext.getRequest().getSession()
			.setAttribute("list2", list2);
			
			return "checkRefer";
			
		} catch (Exception e) {
			return "error";
		}
		
	}
	public String setRefer(){
		UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
		TeachersModel teacher = userService.getTeacherByUser(tempUser);
		BooksModel book = bookService.getBooksModel(id);
		if(tempUser.getAuthority().equals("teacher")){
			SubjectsModel subjectsModel = subjectService.getSubjectByTeacher(teacher).get(0);
			BookwithSubjectModel bsModel = new BookwithSubjectModel();
			bsModel.setBookid(id);
			bsModel.setSubjectid(subjectsModel.getId());
			subjectService.addBs(bsModel);
			
			return "operationSuccess2";
			
		}
		else {
			return "noAuthor";
		}
	}
	 
	public String setSubject(){
		UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
		TeachersModel teacher = userService.getTeacherByUser(tempUser);
		if(tempUser.getAuthority().equals("teacher")){
			return "setSubject";
		}
		else
			return "noAuthor";		
	}
	
	public String submitSubject(){
		UserModel tempUser = (UserModel) ServletActionContext.getRequest().getSession().getAttribute("user");
		TeachersModel teacher = userService.getTeacherByUser(tempUser);
		SubjectsModel subjectsModel = new SubjectsModel();
		subjectsModel.setName(paramString);
		int i = subjectService.addSubject(subjectsModel);
		
		TeacherwithSubjectModel tsModel = new TeacherwithSubjectModel();
		tsModel.setSubjectid(i);
		tsModel.setTeacherid(tempUser.getId());
		subjectService.addTs(tsModel);
		return "operationSuccess2";
	}
	public String index() {
		
		return "loginFailed";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//param getter and setter
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public List<BooksModel> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<BooksModel> booksList) {
		this.booksList = booksList;
	}

	public BooksModel getBook() {
		return book;
	}

	public void setBook(BooksModel book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParamString() {
		return paramString;
	}

	public void setParamString(String paramString) {
		this.paramString = paramString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

}
