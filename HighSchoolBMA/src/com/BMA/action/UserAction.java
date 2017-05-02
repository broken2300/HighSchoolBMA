package com.BMA.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;

import com.BMA.dao.StaffsDao;
import com.BMA.model.BooksModel;
import com.BMA.model.Staffs;
import com.BMA.model.StudentsModel;
import com.BMA.model.TeachersModel;
import com.BMA.model.TestModel;
import com.BMA.model.UserModel;
import com.BMA.service.BookService;
import com.BMA.service.TestService;
import com.BMA.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.core.ReturnInstruction.Return;


@Action(value = "UserAction", results = {
		@Result(name = "operationSuccess", location = "/main.jsp"),
		
		@Result(name = "loginFailed", location = "/loginFailed.jsp"),
		@Result(name = "registerSuccess", location = "/registerSuccess.jsp"),
		@Result(name = "regitserFailed", location = "/registerFailed.jsp"),
		
		@Result(name = "error", location = "/error.jsp"),
		
		@Result(name = "noAuthor", location = "/noAuthor.jsp"),
		@Result(name = "staffList", location = "/staffList.jsp"),
		@Result(name = "studentList", location = "/studentList.jsp"),
		@Result(name = "teacherList", location = "/teacherList.jsp"),

		@Result(name = "bookList", location = "/bookList.jsp"),
		@Result(name = "checkSuccess", location = "/checkSuccess.jsp"),
		@Result(name = "checkFailed", location = "/checkFailed.jsp"),
		
}
)
public class UserAction extends ActionSupport{
	
	@Resource
	private TestService testService;
	@Resource
	private UserService userService;
	@Resource
	private BookService bookService;
	
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

	public String login(){
		boolean flag = false;
		System.out.println(user.getUsername());
		UserModel userModel = userService.getUserByUsername(user.getUsername());
		//check authorization
		
		Staffs staffs = new Staffs();
		if(userModel.getAuthority().equals("staff")){
			staffs = userService.getStaffByUser(userModel);
		}
		//TODO :bug
		if(userModel != null && user.getPassword().equals(userModel.getPassword()) ){
			ServletActionContext.getRequest().getSession()
			.setAttribute("user", userModel);
			return "operationSuccess";
		}
		else {
			return "loginFailed";
		}
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
	
	public String authorizationTeacher(int id){
		try {
			userService.AuthorizeTeacher(id);
			return "operationSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String authorizationStudent(int id){
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
		List<BooksModel> list = bookService.findBooksByAuthor(paramString);
		ServletActionContext.getRequest().getSession()
		.setAttribute("list", list);
		return "bookList";
	}
	
	public String getbooksByName(){
		List<BooksModel> list = bookService.findBooksByName(paramString);
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
		if(bookService.checkoutSingle(booksModel, tempUser)== 0){
			return "checkSuccess";			
		}
		else{
			return "checkFailed";
		}
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
	

}
