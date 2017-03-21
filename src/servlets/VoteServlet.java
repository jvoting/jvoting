package Servlets;

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





@WebServlet("/upload")
@MultipartConfig


public class VoteServlet  extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		 Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
	    ArrayList<String> result = getStringFromInputStream(fileContent);
	    // ... (do your job here)
	    PrintWriter  pr = response.getWriter();
	    //commentt json
	    JSONObject obj = new JSONObject();
	    JSONArray jsonCandidats = new JSONArray();
	    JSONArray jsonVotes = new JSONArray();
	    int i=0,j=1,nbcandidats=0;
	   
	     

	    for(String item:result){
	    	
	   
	    if (item.matches("^-?\\d+$")){
	   	nbcandidats= Integer.parseInt(item);	
	    	
	    } else if(item.matches(".*[a-zA-Z].*")){
	    	i++;
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
	    
	    System.out.println(i);
	    
	    obj.put("listecandidates",jsonCandidats);
	    obj.put("Votes",jsonVotes);
	    obj.put("nombreDeCandidats",nbcandidats);
	    
	   
	    try(FileWriter file = new FileWriter("/home/dev1/sample.json");) {
        file.write(obj.toJSONString());
        file.flush();
	    }
	    pr.println("Votre fichier json est cree");
	    
	    
	    
	   /* InputStream  is = new URL("http://www.preflib.org/data/election/dots/").openStream();
	    String resultUrl = getStringFromInputStream(is);
	    
	    System.out.println(resultUrl);*/
	    
	    
	}

	private static ArrayList<String> getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		ArrayList<String> sb = new ArrayList<String>();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb;

	}

}




