package cat_tests.tests;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoTest {

    public static void main(String[] args) {

        MongoClient mongo = new MongoClient("cm-mongo01x-t.test.cardsmobile.ru", 27017);
        MongoCollection<Document> sectionsCollection =
                mongo.getDatabase("gogol").getCollection("market_section");
        Document section = sectionsCollection.find(Filters.eq("name", "Транспорт")).first();
        System.out.println(section.toJson());

    }

}
