<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/files/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Liste des Clients</h1>
<table border=1 class="table">
<tr><th> Id</th><th>Nom</th><th>Adresse</th>  </tr>
<c:forEach items="${listec}" var="c">
<tr><td>${c.num}</td>
<td>${c.nom}</td>
<td>${c.adresse}</td>

</tr>
</c:forEach>
</table>
</body>
</html>