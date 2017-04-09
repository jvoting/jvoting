package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class ProfilVoteCurrent
 */
public class ProfilVoteCurrent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilVoteCurrent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter  pr = response.getWriter();
        StringBuffer urlbuffer =  request.getRequestURL();
		String urlString =  urlbuffer.toString();
		String[] parts = urlString.split("/");
		
		String identifiant =  parts[parts.length-2];
		int intIdentifiant = Character.getNumericValue(identifiant.charAt(1)) ;
		
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("votingdatabase");
		DBCollection col = db.getCollection("profilVote");
		
		BasicDBObject query = new BasicDBObject("numeroProfilVote", intIdentifiant);
		BasicDBObject fields = new BasicDBObject();
		DBCursor cursorDoc = col.find(query, fields);
		DBObject Obj = cursorDoc.next();
		BasicDBList ListCandidats = (BasicDBList) Obj.get("listecandidates");
		BasicDBList ListVotes = (BasicDBList) Obj.get("Votes");
		
		pr.println("Jvoting");
		pr.println("Nombre De Candidats" +" : " + Obj.get("nombreDeCandidats"));
		pr.println("Listes Des Candidats : ");
		for (Object CandidatObj : ListCandidats) {
			
			pr.println(((BasicDBObject) CandidatObj).get("id") + "," + ((BasicDBObject) CandidatObj).get("Name") );
			
		}
		pr.println("Vote :    nbElecteur,[preference] ");
		for (Object vote : ListVotes) {
			
			pr.println(((BasicDBObject) vote).get("nombreElecteurs") + "," + ((BasicDBObject) vote).get("preferences") );
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
