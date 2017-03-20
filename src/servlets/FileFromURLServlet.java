package servlets;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
//import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/fileFromURLServlet")
public class FileFromURLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FileFromURLServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String s=(String)request.getParameter("url");
		URL url = new URL(s);
		URLConnection connection = url.openConnection();
		PrintWriter out=response.getWriter();
		
		InputStream in = connection.getInputStream();
		 ArrayList<String> result = getStringFromInputStream(in);
		byte[] buffer = new byte[512];
		String r="";
		
		while (true) {
				int l=in.read(buffer);
				
				if(l==-1){
					break;
				}
				r+=new String(buffer);
		        
		}
		
		System.out.println(r);
		out.append(r);
		 JSONObject obj = new JSONObject();
		 JSONArray jsonCandidats = new JSONArray();
		 JSONArray jsonVotes = new JSONArray();
		 
		 int i=0,j=1,nbcandidats=0;
		   
		     for(String item:result){
		    	
		        if (item.matches("^-?\\d+$")){
		        	nbcandidats= Integer.parseInt(item);	
		    	
		        } else if(item.matches(".*[a-zA-Z].*"))
		                {
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
     }
		    
		        System.out.println(i);
		        obj.put("listecandidates",jsonCandidats);
		        obj.put("Votes",jsonVotes);
		        obj.put("nombreDeCandidats",nbcandidats);
		    
		   
		        try(FileWriter file = new FileWriter("/home/dev1/test.json");) {
	            file.write(obj.toJSONString());
	            file.flush();
		        }
		        out.println("Your file is created");
		
}

	
	           protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       doGet(request, response);
	        }
	
	     
	    // Fonction pour convertir un inputStream en un tableau de String       
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

