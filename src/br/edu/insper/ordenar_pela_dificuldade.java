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
 * Servlet implementation class ordenar_pela_idade
 */
@WebServlet("/ordenar_pela_dificuldade")
public class ordenar_pela_dificuldade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ordenar_pela_dificuldade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					DAO dao = new DAO();
				
				String ordem =request.getParameter("ordem");
				List<AlunoJoinDisciplina> alunos_disciplinas= null;
				Aluno aluno = new Aluno();
				aluno.setId(Integer.valueOf(request.getParameter("alunoid")));
				aluno.setNome(request.getParameter("alunonome"));
				
				
				alunos_disciplinas = dao.getListaByDificuldade(ordem);
				request.setAttribute("alunos_disciplinas", alunos_disciplinas);
				request.setAttribute("aluno", aluno);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Lista.jsp");
				dispatcher.forward(request, response);
				dao.close();
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

}
