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
		try {
			DAO dao = new DAO();
		int dificuldade =Integer.valueOf(request.getParameter("dificuldade"));
		List<AlunoJoinDisciplina> alunos_disciplinas= null;
		List<AlunoJoinDisciplina> alunos_disciplinas_filtrados = new ArrayList<AlunoJoinDisciplina>();
		alunos_disciplinas= dao.getLista();
		for(AlunoJoinDisciplina i:alunos_disciplinas) {
			if(i.getDificuldade()== dificuldade) {
				alunos_disciplinas_filtrados.add(i);
			}
		}
		request.setAttribute("alunos_disciplinas", alunos_disciplinas_filtrados);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/filtra.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
