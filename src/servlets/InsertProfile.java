package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import util.PrefLibToJSon;

/**
 * Servlet implementation class InsertProfile
 */
@WebServlet("/InsertProfile")
public class InsertProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HEY");
		PrintWriter out=response.getWriter();
		String tmp=request.getParameter("profil");
		JSONObject json=PrefLibToJSon.convertToJson(tmp);
		out.append(json.toString());
		System.out.println(json.toString());
	}

}
