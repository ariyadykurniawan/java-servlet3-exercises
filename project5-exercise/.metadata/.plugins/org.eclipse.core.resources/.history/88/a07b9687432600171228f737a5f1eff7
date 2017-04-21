<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<b>Add student</b><br/>
		<form action="StudentServlet" method="POST">
			<label>Name : </label> <input name="name"/>
			<input type="submit" value="add"/>
		</form>
		<% List sList = (List)session.getAttribute("listStudent");
			request.setAttribute("sList", sList);
		%>
		<ol>
			<c:forEach items="${sList}" var="student">
		        <li> Name: <c:out value="${student.name}"/><br/>
		        	 <form action="StudentServlet" method="GET">
		        	 	<input type="hidden" value="${student.id}" name="id">
		        	 	<button >remove</button>
		        	 </form>
		        </li>  
			</c:forEach>
		</ol>
</body>
</html>