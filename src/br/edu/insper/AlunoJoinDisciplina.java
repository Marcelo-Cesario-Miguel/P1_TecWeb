package br.edu.insper;

public class AlunoJoinDisciplina {
	private int alunoId;
	private int disciplinaId;
	private String aluno;
	private String curso;
	private String materia;
	private int dificuldade;
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public int getDisciplinaId() {
		return disciplinaId;
	}
	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}
	public int getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
}
