<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Projeto</title>
</head>
<body>
<form action='altera' method='post'>
Projeto: <input type='text' name='materia' value='${param.materia}'><br>
Dificuldade: <input type='number' name='dificuldade' value ='${param.dificuldade}' ><br>
<input type ='hidden' name='id' value='${param.id}'>
<input type ='hidden' name='alunonome' value='${param.alunonome}'>
<input type ='hidden' name='alunoid' value='${param.alunoid}'>			

<input type ='submit' value='atualizar'>


</form>
</body>
</html>