# P1_TecWeb

Este repositório contém o código do primeiro projeto da disciplina Tecnologias Web, que foi desenvolvido utilizando o framework [Eclipse](https://www.eclipse.org/downloads/) e [MySQL](https://www.mysql.com/).
 
## Pré-Requisitos

Para rodar, basta apenas criar as tabelas no MySQL para o projeto funcionar.
### Instrução para a criação das tabelas

- Crie um database chamadoescola
esse database deve conter 3 tabelas, sendo elas: aluno, disciplina e aluno_disciplina (sendo uma many-to-many).
- aluno:

    `CREATE TABLE aluno (
 id INT NOT NULL AUTO_INCREMENT,
 nome VARCHAR(32) NOT NULL,
 curso VARCHAR(32) NOT NULL,
 PRIMARY KEY (ID)
);`
- disciplina:

CREATE TABLE disciplina (
 id INT NOT NULL AUTO_INCREMENT,
 nome VARCHAR(32) NOT NULL,
 dificuldade INT(2) NOT NULL,
 PRIMARY KEY (ID));`
- aluno_disciplina:

    `CREATE TABLE disciplina (
 id INT NOT NULL AUTO_INCREMENT,
 aluno_id INT NOT NULL REFERENCES aluno(id),
 disciplina_id INT NOT NULL REFERENCES disciplina(id),
 PRIMARY KEY (ID));`
 
Apesar do nome, o site foi feito para que a tabela de disciplina seja na verdade uma tabela de projetos. Dessa forma, o site tenta passar o entendimento de ser uma plataforma parecida com o trello, em que temos uma equipe, de alunos de diferentes cursos trabalhando em conjunto, permitindo que cada membro possa realizar projetos individuais ou em grupo.
