<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="margin-top: 50px;">
		<h1>Inserisci città:</h1>
<form action="/worldjdbc/inserisci?country=${countrycode}" method="get">
  <label for="name">Insert name:</label>
  <input type="text" id="name" name="name"><br><br>
  <label for="population">Insert population:</label>
  <input type="number" id="population" name="population"><br><br>
  <label for="district">Insert district:</label>
  <input type="text" id="district" name="district"><br><br>
  <label for="ccnazione">Choose a nation:</label>
  <select id="ccnazione" name="ccnazione">
  <c:forEach items="${tendina}" var="nazione">
    <option value="${nazione.code}">${nazione.name}</option>
  </c:forEach>
  </select>
<br><br><button type="submit">Submit</button>




</form>
</div>
</body>
</html>