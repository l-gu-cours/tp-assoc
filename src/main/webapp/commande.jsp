<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="HautPage.jspf" %>
<h2>Votre commande </h2>   

<table border="1">
 <tr>
 <td>Code</td> 
 <td>Nom</td> 
 <td>Prix</td> 
 </tr>
 
 <c:forEach items="${sessionScope.commande.liste}" var="article" >
 <tr>
 <td>${article.code}</td> 
 <td>${article.nom}</td> 
 <td>${article.prix}</td> 
 </tr>
 </c:forEach>

</table>
<br> 

<c:if test="${sessionScope.commande.nbArticles > 0}">
<a href="./annulerCommande">Annuler la commande</a>
</c:if>

<c:if test="${empty sessionScope.commande}">
<h3>Aucun article command�.</h3>
</c:if>

</body>
</html>