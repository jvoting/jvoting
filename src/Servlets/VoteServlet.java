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
	    JSONArray jsonArray = new JSONArray();
	    
	     

	    for(String item:result){
	    pr.println(item);
	    jsonArray.add(item);
	    System.out.println(item);
	    }
	   /* obj.put("listecandidate",jsonArray );
	    try(FileWriter file = new FileWriter("/home/dev1/sample.json");) {
        System.out.println("hohohoho" + jsonArray);
        file.write(obj.toJSONString());
        file.flush();
	    }*/
	    
	    
	    
	    
	   /* InputStream  is = new URL("http://www.preflib.org/data/election/dots/").openStream();
	    String resultUrl = getStringFromInputStream(is);
	    pr.println(resultUrl);
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




