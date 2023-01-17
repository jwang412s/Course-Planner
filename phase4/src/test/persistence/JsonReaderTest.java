package persistence;

import model.Content;
import model.ContentList;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ContentList cl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyContentList.json.");
        try {
            ContentList cl = reader.read();
            assertEquals(0, cl.getContentlistNumContents());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderStuffInContentList.json.");
        try {
            ContentList cl = reader.read();
            assertEquals(2, cl.getContentlistNumContents());
            Content c1 = cl.getContent(0);
            Content c2 = cl.getContent(1);
            checkContent("course 1 : cpsc 210", c1.getListOfTopic(), c1.getListOfSubTopics(), c1.getListOfDates(), cl.getContent(0));
            checkContent("course 2 : phil 220", c2.getListOfTopic(), c2.getListOfSubTopics(), c2.getListOfDates(), cl.getContent(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}