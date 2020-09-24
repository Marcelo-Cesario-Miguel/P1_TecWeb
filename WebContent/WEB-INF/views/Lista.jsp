<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,br.edu.insper.* " %>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<a class ='btn btn-danger' href=''> Log out</a>
<div class="page-header">
            <h1>Lista das suas tasks e de seus membros, ${aluno.getNome()}</h1>
        </div>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Filtrar por
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Action</a>
    <a class="dropdown-item" href="#">Another action</a>
    <a class="dropdown-item" href="#">Something else here</a>
  </div>
</div>
<div class='container'>
	<p>Ordenar por:</p>
	<div class= 'row'>
		<div class="col-sm-4">
			<form action='ordenar_pela_idade' method='get'>
			<input type ='hidden' name='ordem' value='ASC'>
			<input type='submit' value='Crescente'>
			</form>
	    </div>
	    <div class="col-sm-4">
			<form action='ordenar_pela_idade' method='get'>
			<input type ='hidden' name='ordem' value='DESC'>
			<input type='submit' value='Decrescente'>
			</form>
	    </div>
	</div>
</div>

<table class="table table-striped table-responsive table-bordered">
<thead>
            <tr>
                <th>Nome</th>
                <th>Curso</th>
                <th>Disciplina</th>
                <th>Dificuldade</th>
            </tr>
        </thead>

<c:forEach var= "aluno_disciplina" items="${alunos_disciplinas}" >
<tr>
<td>${aluno_disciplina.getAluno()}</td>
<td>${aluno_disciplina.getCurso()}</td>
<td>${aluno_disciplina.getMateria()} </td>
<td>${aluno_disciplina.getDificuldade()} </td>
<td>
<form action='remove' method='post'>
<input type='hidden' name='id' value='${aluno_disciplina.getDisciplinaId()}'>
<input type='submit' value='remover'>
</form>
<form action='altera' method='get'>
<input type ='hidden' name='materia' value='${aluno_disciplina.getMateria()}'>
<input type ='hidden' name='dificuldade' value='${aluno_disciplina.getDificuldade()}'>
<input type ='hidden' name='id' value='${aluno_disciplina.getDisciplinaId()}'>
<input type='submit' value='atualizar'>
</form>
</td>
</tr>
</c:forEach>
</table>
<p> Cuidado para não apagar sem querer os projetos de seus amigos </p>
<form action='criadisciplina' method='get'>
<input type ='hidden' name='alunoid' value='${aluno.getId()}'>
<input type="submit" class="btn btn-primary" value='Adicione tarefas para você'>
</form>

<div class='container'>
<form action='filtra' method='get'>
<h4>Busca pela idade</h4>
<input type='number' class="form-control" name='idade' placeholder="Filtrar"><br>

<button type="submit" class="btn btn-primary" value='filtrar'>Filtrar</button>
</form>
 </div>

</body>

</html>