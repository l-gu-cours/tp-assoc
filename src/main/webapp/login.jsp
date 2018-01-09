<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./login" method="post">
<h2>Login</h2>
<table>
<tr>
 <td>Identifiant </td>
 <td><input name="ident" value="" /></td>
</tr>
<tr>
 <td>Mot de passe</td>
 <td><input name="motpasse" value="" /></td></tr>
</table>

<input type="submit" value="Login"/>

</form>

<p>Pas encore enregistré ? <a href="./creerCompte" >Creez votre compte...</a></p>

</body>
</html>