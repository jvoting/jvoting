package servlets;

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

@WebServlet("/upload")
@MultipartConfig

public class ShowDataServlet  extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    InputStream fileContent = filePart.getInputStream();
	    String result = getStringFromInputStream(fileContent);

	    request.setAttribute("json", result);
        request.getRequestDispatcher("/showJson.jsp").forward(request, response);
	    
	    //PrintWriter  pr = response.getWriter();
	    
	    //for(String item:result){
	    //	pr.println(item);
	    //}

	}

	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		String sb = "";

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb += line;
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




