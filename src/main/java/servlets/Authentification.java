package main.java.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.modele.Utilisateur;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
@MultipartConfig
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
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
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "jvoting" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
		List<Utilisateur> users = entitymanager.createNamedQuery("SELECT u FROM Utilisateur u").getResultList();
		boolean res = false;
		for(int i = 0; i< users.size();i++)
		{
			if(users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(mdp))
			{
				res = true;
			}
		}
		
		if(!res)
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		else
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
	}

}
