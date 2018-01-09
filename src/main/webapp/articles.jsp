<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"   prefix="fmt" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="HautPage.jspf" %>

<form action="./Enreg" method="get">
<h2>Catalogue des articles </h2>

<table border="1">
 <tr>
 <td>Code</td> 
 <td>Nom</td> 
 <td>Prix Unitaire</td> 
 <td>Stock</td>
 </tr>
 
 <c:forEach items="${listeArticles}" var="article" >
 <tr>
 <td>${article.code}</td> 
 <td>${article.nom}</td> 
 <td align="right"><fmt:formatNumber type="number" minFractionDigits="2" value="${article.prix}" /> </td> 
 <td align="right">${article.stock}</td>
 <td><a href="./commander?id=${article.code}">Commander</a></td>
 </tr>
 </c:forEach>

</table>
</form>

</body>
</html>