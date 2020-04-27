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

public class MongoHelper {


    public static void main(String[] args) {

    }

    public static void readConfig() throws IOException {
        FileReader fr = new FileReader("./src/test/java/cat_tests/conf/mongo.properties");
        BufferedReader reader = new BufferedReader(fr);
        int data = reader.read();
        while (data != -1) {
            data = reader.read();
        }
        reader.close();
    }

    public static void connectToMongo() {
        MongoClient mongo = new MongoClient("cm-mongo01x-t.test.cardsmobile.ru", 27017);
    }

    public static void connectToSection(MongoClient mongo) {
        MongoCollection<Document> sectionsCollection =
                mongo.getDatabase("gogol").getCollection("market_section");
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
