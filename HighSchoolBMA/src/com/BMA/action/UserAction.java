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

import com.BMA.model.Staffs;
import com.BMA.model.StudentsModel;
import com.BMA.model.TeachersModel;
import com.BMA.model.TestModel;
import com.BMA.model.UserModel;
import com.BMA.service.TestService;
import com.BMA.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.core.ReturnInstruction.Return;


@Action(value = "UserAction", results = {
		@Result(name = "operationSuccess", location = "/main.jsp"),
		@Result(name = "loginFailed", location = "/loginFailed.jsp"),
		@Result(name = "registerSuccess", location = "/registerSuccess.jsp"),
		@Result(name = "regitserFailed", location = "/registerFailed.jsp")
		
}
)
public class UserAction extends ActionSupport{
	
	@Resource
	private TestService testService;
	@Resource
	private UserService userService;
	
	//param
	UserModel user;
	String username;
	String password;
	String firstname;
	String lastname;
	String authority;

	public String login(){
		boolean flag = false;
		System.out.println(user.getUsername());
		UserModel userModel = userService.getUserByUsername(user.getUsername());
		if(userModel != null && user.getPassword().equals(userModel.getPassword())){
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
			int userid = userModel.getId();
			userService.addUser(userModel);
			if(authority.equals("staff")){
				Staffs staffs = new Staffs();
				staffs.setId(userid);
				staffs.setAuthority(null);
				staffs.setFirstname(firstname);
				staffs.setLastname(lastname);
				userService.addStaff(staffs);
			}
			if(authority.equals("teacher")){
				TeachersModel teacher = new TeachersModel();
				teacher.setId(userid);
				teacher.setAuthority(null);
				teacher.setFirstname(firstname);
				teacher.setLastname(lastname);
				userService.addTeacher(teacher);
			}
			if(authority.equals("student")){
				StudentsModel student = new StudentsModel();
				student.setId(userid);
				student.setAuthority(null);
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
	
	    public String index() {
		
		return "loginFailed";
	    }

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
	

}
