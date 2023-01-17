package persistence;

import model.Content;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkContent(String header, ArrayList topics, ArrayList subtopics, ArrayList dates, Content c) {
        assertEquals(header, c.getHeader());
        assertEquals(topics, c.getListOfTopic());
        assertEquals(subtopics, c.getListOfSubTopics());
        assertEquals(dates, c.getListOfDates());
    }
}

