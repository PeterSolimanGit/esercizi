<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Insert title here</title>
</head>
<style type="text/css">
body {
	background-image:
		url('https://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
<body>
	<div align="center" style="margin-top: 50px;">
		<h1>Lista Nazioni:</h1>
		<c:forEach items="${countries}" var="nazione">
		<a href="/worldjdbc/cities?Code=${nazione.code}">${nazione.name}</a> <br>
		</c:forEach>
</div>
</body>
</html>
