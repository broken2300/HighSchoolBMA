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
    Find By Name<br>
    
     <a href="<%=basePath%>userMain.jsp"><input type="button"  value="Index"/></a>   
    <a href="<%=basePath%>UserAction!Logout"><input type="button"  value="Logout"/></a>
    <s:form action="UserAction!getbooksByName">  
              <s:textfield name="name" label="book"></s:textfield>    
              <s:submit value="search"></s:submit>  
         </s:form> 
    Find By Author<br>
    <s:form action="UserAction!getbooksByAuthor">  
              <s:textfield name="author" label="Author"></s:textfield>           
              <s:submit value="serch"></s:submit>  
         </s:form>   
  </body>
</html>
