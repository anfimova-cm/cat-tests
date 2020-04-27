package cat_tests.trash;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataGenerator {

    public static void main(String[] args) throws IOException {
        typeTestData();
        readTestData();
    }

    public static Iterator<Object[]> typeTestData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        Writer writer = new FileWriter("./src/test/resources/testData.txt");
        String content = "smth";
        writer.write(content);
        writer.close();
        return list.iterator();
    }

    public static void readTestData() throws IOException {
        FileReader fr = new FileReader("./src/test/resources/testData.txt");
        BufferedReader reader = new BufferedReader(fr);
        int data = reader.read();
        while (data != -1) {
//            System.out.print((char) data);
            data = reader.read();
        }
        reader.close();
    }

}
