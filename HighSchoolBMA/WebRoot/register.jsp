<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    Welcome to HighSchool Book Management Application! <br>
    Please Login
    <s:form action="UserAction!register">  
              <s:textfield name="username" label="username"></s:textfield>  
              <s:textfield name="password" label="password"></s:textfield>
              <s:textfield name="firstname" label="First Name"></s:textfield>
              <s:textfield name="lastname" label="Last Name"></s:textfield>
			  <s:radio name="authority" list="#{'staff':'staff','teacher':'teacher','student':'student'}"/>           
              <s:submit value="register"></s:submit>  
         </s:form>  

  </body>
</html>
