package persistence;

import model.Content;
import model.ContentList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    void testWriterInvalidFile() {
        try {
            ContentList cl = new ContentList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    void testWriterEmptyContentList() {
        try {
            ContentList cl = new ContentList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyContentList.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyContentList.json");
            cl = reader.read();

            assertEquals(0, cl.getContentlistNumContents());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    void testWriterStuffInContentList() {
        try {
            ContentList cl = new ContentList();
            ArrayList topics = new ArrayList();
            ArrayList subtopics = new ArrayList();
            ArrayList dates = new ArrayList();
            topics.add("midterm 1");
            subtopics.add("abstraction");
            dates.add("feb 24");
            Content c1 = new Content("course 1 : cpsc 210", topics, subtopics, dates);

            ArrayList topics2 = new ArrayList();
            ArrayList subtopics2 = new ArrayList();
            ArrayList dates2 = new ArrayList();
            topics2.add("midterm 2");
            subtopics2.add("proofs");
            dates2.add("mar 1");
            Content c2 = new Content("course 2 : phil 220", topics2, subtopics2, dates2);

            cl.addContent(c1);
            cl.addContent(c2);
            JsonWriter writer = new JsonWriter("./data/testWriterStuffInContentList.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterStuffInContentList.json");
            cl = reader.read();
            assertEquals(2, cl.getContentlistNumContents());
            checkContent("course 1 : cpsc 210", topics, subtopics, dates, cl.getContent(0));
            checkContent("course 2 : phil 220", topics2, subtopics2, dates2, cl.getContent(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
