package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestContent {
    private Content content;

    @BeforeEach
    public void setup() {
        content = new Content("Header", new ArrayList(), new ArrayList(),  new ArrayList());

    }

    @Test
    public void testChangeHeader(){
        content.modifyHeader("CPSC 210");
        content.getHeader();
        assertTrue(content.getHeader() == "CPSC 210");
    }

    @Test
    public void testRemoveHeader(){
        content.undoModifyHeader();
        content.getHeader();
        assertTrue(content.getHeader() == "Header");
    }

    @Test
    public void testAddTopicNoSubTopicOrDate() {
        content.modifyHeader("CPSC 210");
        content.addTopic("Midterm 1");
        ArrayList topics = content.getListOfTopic();
        ArrayList subTopics = content.getListOfSubTopics();
        ArrayList dates = content.getListOfDates();

        assertTrue(content.getHeader() == "CPSC 210");
        assertTrue(topics.contains("Midterm 1"));
        assertEquals(subTopics, new ArrayList<>());
        assertEquals(dates, new ArrayList<>());

    }

    @Test
    public void testDeleteTopic() {
        content.modifyHeader("CPSC 210");
        content.addTopic("Midterm 1");
        content.deleteTopic("Midterm 1");
        ArrayList topics = content.getListOfTopic();
        ArrayList subTopics = content.getListOfSubTopics();
        ArrayList dates = content.getListOfDates();

        assertTrue(content.getHeader() == "CPSC 210");
        assertFalse(topics.contains("Midterm 1"));
        assertEquals(subTopics, new ArrayList<>());
        assertEquals(dates, new ArrayList<>());

    }

    @Test
    public void testAddTopicAndSubTopicNoDate() {
        content.modifyHeader("CPSC 210");
        content.addTopic("Midterm 1");
        content.addSubtopic("Study Abstraction 1-7");
        ArrayList topics = content.getListOfTopic();
        ArrayList subTopics = content.getListOfSubTopics();
        ArrayList dates = content.getListOfDates();

        assertTrue(content.getHeader() == "CPSC 210");
        assertTrue(topics.contains("Midterm 1"));
        assertTrue(subTopics.contains("Study Abstraction 1-7"));
        assertEquals(dates, new ArrayList<>());

    }

    @Test
    public void testDeleteSubTopic() {
        content.modifyHeader("CPSC 210");
        content.addTopic("Midterm 1");
        content.addSubtopic("Study Abstraction 1-7");
        content.deleteSubtopic("Study Abstraction 1-7");
        ArrayList topics = content.getListOfTopic();
        ArrayList subTopics = content.getListOfSubTopics();
        ArrayList dates = content.getListOfDates();

        assertTrue(content.getHeader() == "CPSC 210");
        assertTrue(topics.contains("Midterm 1"));
        assertFalse(subTopics.contains("Study Abstraction 1-7"));
        assertEquals(dates, new ArrayList<>());

    }

    @Test
    public void testAddTopicAndSubTopicAndDate() {
        content.modifyHeader("CPSC 210");
        content.addTopic("Midterm 1");
        content.addSubtopic("Study Abstraction 1-7");
        content.addDate("February 24");
        ArrayList topics = content.getListOfTopic();
        ArrayList subTopics = content.getListOfSubTopics();
        ArrayList dates = content.getListOfDates();

        assertTrue(content.getHeader() == "CPSC 210");
        assertTrue(topics.contains("Midterm 1"));
        assertTrue(subTopics.contains("Study Abstraction 1-7"));
        assertTrue(dates.contains( "February 24"));

    }

    @Test
    public void testGetTopicGetSubTopicGetDate() {
        content.modifyHeader("CPSC 210");
        content.addTopic("Midterm 1");
        content.addSubtopic("Study Abstraction 1-7");
        content.addDate("February 24");
        ArrayList topics = content.getListOfTopic();
        ArrayList subTopics = content.getListOfSubTopics();
        ArrayList dates = content.getListOfDates();

        assertTrue(content.getTopic() == "Midterm 1");
        assertTrue(content.getSubTopic() == "Study Abstraction 1-7");
        assertTrue(content.getDate() == "February 24");
    }


    @Test
    public void testDeleteDate() {
        content.modifyHeader("CPSC 210");
        content.addTopic("Midterm 1");
        content.addSubtopic("Study Abstraction 1-7");
        content.addDate("February 24");
        content.deleteDate("February 24");
        ArrayList topics = content.getListOfTopic();
        ArrayList subTopics = content.getListOfSubTopics();
        ArrayList dates = content.getListOfDates();

        assertTrue(content.getHeader() == "CPSC 210");
        assertTrue(topics.contains("Midterm 1"));
        assertTrue(subTopics.contains("Study Abstraction 1-7"));
        assertFalse(dates.contains( "February 24"));

    }

    @Test
    public void testAddMultipleTopicAndSubTopicAndDate() {
        content.modifyHeader("CPSC 210");
        content.addTopic("Midterm 1");
        content.addTopic("Project Phase 1");
        content.addSubtopic("Study Abstraction 1-7");
        content.addSubtopic("add model, tests, UI");
        content.addDate("February 24");
        content.addDate("February 15");
        ArrayList topics = content.getListOfTopic();
        ArrayList subTopics = content.getListOfSubTopics();
        ArrayList dates = content.getListOfDates();

        Object topic1 = topics.get(0);
        String topic1String = topic1.toString();
        Object topic2 = topics.get(1);
        String topic2String = topic2.toString();

        Object subTopic1 = subTopics.get(0);
        String subTopic1String = subTopic1.toString();
        Object subTopic2 = subTopics.get(1);
        String subTopic2String = subTopic2.toString();

        Object date1 = dates.get(0);
        String date1String = date1.toString();
        Object date2 = dates.get(1);
        String date2String = date2.toString();

        assertTrue(content.getHeader() == "CPSC 210");
        assertTrue(topic1String == "Midterm 1");
        assertTrue(topic2String == "Project Phase 1");
        assertTrue(subTopic1String == "Study Abstraction 1-7");
        assertTrue(subTopic2String == "add model, tests, UI");
        assertTrue(date1String == "February 24");
        assertTrue(date2String == "February 15");

    }



}
