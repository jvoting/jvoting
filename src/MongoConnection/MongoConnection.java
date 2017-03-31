package MongoConnection;

import java.net.UnknownHostException;






import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoConnection {
	
	public static void main(String[] args) throws UnknownHostException {
	
   ArrayList<DBObject> list = new ArrayList<>();	
		
	MongoClient mongo = new MongoClient("localhost", 27017);
	DB db = mongo.getDB("votingdatabase");
	DBCollection col = db.getCollection("profilVote");
	
	/*DBObject dbo = (DBObject) JSON.parse("{'name':'brahim', 'age':30}"); 
    
	       
	list.add(dbo);
	col.insert(list);*/
	
	DBCursor cursorDoc = col.find();
	while (cursorDoc.hasNext()) {
		System.out.println(cursorDoc.next().get("nameProfilVote"));
	}
	
	System.out.println(col); 
	}
}
