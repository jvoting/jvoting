package main.java.servlets;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class ProfilVote
 */
@WebServlet("/jsonupload")
@MultipartConfig
public class ProfilVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilVote() {
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
		
		    Part filePart = request.getPart("json"); // Retrieves <input type="file" name="json">
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    InputStream fileContent = filePart.getInputStream();
		    PrintWriter  pr = response.getWriter();
		    
		JSONParser parser = new JSONParser();
		try {
			 
            
 
            JSONObject jsonObject = (JSONObject)parser.parse(
            	      new InputStreamReader(fileContent, "UTF-8"));;
 
            JSONArray voteList = (JSONArray) jsonObject.get("Votes");
            JSONArray listecandidates = (JSONArray) jsonObject.get("listecandidates");
            long nombreDeCandidats =  (long)jsonObject.get("nombreDeCandidats");
 
            pr.println("nombreDeCandidats: " + nombreDeCandidats + "\n");
            
            pr.println("\nListe des candidats:" +  listecandidates + "\n");
            pr.println("\n Votes:" +  voteList + "\n");
            
            
            
           
           
            
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
