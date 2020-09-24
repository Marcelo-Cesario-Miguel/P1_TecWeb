package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cria
 */
@WebServlet("/criadisciplina")
public class criadisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public criadisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cria_disciplina.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Disciplina disciplina= new Disciplina();
		disciplina.setMateria(request.getParameter("projeto"));
		disciplina.setDificuldade(Integer.valueOf(request.getParameter("dificuldade")));
		try {
			dao.adicionaDisciplina(disciplina);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// agora adicionando essa disciplina na many to many com o login do aluno
		
		int alunoID = Integer.valueOf(request.getParameter("alunoid"));
		try {
			// Dei um post nas tarefas, agora vou dar um get, pegar o id e dar outro post na alunos-projetos
			Disciplina disciplina_updated = dao.getDisciplina(disciplina.getMateria());
			disciplina.setId(disciplina_updated.getId());
			dao.adicionaAlunoDisciplina(alunoID, disciplina.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("lista");
		dispatcher.forward(request, response);
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
