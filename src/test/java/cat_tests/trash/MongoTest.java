package cat_tests.trash;

import cat_tests.model.SectionData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class MongoTest {

    public static void main(String[] args) {

        MongoClient mongo = new MongoClient("cm-mongo01x-t.test.cardsmobile.ru", 27017);
        MongoCollection<Document> sectionsCollection =
                mongo.getDatabase("gogol").getCollection("market_section");
        Document section = sectionsCollection.find(Filters.eq("name", "Транспорт")).first();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(section);
        System.out.println(json);
        /**
         * {
         *   "_id": {},
         *   "_class": "ru.cardsmobile.market.entity.Section",
         *   "uid": "transport",
         *   "priority": 8,
         *   "name": "?????????",
         *   "hidden": false,
         *   "segments": []
         * }
         */

        SectionData jsonSection = gson.fromJson(json, SectionData.class);
        System.out.println(jsonSection); // SectionData{title='null'}
        String sectionUid = jsonSection.getUid();
        System.out.println(sectionUid); // transport

    }

    public static void saveAsJson(List<SectionData> section, File file) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(section);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

}
