package servlet;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class ListProfilVote {

	public ArrayList<String> print() throws UnknownHostException {

		ArrayList<String> l = new ArrayList<String>();
		String str = "";

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("votingdatabase");
		DBCollection col = db.getCollection("profilVote");

		DBCursor cursorDoc = col.find();

		while (cursorDoc.hasNext()) {

			str = cursorDoc.next().get("nameProfilVote").toString();
			l.add(str);
		}

		System.out.println(l);

		return l;

	}

}
