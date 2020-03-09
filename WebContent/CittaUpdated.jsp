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
<button name="indietro" onclick="location.href='/worldjdbc/continents'">torna
	all' inizio</button>
<div align="center" style="margin-top: 50px;">
	<h1>Lista città:</h1>
	<p>${messaggio}</p>
	<c:forEach items="${cities}" var="citta">
		<p>città: ${citta.name}</p>
		<p>popolazione: ${citta.population}</p>
		<br>
	</c:forEach>
</div>
</html>
