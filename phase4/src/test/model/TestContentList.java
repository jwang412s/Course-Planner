package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestContentList {
    private ContentList contentList;
    private Content Content1;
    private Content Content2;
    private ArrayList<String> listOfTopics1;  //ADDED
    private ArrayList<String> listOfSubTopics1;
    private ArrayList<String> listOfDates1;
    private ArrayList<String> listOfTopics2;  //ADDED
    private ArrayList<String> listOfSubTopics2;
    private ArrayList<String> listOfDates2;
    private String header;


    @BeforeEach
    public void setup() {
        listOfTopics1 = new ArrayList<>();  //ADDED
        listOfSubTopics1 = new ArrayList<>();
        listOfDates1 = new ArrayList<>();
        listOfTopics2 = new ArrayList<>();  //ADDED
        listOfSubTopics2 = new ArrayList<>();
        listOfDates2 = new ArrayList<>();
        header = "Header";

        Content1 = new Content(header, listOfTopics1, listOfSubTopics1, listOfDates1);
        Content2 = new Content(header, listOfTopics2, listOfSubTopics2, listOfDates2);


        contentList = new ContentList();
        //Content1 = new Content("Header", listOfTopics, new ArrayList(),  new ArrayList());
                                                 //^ADDED
    }

    @Test
    public void testNoContent() {

        assertEquals(0, contentList.getContentlistNumContents());  //compare 0 with contentlist.size
    }

    @Test
    public void testOneContentOnlyHeader() {
        //contentList.addContent("CPSC 210", null, null, new ArrayList<>());
        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");
        Content1.getHeader();
        assertTrue(Content1.getHeader() == "CPSC 210");
        assertEquals(new ArrayList<>(), Content1.getListOfTopic());
        assertEquals(new ArrayList<>(), Content1.getListOfSubTopics());
        assertEquals(Content1.getListOfDates(), new ArrayList<>());
    }

    @Test
    public void testContainsContent() {
        contentList.addContent(Content1);
        assertTrue(contentList.contains(Content1));
    }

    @Test
    public void testOneContentOnlyRemoveHeader() {
        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");
        Content1.undoModifyHeader();
        Content1.getHeader();
        assertTrue(Content1.getHeader() == "Header");
        assertEquals(new ArrayList<>(), Content1.getListOfTopic());
        assertEquals(new ArrayList<>(), Content1.getListOfSubTopics());
        assertEquals(Content1.getListOfDates(), new ArrayList<>());
    }

    @Test
    public void testOneContentAddTopic() {
        listOfTopics1.add("Midterm 1");               //ADDED AND CHANGED myList to listOfTopics below
        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");


        ArrayList topic = Content1.getListOfTopic();
        Object thisTopic = topic.get(0);
        String theTopic = thisTopic.toString();

        assertTrue(Content1.getHeader() == "CPSC 210");
        assertEquals(theTopic, "Midterm 1");  //useequals method
        assertEquals(new ArrayList<>(), Content1.getListOfSubTopics());
        assertEquals(Content1.getListOfDates(), new ArrayList<>());
    }

    @Test
    public void testOneContentAddOneSubTopic() {
        listOfTopics1.add("Midterm 1");
        listOfSubTopics1.add("Abstraction 1-7");
        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");


        ArrayList topic = Content1.getListOfTopic();
        Object thisTopic = topic.get(0);
        String theTopic = thisTopic.toString();

        ArrayList subTopic = Content1.getListOfSubTopics();
        Object thisSubTopic = subTopic.get(0);
        String theSubTopic = thisSubTopic.toString();

        assertTrue(Content1.getHeader() == "CPSC 210");
        assertEquals(theTopic, "Midterm 1");
        assertEquals(theSubTopic, "Abstraction 1-7");
        assertEquals(Content1.getListOfDates(), new ArrayList<>());
    }

    @Test
    public void testOneContentAddDate() {
        listOfTopics1.add("Midterm 1");
        listOfSubTopics1.add("Abstraction 1-7");
        listOfDates1.add("February 24");

        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");



        ArrayList topic = Content1.getListOfTopic();
        Object thisTopic = topic.get(0);
        String theTopic = thisTopic.toString();

        ArrayList subTopic = Content1.getListOfSubTopics();
        Object thisSubTopic = subTopic.get(0);
        String theSubTopic = thisSubTopic.toString();

        ArrayList date = Content1.getListOfDates();
        Object thisDate = date.get(0);
        String theDate = thisDate.toString();

        assertTrue(Content1.getHeader() == "CPSC 210");
        assertEquals(theTopic, "Midterm 1");
        assertEquals(theSubTopic,"Abstraction 1-7");
        assertEquals(theDate, "February 24");

    }

    @Test
    public void testAddMultipleTopicsAndSubTopics() {
        listOfTopics1.add("Midterm 1");
        listOfTopics1.add("Project Phase 1");
        listOfSubTopics1.add("Abstraction 1-7");
        listOfSubTopics1.add("add models, tests, and UI");
        listOfDates1.add("February 24");
        listOfDates1.add("February 15");
        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");



        ArrayList topic = Content1.getListOfTopic();
        Object thisTopic = topic.get(0);
        String theTopic = thisTopic.toString();
        Object thisTopic2 = topic.get(1);
        String theTopic2 = thisTopic2.toString();


        ArrayList subTopic = Content1.getListOfSubTopics();
        Object thisSubTopic = subTopic.get(0);
        String theSubTopic = thisSubTopic.toString();
        Object thisSubTopic2 = subTopic.get(1);
        String theSubTopic2 = thisSubTopic2.toString();

        ArrayList date = Content1.getListOfDates();
        Object thisDate = date.get(0);
        String theDate = thisDate.toString();
        Object thisDate2 = date.get(1);
        String theDate2 = thisDate2.toString();

        assertTrue(Content1.getHeader() == "CPSC 210");
        assertEquals(theTopic, "Midterm 1");
        assertEquals(theTopic2, "Project Phase 1");
        assertEquals(theSubTopic, "Abstraction 1-7");
        assertEquals(theSubTopic2, "add models, tests, and UI");
        assertEquals(theDate, "February 24");
        assertEquals(theDate2, "February 15");
    }

    @Test
    public void testRemoveContentFromMiddleOfContentList() {

        listOfTopics1.add("Midterm 1");
        listOfTopics1.add("Project Phase 1");
        listOfTopics1.add("Prairie Learn Assessment");
        listOfSubTopics1.add("Abstraction 1-7");
        listOfSubTopics1.add("add models, tests, and UI");
        listOfSubTopics1.add("Abstraction 7");
        listOfDates1.add("February 24");
        listOfDates1.add("February 15");
        listOfDates1.add("February 9");
        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");

        //contentList.addContent("CPSC 210", myList, myList2, myList3);
        //Content1 = Content.get(1);
        Content1.deleteTopic("Project Phase 1");
        Content1.deleteSubtopic("add models, tests, and UI");
        Content1.deleteDate("February 15");



        ArrayList topic = Content1.getListOfTopic();
        Object thisTopic = topic.get(0);
        String theTopic = thisTopic.toString();
        Object thisTopic2 = topic.get(1);
        String theTopic2 = thisTopic2.toString();


        ArrayList subTopic = Content1.getListOfSubTopics();
        Object thisSubTopic = subTopic.get(0);
        String theSubTopic = thisSubTopic.toString();
        Object thisSubTopic2 = subTopic.get(1);
        String theSubTopic2 = thisSubTopic2.toString();

        ArrayList date = Content1.getListOfDates();
        Object thisDate = date.get(0);
        String theDate = thisDate.toString();
        Object thisDate2 = date.get(1);
        String theDate2 = thisDate2.toString();

        assertTrue(Content1.getHeader() == "CPSC 210");
        assertEquals(theTopic, "Midterm 1");
        assertEquals(theTopic2, "Prairie Learn Assessment");
        assertEquals(theSubTopic, "Abstraction 1-7");
        assertEquals(theSubTopic2, "Abstraction 7");
        assertEquals(theDate, "February 24");
        assertEquals(theDate2, "February 9");
    }

    @Test
    public void testAddMultipleContentAndMultipleTopicsAndSubTopics() {
        listOfTopics1.add("Midterm 1");
        listOfTopics1.add("Project Phase 1");
        listOfSubTopics1.add("Abstraction 1-7");
        listOfSubTopics1.add("add models, tests, and UI");
        listOfDates1.add("February 24");
        listOfDates1.add("February 15");
        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");

        listOfTopics2.add("Assignment 1");
        listOfTopics2.add("Discussion Post Week 5");
        listOfSubTopics2.add("Phonology, Morphology");
        listOfSubTopics2.add("Syntax");
        listOfDates2.add("February 5");
        listOfDates2.add("February 12");
        contentList.addContent(Content2);
        Content2 = contentList.getContent(1);
        Content2.modifyHeader("LING 100");


        //Extracting info for cpsc 210
        ArrayList topic = Content1.getListOfTopic();
        Object thisTopic = topic.get(0);
        String theTopic = thisTopic.toString();
        Object thisTopic2 = topic.get(1);
        String theTopic2 = thisTopic2.toString();


        ArrayList subTopic = Content1.getListOfSubTopics();
        Object thisSubTopic = subTopic.get(0);
        String theSubTopic = thisSubTopic.toString();
        Object thisSubTopic2 = subTopic.get(1);
        String theSubTopic2 = thisSubTopic2.toString();

        ArrayList date = Content1.getListOfDates();
        Object thisDate = date.get(0);
        String theDate = thisDate.toString();
        Object thisDate2 = date.get(1);
        String theDate2 = thisDate2.toString();




        //Extracting info for ling 100
        ArrayList topicL = Content2.getListOfTopic();
        Object thisTopicL = topicL.get(0);
        String theTopicL = thisTopicL.toString();
        Object thisTopic2L = topicL.get(1);
        String theTopic2L = thisTopic2L.toString();


        ArrayList subTopicL = Content2.getListOfSubTopics();
        Object thisSubTopicL = subTopicL.get(0);
        String theSubTopicL = thisSubTopicL.toString();
        Object thisSubTopic2L = subTopicL.get(1);
        String theSubTopic2L = thisSubTopic2L.toString();

        ArrayList dateL = Content2.getListOfDates();
        Object thisDateL = dateL.get(0);
        String theDateL = thisDateL.toString();
        Object thisDate2L = dateL.get(1);
        String theDate2L = thisDate2L.toString();


        assertTrue(Content1.getHeader() == "CPSC 210");
        assertEquals(theTopic, "Midterm 1");
        assertEquals(theTopic2, "Project Phase 1");
        assertEquals(theSubTopic, "Abstraction 1-7");
        assertEquals(theSubTopic2, "add models, tests, and UI");
        assertEquals(theDate, "February 24");
        assertEquals(theDate2, "February 15");

        assertTrue(Content2.getHeader() == "LING 100");
        assertEquals(theTopicL, "Assignment 1");
        assertEquals(theTopic2L, "Discussion Post Week 5");
        assertEquals(theSubTopicL, "Phonology, Morphology");
        assertEquals(theSubTopic2L, "Syntax");
        assertEquals(theDateL, "February 5");
        assertEquals(theDate2L, "February 12");
    }

    @Test
    public void testDeleteContentFromMultipleContentAndMultipleTopicsAndSubTopics() {
        listOfTopics1.add("Midterm 1");
        listOfTopics1.add("Project Phase 1");
        listOfSubTopics1.add("Abstraction 1-7");
        listOfSubTopics1.add("add models, tests, and UI");
        listOfDates1.add("February 24");
        listOfDates1.add("February 15");
        contentList.addContent(Content1);
        Content1 = contentList.getContent(0);
        Content1.modifyHeader("CPSC 210");

        listOfTopics2.add("Assignment 1");
        listOfTopics2.add("Discussion Post Week 5");
        listOfSubTopics2.add("Phonology, Morphology");
        listOfSubTopics2.add("Syntax");
        listOfDates2.add("February 5");
        listOfDates2.add("February 12");
        contentList.addContent(Content2);
        Content2 = contentList.getContent(1);
        Content2.modifyHeader("LING 100");

        contentList.deleteContent(Content1);

        //Extracting info for first in list now LING 100
        ArrayList topic = Content2.getListOfTopic();
        Object thisTopic = topic.get(0);
        String theTopic = thisTopic.toString();
        Object thisTopic2 = topic.get(1);
        String theTopic2 = thisTopic2.toString();


        ArrayList subTopic = Content2.getListOfSubTopics();
        Object thisSubTopic = subTopic.get(0);
        String theSubTopic = thisSubTopic.toString();
        Object thisSubTopic2 = subTopic.get(1);
        String theSubTopic2 = thisSubTopic2.toString();

        ArrayList date = Content2.getListOfDates();
        Object thisDate = date.get(0);
        String theDate = thisDate.toString();
        Object thisDate2 = date.get(1);
        String theDate2 = thisDate2.toString();



        assertEquals(1, contentList.getContentlistNumContents());
        assertTrue(Content2.getHeader() == "LING 100");
        assertEquals(theTopic, "Assignment 1");
        assertEquals(theTopic2, "Discussion Post Week 5");
        assertEquals(theSubTopic, "Phonology, Morphology");
        assertEquals(theSubTopic2, "Syntax");
        assertEquals(theDate, "February 5");
        assertEquals(theDate2, "February 12");
    }

    @Test
    void testGetLastOfList() {
        contentList.addContent(Content1);
        contentList.addContent(Content2);
        assertTrue(contentList.getLastContent() == Content2);
    }




}
