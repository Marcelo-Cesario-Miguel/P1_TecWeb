package br.edu.insper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/cria_aluno.jsp");
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
				Aluno aluno= new Aluno();
				aluno.setNome(request.getParameter("nome"));
				aluno.setCurso(request.getParameter("curso"));
				List<Aluno> alunos= null;
				
				try {
					dao.adicionaAluno(aluno);
					alunos= dao.getAlunos();
					for(Aluno i:alunos) {
						if (i.getNome().equals(aluno.getNome())) {
							aluno.setId(i.getId());
						}
					}
					
					request.setAttribute("aluno", aluno);
					RequestDispatcher dispatcher = request.getRequestDispatcher("lista");
					dispatcher.forward(request, response);
					dao.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
