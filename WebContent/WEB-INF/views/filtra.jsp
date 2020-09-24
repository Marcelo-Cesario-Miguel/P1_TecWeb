<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,br.edu.insper.* " %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Filtrado</title>
</head>
<body>
<h1> Mostrando pessoas de ${param.idade} anos </h1>
<table border='1'>
<tr>
<td>Nome</td>
 <td>Idade</td>
 <td>Dias vividos</td>
</tr>
<c:forEach var= "pessoa" items="${pessoas}" >
<tr>
<td>${pessoa.nome}</td>
<td>${pessoa.idade}</td>
<td>${pessoa.idade *365} </td>
<td>
<form action='remove' method='post'>
<input type='hidden' name='id' value='${pessoa.id}'>
<input type='submit' value='remover'>
</form>
<form action='change' method='get'>
<input type ='hidden' name='id' value='${pessoa.id}'>
<input type ='hidden' name='nome' value='${pessoa.nome}'>
<input type ='hidden' name='idade' value='${pessoa.idade}'>
<input type='submit' value='atualizar'>
</form>
</td>
</tr>
</c:forEach>
</table>

<a class="btn btn-primary" href="" role="button">Informações gerais</a>
<a class="btn btn-primary" href="cria" role="button">Adicionar pessoas</a>

</body>
</html>