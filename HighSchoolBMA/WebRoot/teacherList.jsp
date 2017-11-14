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
    Teacher List<br>
             <a href="<%=basePath%>staffMain.jsp"><input type="button"  value="Index"/></a>   
    <a href="<%=basePath%>UserAction!Logout"><input type="button"  value="Logout"/></a>
     <table border="1">
   <tr>
    <th>id</th><th>firstname</th><th>lastname</th><th>operation</th>>
   </tr> 
   <c:forEach items="${list}" var="user">
       <tr>
        <td>${user.id }</td>
        <td>${user.firstname}</td>
        <td>${user.lastname}
        </td>
                <td><a href="<%=basePath%>UserAction!authorizationTeacher?id=${user.id}">authorization</a> </td>
       </tr>
      </c:forEach>
    <s:iterator value="%{list}"  id="element" status="i">
    <tr>
        <td><s:property value="#element.id"/></td>
        <td><s:property  value="#element.firstname"/></td>
        <td><s:property  value="#element.lastname"/></td>
        <td><a href="<%=basePath%>/UserAction!authorizationTeacher?id=${element.id}">authorization</a> </td>
    </tr>
</s:iterator>
</table>

  </body>
</html>
