package br.edu.insper;

public class Disciplina {
	
	public Integer id;
	public String materia;
	public Integer dificuldade;

	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getMateria() {return this.materia;}
	public void setMateria(String nome) {this.materia = nome;}
	
	public Integer getDificuldade() {return this.dificuldade;}
	public void setDificuldade(Integer dificuldade) {this.dificuldade= dificuldade;}

}
