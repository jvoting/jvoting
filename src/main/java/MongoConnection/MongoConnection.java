package MongoConnection;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import org.bson.types.BasicBSONList;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoConnection {

	public static void main(String[] args) throws UnknownHostException {

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("votingdatabase");
		DBCollection col = db.getCollection("profilVote");

		BasicDBObject query = new BasicDBObject("nameProfilVote", "kidoun");
		BasicDBObject fields = new BasicDBObject();
		DBCursor cursorDoc = col.find(query, fields);
		DBObject Obj = cursorDoc.next();
		BasicDBList ListCandidats = (BasicDBList) Obj.get("listecandidates");
		BasicDBList ListVotes = (BasicDBList) Obj.get("Votes");

		for (Object vote : ListVotes) {
			System.out.println(((BasicDBObject) vote).get("nombreElecteurs"));
			System.out.println(((BasicDBObject) vote).get("preferences"));
		}
	}

}
