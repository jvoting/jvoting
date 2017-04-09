package servlet;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Services.ConvertStreamToString;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@WebServlet("/upload")
@MultipartConfig
public class AddProfilVoteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get nae of profile Vote
		String nameProfilVote = request.getParameter("nameProfilVote");
		// System.out.println(nameProfilVote);

		Part filePart = request.getPart("file"); //

		String fileName = Paths.get(filePart.getSubmittedFileName())
				.getFileName().toString(); // MSIE fix.
		InputStream fileContent = filePart.getInputStream();
		ConvertStreamToString Convert = new Services.ConvertStreamToString();
		ArrayList<String> result = Convert
				.getStringFromInputStream(fileContent);
		// ... (do your job here)
		PrintWriter pr = response.getWriter();
		// commentt json
		JSONObject obj = new JSONObject();
		JSONArray jsonCandidats = new JSONArray();
		JSONArray jsonVotes = new JSONArray();
		int j = 1, nbcandidats = 0;

		for (String item : result) {

			if (item.matches("^-?\\d+$")) {
				nbcandidats = Integer.parseInt(item);

			} else if (item.matches(".*[a-zA-Z].*")) {

				String[] parts = item.split(",");
				JSONObject objectCandidat = new JSONObject();
				objectCandidat.put("Name", parts[1]);
				objectCandidat.put("id", Integer.parseInt(parts[0]));
				jsonCandidats.add(objectCandidat);

			} else if (result.indexOf(item) != nbcandidats + 1) {

				String[] parts = item.split(",");

				ArrayList<Integer> preferenceArray = new ArrayList<Integer>();
				JSONObject objectVote = new JSONObject();
				objectVote.put("nombreElecteurs", Integer.parseInt(parts[0]));
				for (j = 1; j < parts.length; j++) {

					preferenceArray.add(Integer.parseInt(parts[j]));
				}
				objectVote.put("preferences", preferenceArray);
				jsonVotes.add(objectVote);

			}

		}

		obj.put("nameProfilVote", nameProfilVote);
		obj.put("listecandidates", jsonCandidats);
		obj.put("Votes", jsonVotes);
		obj.put("nombreDeCandidats", nbcandidats);

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("votingdatabase");
		DBCollection col = db.getCollection("profilVote");

		DBObject dbo = (DBObject) JSON.parse(obj.toJSONString());
		col.insert(dbo);

		pr.println("Votre profil de vote est enregistré  :) \n");

	}

}
