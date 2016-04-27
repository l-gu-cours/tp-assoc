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
<form action="./enregistrerCompte" method="post">
<h2>Enregistrez vous</h2>
<table>
<tr>
 <td>Identifiant : </td> 
 <td><input name="ident" value="" size="12" maxlength="12" /><span style="color:red">*</span></td>
</tr>

<tr>
 <td>Mot de passe : </td> 
 <td><input name="mp1" value="" size="10" maxlength="10" /><span style="color:red">*</span></td>
</tr>
<tr>
 <td>Mot de passe (confirm) : </td> 
 <td><input name="mp2" value="" size="10" maxlength="10"/><span style="color:red">*</span></td>
</tr>

<tr>
 <td>Nom de famille : </td>
 <td><input name="nom" value="" size="40" maxlength="40" /><span style="color:red">*</span></td>
</tr>

<tr>
 <td>Prenom : </td> 
 <td><input name="prenom" value="" size="40" maxlength="40"/><span style="color:red">*</span></td>
</tr>

<tr>
 <td>Adresse (rue) : </td> 
 <td><input name="adr" value="" size="40" maxlength="40"/></td>
</tr>

<tr>
 <td>Code Postal : </td> 
 <td><input name="cp" value="" size="5" maxlength="5" /></td>
</tr>

<tr>
 <td>Ville : </td> 
 <td><input name="ville" value="" size="40" maxlength="40"/></td>
</tr>

<tr>
 <td>Pays</td> 
 <td>
 <select> 
 <c:forEach items="${listePays}" var="pays" >
  <option value="${pays.code}" >${pays.nom} (${pays.code})</option>
  <%-- 
  <option value="${p}" > ${p} </option>
  --%>
 </c:forEach>
 </select>
 </td>
</tr>
 
</table>

<input type="submit" value=" Enregistrer "/>

</form>
<span style="color:red">*</span> Champ obligatoire<br>

<%--
Object o = application.getAttribute("listePays");
if ( o != null )
{
	java.util.LinkedList l = (java.util.LinkedList) o ;
	out.println("Attribut 'listePays' trouvé dans 'application'. size = " + l.size() );
}
else
{
	out.println("Attribut 'listePays' non trouvé dans 'application' ");
}
--%>
</body>
</html>