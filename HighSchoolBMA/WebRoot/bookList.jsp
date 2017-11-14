<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    Book List<br>
    
     <a href="<%=basePath%>userMain.jsp"><input type="button"  value="Index"/></a>   
    <a href="<%=basePath%>UserAction!Logout"><input type="button"  value="Logout"/></a>
     <table border="1">
   <tr>
    <th>id</th><th>ISBN</th><th>BookName</th><th>Author</th><th>operation</th>
   </tr> 
      <c:forEach items="${list}" var="book">
       <tr>
        <td>${book.id }</td>
        <td>${book.ISBN}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
                <td><a href="<%=basePath%>UserAction!checkout?id=${book.id}">Checkout</a> </td>
                                <td><a href="<%=basePath%>UserAction!setRefer?id=${book.id}">SetRefer</a> </td>
                
       </tr>
      </c:forEach>


</table>

  </body>
</html>
