package com.BMA.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;

import com.BMA.model.TestModel;
import com.BMA.model.UserModel;
import com.BMA.service.TestService;

@Repository

public class TestAction {
	
	@Resource
	private TestService testService;
	
	  @Action(value = "/testAction", results = { @Result(name = "SUCCESS", location = "/index.jsp") })
	    public String index() {
		UserModel userModel = testService.findTest();
		HttpServletRequest request = ServletActionContext.getRequest();
	    
	    request.setAttribute("test", userModel);
	    
	    
	    //other example
	    //ServletContext servletContext = ServletActionContext.getServletContext();
	    
	    //request.getSession();
	    //HttpServletResponse response = ServletActionContext.getResponse();
		return "SUCCESS";
	    }

}
