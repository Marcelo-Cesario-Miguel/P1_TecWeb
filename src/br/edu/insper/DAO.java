package br.edu.insper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.jdbc.Driver");
	 connection = DriverManager.getConnection(
	"jdbc:mysql://localhost/escola", "root", "123456");
	}
	
	public List<AlunoJoinDisciplina> getLista() throws SQLException {
		List<AlunoJoinDisciplina> alunos_disciplinas = new ArrayList<AlunoJoinDisciplina>();
		PreparedStatement stmt = connection.
		 prepareStatement("SELECT aluno.nome AS 'alunonome',aluno.id AS 'alunoid',aluno.curso, disciplina.nome AS 'disciplinanome', disciplina.id AS 'disciplinaid',disciplina.dificuldade FROM aluno, disciplina, aluno_disciplina WHERE aluno.id = aluno_disciplina.aluno_id AND disciplina.id = aluno_disciplina.disciplina_id");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			AlunoJoinDisciplina aluno_disciplina= new AlunoJoinDisciplina();
			aluno_disciplina.setAlunoId(rs.getInt("alunoid"));
			aluno_disciplina.setAluno(rs.getString("alunonome"));
			aluno_disciplina.setCurso(rs.getString("curso"));
			aluno_disciplina.setDisciplinaId(rs.getInt("disciplinaid"));
			aluno_disciplina.setMateria(rs.getString("disciplinanome"));
			aluno_disciplina.setDificuldade(rs.getInt("dificuldade"));
			alunos_disciplinas.add(aluno_disciplina);
		}
		rs.close();
		stmt.close();
		return alunos_disciplinas;
		}
	
	public List<Aluno> getAlunos() throws SQLException {
		List<Aluno> alunos= new ArrayList<Aluno>();
		PreparedStatement stmt = connection.
		 prepareStatement("SELECT * FROM aluno");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Aluno aluno= new Aluno();
			aluno.setId(rs.getInt("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setCurso(rs.getString("curso"));
			alunos.add(aluno);
		}
		rs.close();
		stmt.close();
		return alunos;
		}
	// fiz retornando já o projeto.
	public Disciplina getDisciplina(String projeto) throws SQLException {
		Disciplina disciplina= new Disciplina();
		PreparedStatement stmt = connection.
		 prepareStatement("SELECT * FROM disciplina WHERE disciplina.nome = '"+projeto+"'");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			disciplina.setId(rs.getInt("id"));
			disciplina.setMateria(rs.getString("nome"));
			disciplina.setDificuldade(rs.getInt("dificuldade"));
		}
		rs.close();
		stmt.close();
		return disciplina;
		}
	
	public Aluno validaAluno(String nome) throws SQLException {
		Aluno aluno = new Aluno();
		PreparedStatement stmt = connection.
		 prepareStatement("SELECT * FROM aluno");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			if (rs.getString("nome").equals(nome)) {
				aluno.setCurso(rs.getString("curso"));
				aluno.setNome(rs.getString("nome"));
				aluno.setId(rs.getInt("id"));
				rs.close();
				stmt.close();
				return aluno;
			}
		}
		System.out.println("Retornando vazio");
		rs.close();
		stmt.close();
		return aluno;
		}
	
	public void close() throws SQLException {
		connection.close();
		}
	
	public void adicionaAluno(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO aluno" +
		"(nome,curso) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,aluno.getNome());
		stmt.setString(2,aluno.getCurso());
		
		stmt.execute();
		stmt.close();
		}
	public void adicionaDisciplina(Disciplina disciplina) throws SQLException {
		String sql = "INSERT INTO disciplina" +
		"(nome,dificuldade) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,disciplina.getMateria());
		stmt.setInt(2,disciplina.getDificuldade());
		stmt.execute();
		stmt.close();
		
		}
	public void adicionaAlunoDisciplina(int alunoID,int disciplinaID) throws SQLException {
		// linkando agora o aluno logado e a disciplina na tabela Many-to-Many
		String sql = "INSERT INTO aluno_disciplina" +"(aluno_id,disciplina_id) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1,alunoID);
		stmt.setInt(2,disciplinaID);
		stmt.execute();
		stmt.close();
			}
	
	public void alteraAluno(Aluno aluno) throws SQLException {
		String sql = "UPDATE aluno SET " +
		 "nome=?, curso=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, aluno.getNome());
		stmt.setString(2,aluno.getCurso());
		stmt.setInt(3, aluno.getId());
		stmt.execute();
		stmt.close();
		}
	
	public void alteraDisciplina(Disciplina disciplina) throws SQLException {
		String sql = "UPDATE disciplina SET " +
		 "nome=?, dificuldade=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, disciplina.getMateria());
		stmt.setInt(2,disciplina.getDificuldade());
		stmt.setInt(3, disciplina.getId());
		stmt.execute();
		stmt.close();
		}
	
	public void removeDisciplina(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM aluno_disciplina WHERE aluno_disciplina.disciplina_id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		}
	
	public List<AlunoJoinDisciplina> getListaByDificuldade(String ordem) throws SQLException {
		
		List<AlunoJoinDisciplina> alunos_disciplinas= new ArrayList<AlunoJoinDisciplina>();
		if (ordem .equals("DESC")) {
			PreparedStatement stmt = connection.
					 prepareStatement("SELECT aluno.nome AS 'alunonome',aluno.id AS 'alunoid',aluno.curso, disciplina.nome AS 'disciplinanome', disciplina.id AS 'disciplinaid',disciplina.dificuldade FROM aluno, disciplina, aluno_disciplina WHERE aluno.id = aluno_disciplina.aluno_id AND disciplina.id = aluno_disciplina.disciplina_id ORDER BY dificuldade DESC");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				AlunoJoinDisciplina aluno_disciplina= new AlunoJoinDisciplina();
				aluno_disciplina.setAlunoId(rs.getInt("alunoid"));
				aluno_disciplina.setAluno(rs.getString("alunonome"));
				aluno_disciplina.setCurso(rs.getString("curso"));
				aluno_disciplina.setDisciplinaId(rs.getInt("disciplinaid"));
				aluno_disciplina.setMateria(rs.getString("disciplinanome"));
				aluno_disciplina.setDificuldade(rs.getInt("dificuldade"));
				alunos_disciplinas.add(aluno_disciplina);
			}
			rs.close();
			stmt.close();
			return alunos_disciplinas;
					
		}
		else {
			PreparedStatement stmt = connection.
					 prepareStatement("SELECT aluno.nome AS 'alunonome',aluno.id AS 'alunoid',aluno.curso, disciplina.nome AS 'disciplinanome', disciplina.id AS 'disciplinaid',disciplina.dificuldade FROM aluno, disciplina, aluno_disciplina WHERE aluno.id = aluno_disciplina.aluno_id AND disciplina.id = aluno_disciplina.disciplina_id ORDER BY dificuldade ASC");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				AlunoJoinDisciplina aluno_disciplina= new AlunoJoinDisciplina();
				aluno_disciplina.setAlunoId(rs.getInt("alunoid"));
				aluno_disciplina.setAluno(rs.getString("alunonome"));
				aluno_disciplina.setCurso(rs.getString("curso"));
				aluno_disciplina.setDisciplinaId(rs.getInt("disciplinaid"));
				aluno_disciplina.setMateria(rs.getString("disciplinanome"));
				aluno_disciplina.setDificuldade(rs.getInt("dificuldade"));
				alunos_disciplinas.add(aluno_disciplina);
			}
			rs.close();
			stmt.close();
			return alunos_disciplinas;
		}
	}

}


