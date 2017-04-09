package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Utilisateur;

/**
 * Servlet implementation class Authentification
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("jvoting");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("SELECT u FROM Utilisateur u"
				+ " WHERE u.email LIKE :email AND u.password LIKE :pwd");
		query.setParameter("email", login);
		query.setParameter("pwd", mdp);
		Utilisateur u = (Utilisateur) query.getSingleResult();
		if (u != null)
			getServletContext().getRequestDispatcher("/accueil.jsp").forward(
					request, response);
		else
			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);

	}

}
