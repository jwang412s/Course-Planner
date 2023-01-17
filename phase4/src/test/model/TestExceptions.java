package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestExceptions {

    @Test
    void testSizeExceptionAppears() {
        ContentList cl = new ContentList();
        try {
            cl.obtainLastContent();
            fail("IOException expected");
        } catch (ArrayIndexOutOfBoundsException e) {
            // pass
        }
    }

    @Test
    void testNoSizeException() {
        ContentList cl = new ContentList();
        ArrayList listOfTopics = new ArrayList();
        ArrayList listofSubTopics = new ArrayList();
        ArrayList listOfDates = new ArrayList();
        Content c = new Content("cpsc", listOfTopics, listofSubTopics, listOfDates);
        cl.addContent(c);
        try {
            assertEquals(1, cl.getContentlistNumContents());
            assertEquals(c,cl.getLastContent());
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("Couldn't read from file");
        }
    }

}
