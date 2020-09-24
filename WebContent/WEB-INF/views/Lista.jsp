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
<div class='container'>
<a class ='btn btn-danger' href='register'> Log out</a>
<div class="page-header">
            <h1>Bem vindo de volta ${aluno.getNome()}</h1>
            <h2>Lista de tarefas da sua equipe</h2>
        </div>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Ordenar pela dificuldade
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <form class ="dropdown-item" action='ordenar_pela_dificuldade' method='post'>
			<input type ='hidden' name='ordem' value='ASC'>
			<input type ='hidden' name='alunonome' value='${aluno.getNome()}'>
			<input type ='hidden' name='alunoid' value='${aluno.getId()}'>
			<input type='submit' value='Crescente'>
			</form>
    			<form action='ordenar_pela_dificuldade' method='post'>
			<input type ='hidden' name='ordem' value='DESC'>
			<input type ='hidden' name='alunonome' value='${aluno.getNome()}'>
			<input type ='hidden' name='alunoid' value='${aluno.getId()}'>
			<input type='submit' value='Decrescente'>
			</form>
  </div>
</div>
<table class="table table-striped table-responsive table-bordered">
<thead>
            <tr>
                <th>Nome</th>
                <th>Curso</th>
                <th>Projeto</th>
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
<input type ='hidden' name='alunonome' value='${aluno.getNome()}'>
<input type ='hidden' name='alunoid' value='${aluno.getId()}'>			
<input type='submit' class ='btn btn-danger' value='remover'>
</form>
</td>
<td>
<form action='altera' method='get'>
<input type ='hidden' name='materia' value='${aluno_disciplina.getMateria()}'>
<input type ='hidden' name='dificuldade' value='${aluno_disciplina.getDificuldade()}'>
<input type ='hidden' name='id' value='${aluno_disciplina.getDisciplinaId()}'>
<input type ='hidden' name='alunonome' value='${aluno.getNome()}'>
<input type ='hidden' name='alunoid' value='${aluno.getId()}'>			
<input type='submit' class ='btn btn-info' value='atualizar'>
</form>
</td>
</tr>
</c:forEach>
</table>
<form action='visao_geral' method='post'>
<input type ='hidden' name='alunoid' value='${aluno.getId()}'>
<input type ='hidden' name='alunonome' value='${aluno.getNome()}'>
<input type="submit" class="btn btn-primary" value='Visão geral'>
</form>
<form action='criadisciplina' method='get'>
<input type ='hidden' name='alunoid' value='${aluno.getId()}'>
<input type ='hidden' name='alunonome' value='${aluno.getNome()}'>
<input type="submit" class="btn btn-success" value='Adicione tarefas para você'>
</form>
<div class='container'>
<form action='filtra' method='post'>
<h4>Busca pelo membro</h4>
<input type='text' class="form-control" name='nome' placeholder="Nome do membro"><br>
<input type ='hidden' name='alunonome' value='${aluno.getNome()}'>
<input type ='hidden' name='alunoid' value='${aluno.getId()}'>	
<button type="submit" class="btn btn-info" value='filtrar'>Buscar</button>
</form>
 </div>
</div>
</body>

</html>