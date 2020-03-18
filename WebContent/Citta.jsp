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

	<p>
		<a href="/worldjdbc/formsetup">Inserisci città</a>
	</p>
	<c:forEach items="${cities}" var="citta">
		<p>città: ${citta.name}</p>
		<p>popolazione: ${citta.population}</p>


		<button name="elimina"
			onclick="location.href='/worldjdbc/deletecities?id=${citta.id}&name=${citta.name}&countrycode=${citta.countrycode}'">Elimina
			citta'</button>



		<br>
	</c:forEach>

</div>
</html>

