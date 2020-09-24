package br.edu.insper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filtrar
 */
@WebServlet("/filtra")
public class filtra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filtra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			DAO dao = new DAO();
		String nome_membro=request.getParameter("nome");
		List<AlunoJoinDisciplina> alunos_disciplinas= null;
		List<AlunoJoinDisciplina> alunos_disciplinas_filtrados = new ArrayList<AlunoJoinDisciplina>();
		alunos_disciplinas= dao.getLista();
		int intIndex = 0;
		for(AlunoJoinDisciplina i:alunos_disciplinas) {
			intIndex = i.getAluno().indexOf(nome_membro);
			if(intIndex != -1) {
				alunos_disciplinas_filtrados.add(i);
			}
		}
		
		Aluno aluno = new Aluno();
		aluno.setId(Integer.valueOf(request.getParameter("alunoid")));
		aluno.setNome(request.getParameter("alunonome"));
		request.setAttribute("aluno", aluno);
		
		request.setAttribute("alunos_disciplinas", alunos_disciplinas_filtrados);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/Lista.jsp");
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
