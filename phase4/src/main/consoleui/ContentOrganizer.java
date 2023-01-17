package consoleui;

import model.Content;
import model.ContentList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;



public class ContentOrganizer {
    private Content course1;
    private Content course2;
    private Content course3;
    private Content course4;
    private Content course5;
    private Content course6;
    private ContentList courses;
    private Scanner input;

    private static final String JSON_STORE = "./data/ContentOrganizer.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;




    //EFFECTS: runs the runContentOrganizer application
    public ContentOrganizer() throws FileNotFoundException {
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runContentOrganizer();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runContentOrganizer() {
        boolean keepGoing = true;
        String command = null;

        init();
        while (keepGoing) {
            displayMenu1();
            command = input.nextLine();


            if (command.equals("5")) {
                keepGoing = false;
            } else {
                functionalityForMenu(command);
            }
        }

    }

    private void functionalityForMenu(String command) {
        if (command.equals("1")) {
            if (courses.getContentlistNumContents() != 6) {
                doContent();
                addNewContentInstruction1(command);
            } else {
                System.out.println("sorry, full.");
                //displayMenu1();
            }
        } else if (command.equals("2")) {
            modifyMenu1(command);
        } else if (command.equals("3")) {
            deleteMenu(command);
        } else if (command.equals("4")) {
            view();
        } else if (command.equals("6")) {
            saveCourses();
        } else if (command.equals("7")) {
            loadCourses();
        }
    }

    //EFFECTS: initializes the ContentOrganizer
    private void init() {
        course1 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course2 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course3 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course4 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course5 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course6 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        courses = new ContentList();
        input = new Scanner(System.in);


    }


    //EFFECTS: displays menu of options to user
    private void displayMenu1() {
        System.out.println("\nChoose Option:");
        System.out.println("\t1 -> Add New Course");
        System.out.println("\t2 -> Modify Course");
        System.out.println("\t3 -> Delete Course");
        System.out.println("\t4 -> view");
        System.out.println("\t5 -> Exit");
        System.out.println("\t6 -> save");
        System.out.println("\t7 -> load");
    }


    //MODIFIES: this
    //EFFECTS: adds the new header to the new course and brings to next instruction2
    private void addNewContentInstruction1(String command) {
        System.out.println("\nEnter Below Header");

        doNewHeader();
        Content thisC = courses.getContent(courses.getContentlistNumContents() - 1);
        if (thisC.getHeader() != "Header") {
            addNewContentInstruction2(command);
        }

    }

    //MODIFIES: this
    //EFFECTS: adds new topic to the new course and brings to next instruction3
    private void addNewContentInstruction2(String command) {
        System.out.println("\nEnter Below Topic");

        doNewTopic();
        Content thisC = courses.getContent(courses.getContentlistNumContents() - 1);
        if (thisC.getHeader() != "Header") {
            addNewContentInstruction3(command);
        }
    }


    //MODIFIES: this
    //EFFECTS: adds new subtopic to the new course and brings to next instruction4
    private void addNewContentInstruction3(String command) {
        System.out.println("\nEnter Below SubTopic");

        doNewSubTopic();
        Content thisC = courses.getContent(courses.getContentlistNumContents() - 1);
        if (thisC.getHeader() != "Header") {
            addNewContentInstruction4(command);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds new date to the new course and brings to special menu
    private void addNewContentInstruction4(String command) {
        System.out.println("\nEnter Below Date");

        doNewDate();
        Content thisC = courses.getContent(courses.getContentlistNumContents() - 1);
        if (thisC.getHeader() != "Header") {
            specialMenu(command);
        }
    }


    //MODIFIES: this
    //EFFECTS: adds new topic to the new course and brings to next instruction3
    private void modifyAddContentInstruction2(String command, Content c) {
        System.out.println("\nEnter Below Topic");

        modifyAddTopic(c);
        Content thisC = c;
        if (thisC.getHeader() != "Header") {
            modifyAddContentInstruction3(command, c);
        }
    }

    //MODIFIES: this
    //EFFECTS: creates a new topic in the content
    private void modifyAddTopic(Content c) {
        Content thisC = c;
        thisC.addTopic(input.nextLine());
    }


    //MODIFIES: this
    //EFFECTS: adds new subtopic to the new course and brings to next instruction4
    private void modifyAddContentInstruction3(String command, Content c) {
        System.out.println("\nEnter Below SubTopic");

        modifyAddSubTopic(c);
        Content thisC = c;
        if (thisC.getHeader() != "Header") {
            modifyAddContentInstruction4(command, c);
        }
    }

    //MODIFIES: this
    //EFFECTS: creates a new subtopic for topic
    private void modifyAddSubTopic(Content c) {
        Content thisC = c;
        thisC.addSubtopic(input.nextLine());
    }

    //MODIFIES: this
    //EFFECTS: adds new date to the new course and brings to special menu
    private void modifyAddContentInstruction4(String command, Content c) {
        System.out.println("\nEnter Below Date");

        modifyAddDate(c);
        Content thisC = c;
        if (thisC.getHeader() != "Header") {
            specialMenu(command);
        }
    }

    //MODIFIES: this
    //EFFECTS: creates a date for the topic
    private void modifyAddDate(Content c) {
        Content thisC = c;
        thisC.addDate(input.nextLine());
    }





    //MODIFIES: this
    //EFFECTS: gives options to perform and directs user to the next menu with instructions
    private void specialMenu(String command) {
        //System.out.println("\nChoose Option:");
        menuOfSpecialMenu();
        command = input.nextLine();
        if (command.equals("0")) {
            addNewContentInstruction2(command);
        } else if (command.equals("1")) {
            if (courses.getContentlistNumContents() < 6) {
                doContent();
                addNewContentInstruction1(command);
            } else {
                System.out.println("sorry, full.");
            }
        } else if (command.equals("2")) {
            modifyMenu1(command);
        } else if (command.equals("3")) {
            deleteMenu(command);
        } else if (command.equals("4")) {
            view();
        } else if (command.equals("6")) {
            saveCourses();
        } else if (command.equals("7")) {
            loadCourses();
        }
    }

    private void menuOfSpecialMenu() {
        System.out.println("\t0 -> Add Another Topic?");
        System.out.println("\t1 -> Add New Course");
        System.out.println("\t2 -> Modify Course");
        System.out.println("\t3 -> Delete Course");
        System.out.println("\t4 -> view");
        System.out.println("\t5 -> Exit");
        System.out.println("\t6 -> save");
        System.out.println("\t7 -> load");
    }

    //EFFECTS: displays menu for modification and leads to processMenu1
    private void modifyMenu1(String command) {
        System.out.println("\nenter a course to modify, enter anything else to exit");
        System.out.println("\tcourse1");
        System.out.println("\tcourse2");
        System.out.println("\tcourse3");
        System.out.println("\tcourse4");
        System.out.println("\tcourse5");
        System.out.println("\tcourse6");

        processMenu1();
    }

    //EFFECTS: checks that a valid course is selected and directs to its intended menu
    private void processMenu1() {
        String command = input.nextLine();
        if (command.equals("course1") & courses.contains(course1)) {
            modifyCourse1Menu();
        } else if (command.equals("course2") & courses.contains(course2)) {
            modifyCourse2Menu();
        } else if (command.equals("course3") & courses.contains(course3)) {
            modifyCourse3Menu();
        } else if (command.equals("course4") & courses.contains(course4)) {
            modifyCourse4Menu();
        } else if (command.equals("course5") & courses.contains(course5)) {
            modifyCourse5Menu();
        } else if (command.equals("course6") & courses.contains(course6)) {
            modifyCourse6Menu();
        }

    }

    //MODIFIES: this
    //EFFECTS: deletes the first topic, subtopic, date from course1
    private void modifyCourse1Menu() {
        System.out.println("\nadd additional topic, type 'add'");
        System.out.println("\ndelete first topic, type 'delete' ");
        String command = input.nextLine();


        if (command.equals("add")) {
            modifyAddContentInstruction2(command, course1);
        } else if (command.equals("delete")) {
            Object topic = course1.getListOfTopic().get(0);
            String t = topic.toString();

            Object subtopic = course1.getListOfSubTopics().get(0);
            String s = subtopic.toString();

            Object date = course1.getListOfDates().get(0);
            String d = date.toString();

            course1.deleteTopic(t);
            course1.deleteSubtopic(s);
            course1.deleteDate(d);
        }
    }

    //MODIFIES: this
    //EFFECTS: deletes the first topic, subtopic, date from course2
    private void modifyCourse2Menu() {
        System.out.println("\nadd additional topic, type 'add'");
        System.out.println("\ndelete first topic, type 'delete' ");
        String command = input.nextLine();

        if (command.equals("add")) {
            modifyAddContentInstruction2(command, course2);
        } else if (command.equals("delete")) {
            Object topic = course2.getListOfTopic().get(0);
            String t = topic.toString();

            Object subtopic = course2.getListOfSubTopics().get(0);
            String s = subtopic.toString();

            Object date = course2.getListOfDates().get(0);
            String d = date.toString();

            course2.deleteTopic(t);
            course2.deleteSubtopic(s);
            course2.deleteDate(d);
        }
    }


    //MODIFIES: this
    //EFFECTS: deletes the first topic, subtopic, date from course3
    private void modifyCourse3Menu() {
        System.out.println("\nadd additional topic, type 'add'");
        System.out.println("\ndelete first topic, type 'delete' ");
        String command = input.nextLine();

        if (command.equals("add")) {
            modifyAddContentInstruction2(command, course3);
        } else if (command.equals("delete")) {
            Object topic = course3.getListOfTopic().get(0);
            String t = topic.toString();

            Object subtopic = course3.getListOfSubTopics().get(0);
            String s = subtopic.toString();

            Object date = course3.getListOfDates().get(0);
            String d = date.toString();

            course3.deleteTopic(t);
            course3.deleteSubtopic(s);
            course3.deleteDate(d);
        }
    }

    //MODIFIES: this
    //EFFECTS: deletes the first topic, subtopic, date from course4
    private void modifyCourse4Menu() {
        System.out.println("\nadd additional topic, type 'add'");
        System.out.println("\ndelete first topic, type 'delete' ");
        String command = input.nextLine();

        if (command.equals("add")) {
            modifyAddContentInstruction2(command, course4);
        } else if (command.equals("delete")) {
            Object topic = course4.getListOfTopic().get(0);
            String t = topic.toString();

            Object subtopic = course4.getListOfSubTopics().get(0);
            String s = subtopic.toString();

            Object date = course4.getListOfDates().get(0);
            String d = date.toString();

            course4.deleteTopic(t);
            course4.deleteSubtopic(s);
            course4.deleteDate(d);
        }

    }

    //MODIFIES: this
    //EFFECTS: deletes the first topic, subtopic, date from course5
    private void modifyCourse5Menu() {
        System.out.println("\nadd additional topic, type 'add'");
        System.out.println("\ndelete first topic, type 'delete' ");
        String command = input.nextLine();

        if (command.equals("add")) {
            modifyAddContentInstruction2(command, course5);
        } else if (command.equals("delete")) {
            Object topic = course5.getListOfTopic().get(0);
            String t = topic.toString();

            Object subtopic = course5.getListOfSubTopics().get(0);
            String s = subtopic.toString();

            Object date = course5.getListOfDates().get(0);
            String d = date.toString();

            course5.deleteTopic(t);
            course5.deleteSubtopic(s);
            course5.deleteDate(d);
        }
    }

    //MODIFIES: this
    //EFFECTS: deletes the first topic, subtopic, date from course6
    private void modifyCourse6Menu() {
        System.out.println("\nadd additional topic, type 'add'");
        System.out.println("\ndelete first topic, type 'delete' ");
        String command = input.nextLine();

        if (command.equals("add")) {
            modifyAddContentInstruction2(command, course6);
        } else if (command.equals("delete")) {
            Object topic = course6.getListOfTopic().get(0);
            String t = topic.toString();

            Object subtopic = course6.getListOfSubTopics().get(0);
            String s = subtopic.toString();

            Object date = course6.getListOfDates().get(0);
            String d = date.toString();

            course6.deleteTopic(t);
            course6.deleteSubtopic(s);
            course6.deleteDate(d);
        }
    }





    //EFFECTS: adds a content to total contents depending on what's inside courses.
    //priority add courses counting from 1 and increasing
    private ContentList doContent() {
        if (courses.getContentlistNumContents() == 0 | !courses.contains(course1)) {
            course1 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
            courses.addContent(course1);
        } else if (courses.getContentlistNumContents() == 1 | !courses.contains(course2)) {
            course2 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
            courses.addContent(course2);
        } else if (courses.getContentlistNumContents() == 2 | !courses.contains(course3)) {
            course3 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
            courses.addContent(course3);
        } else if (courses.getContentlistNumContents() == 3 | !courses.contains(course4)) {
            course4 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
            courses.addContent(course4);
        } else if (courses.getContentlistNumContents() == 4 | !courses.contains(course5)) {
            course5 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
            courses.addContent(course5);
        } else if (courses.getContentlistNumContents() == 5 | !courses.contains(course6)) {
            course6 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
            courses.addContent(course6);
        } else {
            System.out.println("Cannot add another content ...\n");
        }
        return courses;
    }

    //MODIFIES: this
    //EFFECTS: creates new header for course
    private void doNewHeader() {
        ContentList cl = courses;
        Content c = cl.getContent(courses.getContentlistNumContents() - 1);
        if (c == course1) {
            String h = "course 1 : ";
            c.modifyHeader(h + input.nextLine());
        } else if (c == course2) {
            String h = "course 2 : ";
            c.modifyHeader(h + input.nextLine());
        } else if (c == course3) {
            String h = "course 3 : ";
            c.modifyHeader(h + input.nextLine());
        } else if (c == course4) {
            String h = "course 4 : ";
            c.modifyHeader(h + input.nextLine());
        } else if (c == course5) {
            String h = "course 5 : ";
            c.modifyHeader(h + input.nextLine());
        } else if (c == course6) {
            String h = "course 6 : ";
            c.modifyHeader(h + input.nextLine());
        }

    }

    //MODIFIES: this
    //EFFECTS: creates a new topic in the content
    private void doNewTopic() {
        ContentList cl = courses;
        Content c = cl.getContent(courses.getContentlistNumContents() - 1);
        c.addTopic(input.nextLine());
    }

    //MODIFIES: this
    //EFFECTS: creates a new subtopic for topic
    private void doNewSubTopic() {
        ContentList cl = courses;
        Content c = cl.getContent(courses.getContentlistNumContents() - 1);
        c.addSubtopic(input.nextLine());
    }

    //MODIFIES: this
    //EFFECTS: creates a date for the topic
    private void doNewDate() {
        ContentList cl = courses;
        Content c = cl.getContent(courses.getContentlistNumContents() - 1);
        c.addDate(input.nextLine());
    }

    //MODIFIES: this
    //EFFECTS: displays delete instruction and deletes specified course
    private void deleteMenu(String command) {
        System.out.println("\nenter courseX of course to delete where X is the course number(ex course1):");
        System.out.println("\tenter anything else to exit");

        doDeleteContent();


    }

    //MODIFIES: this
    //EFFECTS: deletes course
    private void doDeleteContent() {
        String command = input.nextLine();
        if (command.equals("course1")) {
            courses.deleteContent(course1);
            doDeleteContentContent1Specifics();
        } else if (command.equals("course2")) {
            courses.deleteContent(course2);
            doDeleteContentContent2Specifics();
        } else if (command.equals("course3")) {
            courses.deleteContent(course3);
            doDeleteContentContent3Specifics();
        } else if (command.equals("course4")) {
            courses.deleteContent(course4);
            doDeleteContentContent4Specifics();
        } else if (command.equals("course5")) {
            courses.deleteContent(course5);
            doDeleteContentContent5Specifics();
        } else if (command.equals("course6")) {
            courses.deleteContent(course6);
            doDeleteContentContent6Specifics();
        }
    }

    private void doDeleteContentContent1Specifics() {
        course1 = new Content("Header", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private void doDeleteContentContent2Specifics() {
        course2 = new Content("Header", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private void doDeleteContentContent3Specifics() {
        course3 = new Content("Header", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private void doDeleteContentContent4Specifics() {
        course4 = new Content("Header", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private void doDeleteContentContent5Specifics() {
        course5 = new Content("Header", new ArrayList(), new ArrayList(), new ArrayList());
    }

    private void doDeleteContentContent6Specifics() {
        course6 = new Content("Header", new ArrayList(), new ArrayList(), new ArrayList());
    }






    //EFFECTS: displays all courses and their corresponding data
    private void view() {
        int i;
        for (i = 1; courses.getContentlistNumContents() - i >= 0; i++) {
            Content c = courses.getContent(i - 1);

            System.out.println(c.getHeader());
            System.out.println(c.getListOfTopic());
            System.out.println(c.getListOfSubTopics());
            System.out.println(c.getListOfDates());
        }
    }

    // EFFECTS: saves the workroom to file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void saveCourses() {
        try {
            jsonWriter.open();
            jsonWriter.write(courses);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void loadCourses() {

        try {
            cleanCourses();
            ContentList jsonList = jsonReader.read();
            if (jsonList.getContentlistNumContents() == 1) {
                loadCourse1(jsonList);
            } else if (jsonList.getContentlistNumContents() == 2) {
                loadCourse2(jsonList);
            } else if (jsonList.getContentlistNumContents() == 3) {
                loadCourse3(jsonList);
            } else if (jsonList.getContentlistNumContents() == 4) {
                loadCourse4(jsonList);
            } else if (jsonList.getContentlistNumContents() == 5) {
                loadCourse5(jsonList);
            } else if (jsonList.getContentlistNumContents() == 6) {
                loadCourse6(jsonList);
            }

            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //MODIFIES : this
    //EFFECTS: clears contents of contentList
    private void cleanCourses() {
        courses.deleteContent(course1);
        courses.deleteContent(course2);
        courses.deleteContent(course3);
        courses.deleteContent(course4);
        courses.deleteContent(course5);
        courses.deleteContent(course6);
    }

    //MODIFIES: this
    //EFFECTS: loads first course from file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void loadCourse1(ContentList jsonList) {
        Content c = jsonList.getContent(0);
        String header = c.getHeader();
        char n = '1';
        char[] chars = header.toCharArray();
        chars[7] = n;
        header = String.valueOf(chars);
        ArrayList topics = c.getListOfTopic();
        ArrayList subtopics = c.getListOfSubTopics();
        ArrayList dates = c.getListOfDates();
        courses = new ContentList();
        course1 = new Content(header, topics, subtopics, dates);
        courses.addContent(course1);

    }

    //MODIFIES: this
    //EFFECTS: loads second course from file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void loadCourse2(ContentList jsonList) {
        loadCourse1(jsonList);
        Content c = jsonList.getContent(1);
        String header = c.getHeader();
        char n = '2';
        char[] chars = header.toCharArray();
        chars[7] = n;
        header = String.valueOf(chars);
        ArrayList topics = c.getListOfTopic();
        ArrayList subtopics = c.getListOfSubTopics();
        ArrayList dates = c.getListOfDates();
        course2 = new Content(header, topics, subtopics, dates);
        courses.addContent(course2);

    }

    //MODIFIES: this
    //EFFECTS: loads third course from file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void loadCourse3(ContentList jsonList) {
        loadCourse2(jsonList);
        Content c = jsonList.getContent(2);
        String header = c.getHeader();
        char n = '3';
        char[] chars = header.toCharArray();
        chars[7] = n;
        header = String.valueOf(chars);
        ArrayList topics = c.getListOfTopic();
        ArrayList subtopics = c.getListOfSubTopics();
        ArrayList dates = c.getListOfDates();
        course3 = new Content(header, topics, subtopics, dates);
        courses.addContent(course3);

    }

    //MODIFIES: this
    //EFFECTS: loads fourth course from file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void loadCourse4(ContentList jsonList) {
        loadCourse3(jsonList);
        Content c = jsonList.getContent(3);
        String header = c.getHeader();
        char n = '4';
        char[] chars = header.toCharArray();
        chars[7] = n;
        header = String.valueOf(chars);
        ArrayList topics = c.getListOfTopic();
        ArrayList subtopics = c.getListOfSubTopics();
        ArrayList dates = c.getListOfDates();
        course4 = new Content(header, topics, subtopics, dates);
        courses.addContent(course4);

    }

    //MODIFIES: this
    //EFFECTS: loads fifth course from file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void loadCourse5(ContentList jsonList) {
        loadCourse4(jsonList);
        Content c = jsonList.getContent(4);
        String header = c.getHeader();
        char n = '5';
        char[] chars = header.toCharArray();
        chars[7] = n;
        header = String.valueOf(chars);
        ArrayList topics = c.getListOfTopic();
        ArrayList subtopics = c.getListOfSubTopics();
        ArrayList dates = c.getListOfDates();
        course5 = new Content(header, topics, subtopics, dates);
        courses.addContent(course5);

    }

    //MODIFIES: this
    //EFFECTS: loads sixth course from file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void loadCourse6(ContentList jsonList) {
        loadCourse5(jsonList);
        Content c = jsonList.getContent(5);
        String header = c.getHeader();
        char n = '6';
        char[] chars = header.toCharArray();
        chars[7] = n;
        header = String.valueOf(chars);
        ArrayList topics = c.getListOfTopic();
        ArrayList subtopics = c.getListOfSubTopics();
        ArrayList dates = c.getListOfDates();
        course6 = new Content(header, topics, subtopics, dates);
        courses.addContent(course6);

    }

}
