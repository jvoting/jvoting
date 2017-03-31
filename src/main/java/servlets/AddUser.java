package main.java.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.modele.Utilisateur;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
@MultipartConfig
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		
		Utilisateur u = new Utilisateur();
		u.setLogin(login);
		u.setPassword(password);
		u.setPrenom(prenom);
		u.setNom(nom);
		u.setEmail(email);
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "jvoting" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    EntityTransaction tx = entitymanager.getTransaction( );
	    tx.begin();  
	    entitymanager.persist(u);
	    tx.commit();
	    entitymanager.close( );
	    emfactory.close( );
	    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
