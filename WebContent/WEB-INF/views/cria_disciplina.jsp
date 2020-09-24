<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Adicionando Projeto</title>
</head>
<body>

<form action='criadisciplina' method='post'>
Projeto: <input type='text' name='projeto' ><br>
Dificuldade (0-10): <input type='number' name='dificuldade' ><br>
<input type ='hidden' name='alunonome' value='${param.alunonome}'>
<input type ='hidden' name='alunoid' value='${param.alunoid}'>	
<input type ='submit' value='atualizar'>


</form>
</body>
</html>