package cat_tests.appmanager;

import cat_tests.model.SectionData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.*;
import java.util.List;

import static java.lang.System.getProperty;

public class MongoHelper {

    public static void connectToMongo(String host, Integer port) {
        MongoClient mongo = new MongoClient(host, port);
    }

    public static void connectToSection(MongoClient mongo) {
        MongoCollection<Document> sectionsCollection =
                mongo.getDatabase(getProperty("market.database")).getCollection("market_section");
    }

    public static void readSection(MongoCollection<Document> sectionsCollection) {
        Document section = sectionsCollection.find(Filters.eq("name", "Транспорт")).first();
    }

    public static void saveAsJson(List<SectionData> section, File file) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(section);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

}
