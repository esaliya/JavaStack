package mongodb;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.util.Arrays;
import java.util.Set;

public class TestClient {
    public static void main(String[] args) throws Exception{
//        MongoClient mongoClient = new MongoClient();
// or
//        MongoClient mongoClient = new MongoClient( "localhost" );
// or
        MongoClient mongoClient = new MongoClient(args[0]);
// or, to connect to a replica set, supply a seed list of members
//        MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
//                new ServerAddress("localhost", 27018),
//                new ServerAddress("localhost", 27019)));

        DB db = mongoClient.getDB( "test" );
        Set<String> collections = db.getCollectionNames();
        for(String s : collections){
            System.out.println(s);
            DBCollection dbCollection = db.getCollection(s);
            System.out.println(dbCollection.findOne());
        }



    }
}
