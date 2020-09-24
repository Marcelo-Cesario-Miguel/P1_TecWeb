# P1_TecWeb

Este repositório contém o código do primeiro projeto da disciplina Tecnologias Web, que foi desenvolvido utilizando o framework [Eclipse](https://www.eclipse.org/downloads/) e [MySQL](https://www.mysql.com/).
 
## Pré-Requisitos

Para rodar, é necessário criar algumas tabelas no MySQL e configurar o código para o seu MYSQL

### Instrução para a criação das tabelas

- Crie um database chamado escola:
    ```bash
    $ CREATE DATABASE escola;
    ```
esse database deve conter 3 tabelas, sendo elas: aluno, disciplina e aluno_disciplina (sendo uma many-to-many).
Agora, dentro desse database ( `$ CREATE DATABASE escola;` ), crie as seguintes tabelas
- aluno:

    ```bash
    $ CREATE TABLE aluno (id INT NOT NULL AUTO_INCREMENT, nome VARCHAR(32) NOT NULL,
    curso VARCHAR(32) NOT NULL, PRIMARY KEY (ID));
    ```
- disciplina:

    ```bash
    $ CREATE TABLE disciplina (id INT NOT NULL AUTO_INCREMENT, nome VARCHAR(32) NOT NULL,
    dificuldade INT(2) NOT NULL, PRIMARY KEY (ID));
    ```
- aluno_disciplina:

    ```bash
    $ CREATE TABLE aluno_disciplina (id INT NOT NULL AUTO_INCREMENT, aluno_id INT NOT NULL REFERENCES aluno(id),
    disciplina_id INT NOT NULL REFERENCES disciplina(id),PRIMARY KEY (ID));
    ```
 
 ### Modificações no código
 
 Feito as tabelas, vá em *.\build\classes\br\edu\insper* e modifique o arquivo *DAO.CLASS*, colocando seus dados na linha `16`
 
 #### Algumas considerações :)
Apesar do nome, o site foi feito para que a tabela de disciplina seja na verdade uma tabela de projetos. Dessa forma, o site tenta passar o entendimento de ser uma plataforma parecida com o trello, em que temos uma equipe, de alunos de diferentes cursos trabalhando em conjunto, permitindo que cada membro possa realizar projetos individuais ou em grupo.
