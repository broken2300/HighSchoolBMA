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


@Action(value = "BookAction", results = {
		@Result(name = "operationSuccess", location = "/main.jsp")
		
}
)

public class BookAction extends ActionSupport{

	@Resource
	UserService userService;
	
	//param


}
