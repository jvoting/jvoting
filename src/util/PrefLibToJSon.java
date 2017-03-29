package util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PrefLibToJSon {
	public static JSONObject convertToJson(String pl) {
		JSONObject obj = new JSONObject();
		JSONArray jsonCandidats = new JSONArray();
		JSONArray jsonVotes = new JSONArray();
		InputStream stream = new ByteArrayInputStream(pl.getBytes(StandardCharsets.UTF_8));
		BufferedReader br = null;
		ArrayList<String> sb = new ArrayList<String>();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(stream));
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
		int i = 0, j = 1, nbcandidats = 0;

		for (String item : sb) {

			if (item.matches("^-?\\d+$")) {
				nbcandidats = Integer.parseInt(item);

			} else if (item.matches(".*[a-zA-Z].*")) {
				i++;
				String[] parts = item.split(",");
				JSONObject objectCandidat = new JSONObject();
				objectCandidat.put("Name", parts[1]);
				objectCandidat.put("id", Integer.parseInt(parts[0]));
				jsonCandidats.add(objectCandidat);

			} else if (sb.indexOf(item) != nbcandidats + 1) {

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

		System.out.println(i);
		obj.put("listecandidates", jsonCandidats);
		obj.put("Votes", jsonVotes);
		obj.put("nombreDeCandidats", nbcandidats);


		return obj;
	}
}
