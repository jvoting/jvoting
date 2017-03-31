package main.java.servlets;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Services.ConvertStreamToString;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;




@WebServlet("/AddProfilVoteURLServlet")
@MultipartConfig
public class AddProfilVoteURLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProfilVoteURLServlet() {
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
		
		String nameProfilVote = request.getParameter("nameProfilVote");
		String s=(String)request.getParameter("profilVoteUrl");
		URL url = new URL(s);
		URLConnection connection = url.openConnection();
		
		
		InputStream in = connection.getInputStream();
		
		ConvertStreamToString Convert = new ConvertStreamToString();
		 ArrayList<String> result = Convert.getStringFromInputStream(in);
		
		
		System.out.println(result);
		 PrintWriter  pr = response.getWriter();
		    //commentt json
		    JSONObject obj = new JSONObject();
		    JSONArray jsonCandidats = new JSONArray();
		    JSONArray jsonVotes = new JSONArray();
		    int j=1,nbcandidats=0;
		   
		     

		    for(String item:result){
		    	
		   
		    if (item.matches("^-?\\d+$")){
		   	nbcandidats= Integer.parseInt(item);	
		    	
		    } else if(item.matches(".*[a-zA-Z].*")){
		    	
		    	String[] parts = item.split(",");
		    	JSONObject objectCandidat = new JSONObject();
		    	objectCandidat.put("Name", parts[1]);
		    	objectCandidat.put("id", Integer.parseInt(parts[0]));
		    	jsonCandidats.add(objectCandidat);
		    	
		    	
		    	
		    }
		    else if ( result.indexOf(item) != nbcandidats+1) {
		    	
		    	String[] parts = item.split(",");
		    	
		    	
		    	
		    	ArrayList<Integer> preferenceArray = new ArrayList<Integer>();
		    	JSONObject objectVote = new JSONObject();
		    	objectVote.put("nombreElecteurs", Integer.parseInt(parts[0]));
		    	for(j=1; j< parts.length; j++) {
		    	
		    		preferenceArray.add(Integer.parseInt(parts[j]));   		
		    	}
		        objectVote.put("preferences",preferenceArray);
		    	jsonVotes.add(objectVote);
		    	
		    }
		    
		    //jsonArray.add(item);
		    //System.out.println(item);
		    }
		    
		    
		    obj.put("nameProfilVote",nameProfilVote );
		    obj.put("listecandidates",jsonCandidats);
		    obj.put("Votes",jsonVotes);
		    obj.put("nombreDeCandidats",nbcandidats);
		    
		    MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("votingdatabase");
			DBCollection col = db.getCollection("profilVote");
			
			DBObject dbo = (DBObject) JSON.parse(obj.toJSONString());
			col.insert(dbo);
			
		   
			DBCursor cursorDoc = col.find();
			while (cursorDoc.hasNext()) {
				System.out.println(cursorDoc.next());
			}
		   /* try(FileWriter file = new FileWriter("C:/Users/Brahim/workspace/sample.json");) {
	        file.write(obj.toJSONString());
	        file.flush();
		    }*/
		    
		    
		    pr.println("Votre fichier json est cree \n");
		  /*  for(String item:result){
		    	pr.println(item);
		    }*/
		    
		    
		    
		   /* InputStream  is = new URL("http://www.preflib.org/data/election/dots/").openStream();
		    String resultUrl = getStringFromInputStream(is);
		    
		    System.out.println(resultUrl);*/
		
	}
	
	
}
