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
    Select Operation
    <br>

    <a href="<%=basePath%>UserAction!myBookList"><input type="button"  value="MyBookList"/></a>    
    <a href="<%=basePath%>UserAction!getAllBook"><input type="button"  value="GetAllBook"/></a>
    
    <a href="<%=basePath%>UserAction!checkRefer"><input type="button"  value="CheckRefer"/></a> 
        <a href="<%=basePath%>UserAction!setSubject"><input type="button"  value="setSubject"/></a> 
    <br>
    
    <a href="<%=basePath%>bookFind.jsp"><input type="button"  value="FindBook"/></a>
    <a href="<%=basePath%>UserAction!Logout"><input type="button"  value="Logout"/></a>
     
</html>