package cat_tests.trash;

import cat_tests.model.SectionData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.*;

public class TestDataFromMongo {

    public static void main(String[] args) throws IOException {
        typeTestData();
        readTestData();
    }

    public static void typeTestData() throws IOException {
        Writer writer = new FileWriter("./src/test/resources/testData.json");
        MongoClient mongo = new MongoClient("cm-mongo01x-t.test.cardsmobile.ru", 27017);
        MongoCollection<Document> sectionsCollection =
                mongo.getDatabase("gogol").getCollection("market_section");
        Document section = sectionsCollection.find(Filters.eq("name", "Транспорт")).first();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String content = gson.toJson(section);
        writer.write(content);
        writer.close(); 
    }

    public static void readTestData() throws IOException {
        SectionData section = new SectionData();
        FileReader fr = new FileReader("./src/test/resources/testData.json");
        BufferedReader reader = new BufferedReader(fr);
        int data = reader.read();
        while (data != -1) {
            data = reader.read();
        }
        reader.close();
    }



}
