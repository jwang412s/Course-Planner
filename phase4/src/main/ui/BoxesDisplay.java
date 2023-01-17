package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

//represents a display of boxes that can store the information of a course
public class BoxesDisplay extends JPanel implements ActionListener {

    private Content course1;
    private Content course2;
    private Content course3;
    private Content course4;
    private Content course5;
    private Content course6;
    private ContentList courses;
    //private MenuTab myMenutab;
    private static final String JSON_STORE = "./data/ContentOrganizer.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    JPanel boxes;

    JPanel pane1 = new JPanel();
    DefaultTableModel tableModel1 = new DefaultTableModel();
    JTable table1 = new JTable(tableModel1);

    JPanel pane2 = new JPanel();
    DefaultTableModel tableModel2 = new DefaultTableModel();
    JTable table2 = new JTable(tableModel2);

    JPanel pane3 = new JPanel();
    DefaultTableModel tableModel3 = new DefaultTableModel();
    JTable table3 = new JTable(tableModel3);

    JPanel pane4 = new JPanel();
    DefaultTableModel tableModel4 = new DefaultTableModel();
    JTable table4 = new JTable(tableModel4);

    JPanel pane5 = new JPanel();
    DefaultTableModel tableModel5 = new DefaultTableModel();
    JTable table5 = new JTable(tableModel5);

    JPanel pane6 = new JPanel();
    DefaultTableModel tableModel6 = new DefaultTableModel();
    JTable table6 = new JTable(tableModel6);



    //JTable table1;


    JTextField addHeader;
    JTextField addTopic;
    JTextField addSubtopic;
    JTextField addDate;
    JButton b1;
    JButton b2;
    JLabel jlab;
    JFrame fr;

    JFrame f1;
    JButton c1b1;
    JButton c1b2;

    JFrame f2;
    JButton c2b1;
    JButton c2b2;

    JFrame f3;
    JButton c3b1;
    JButton c3b2;

    JFrame f4;
    JButton c4b1;
    JButton c4b2;

    JFrame f5;
    JButton c5b1;
    JButton c5b2;

    JFrame f6;
    JButton c6b1;
    JButton c6b2;

    //EFFECTS: initializes the courses and list of courses that can be used
    private void init() {

        course1 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course2 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course3 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course4 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course5 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        course6 = new Content("Header",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        courses = new ContentList();



    }

    //TODO: GETTERS:
    public ContentList getCourses() {
        return courses;
    }

    public Content getCourse1() {
        return course1;
    }

    public Content getCourse2() {
        return course2;
    }

    public Content getCourse3() {
        return course3;
    }

    public Content getCourse4() {
        return course4;
    }

    public Content getCourse5() {
        return course5;
    }

    public Content getCourse6() {
        return course6;
    }

    //TODO: SETTERS
    public void setCourses(ContentList c) {
        this.courses = c;
    }

    public void setCourse1(Content c) {
        this.course1 = c;
    }

    public void setCourse2(Content c) {
        this.course2 = c;
    }

    public void setCourse3(Content c) {
        this.course3 = c;
    }

    public void setCourse4(Content c) {
        this.course4 = c;
    }

    public void setCourse5(Content c) {
        this.course5 = c;
    }

    public void setCourse6(Content c) {
        this.course6 = c;
    }


    //EFFECTS: constructs a boxdisplay, and throws a file not found exception
    public BoxesDisplay() throws FileNotFoundException {
        super(new BorderLayout());
        JFrame window = new JFrame("Content Organizer Application");
        menuTab(window);
        window.setSize(1600,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        boxes = new JPanel();
        boxes.add(createBox1());


        boxes.add(createBox2());
        boxes.add(createBox3());
        boxes.add(createBox4());
        boxes.add(createBox5());
        boxes.add(createBox6());

        window.setContentPane(boxes);

        window.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: constructs a menuTab for the window
    public void menuTab(JFrame menu) {
        //JFrame menu = new JFrame("menudemo");
        init();
        menu.setLayout(new FlowLayout());
        menu.setSize(300, 300);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlab = new JLabel();

        JMenuBar jmb = new JMenuBar();

        fileTab(jmb);
        actionTab(jmb);
        addTopicTab(jmb);
        deleteCourseTab(jmb);
        menu.setJMenuBar(jmb);
        menu.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: constructs the drop down menu with a list of courses for the delete Course to bad
    private void deleteCourseTab(JMenuBar jmb) {
        JMenu jmFile = new JMenu("Delete course");
        //JMenuItem jmiOpen = new JMenuItem("open");
        JMenuItem jmiDelCourse1 = new JMenuItem("delete course1");
        JMenuItem jmiDelCourse2 = new JMenuItem("delete course2");
        JMenuItem jmiDelCourse3 = new JMenuItem("delete course3");
        JMenuItem jmiDelCourse4 = new JMenuItem("delete course4");
        JMenuItem jmiDelCourse5 = new JMenuItem("delete course5");
        JMenuItem jmiDelCourse6 = new JMenuItem("delete course6");
        //jmFile.add(jmiOpen);
        jmFile.add(jmiDelCourse1);
        jmFile.add(jmiDelCourse2);
        jmFile.add(jmiDelCourse3);
        jmFile.add(jmiDelCourse4);
        jmFile.add(jmiDelCourse5);
        jmFile.add(jmiDelCourse6);
        jmb.add(jmFile);

        //jmiOpen.addActionListener(this);
        jmiDelCourse1.addActionListener(this);
        jmiDelCourse2.addActionListener(this);
        jmiDelCourse3.addActionListener(this);
        jmiDelCourse4.addActionListener(this);
        jmiDelCourse5.addActionListener(this);
        jmiDelCourse6.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: Constructs the file drop down menu with the options to load, save, view and exit
    private void fileTab(JMenuBar jmb) {
        JMenu jmFile = new JMenu("File");
        //JMenuItem jmiOpen = new JMenuItem("open");
        JMenuItem jmiLoad = new JMenuItem("load");
        JMenuItem jmiSave = new JMenuItem("save");
        JMenuItem jmiView = new JMenuItem("view");
        JMenuItem jmiExit = new JMenuItem("exit");
        //jmFile.add(jmiOpen);
        jmFile.add(jmiLoad);
        jmFile.add(jmiSave);
        jmFile.add(jmiView);
        jmFile.add(jmiExit);
        jmb.add(jmFile);

        //jmiOpen.addActionListener(this);
        jmiLoad.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiView.addActionListener(this);
        jmiExit.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: constructs a tab that has the drop down option to add a new course
    private void actionTab(JMenuBar jmb) {
        JMenu jmFile = new JMenu("Action");

        JMenuItem jmiAddCourse = new JMenuItem("add course");
        jmFile.add(jmiAddCourse);

        jmb.add(jmFile);


        jmiAddCourse.addActionListener(this);

    }

    //MODIFIES: this
    //EFFECTS: constructs a tab that has a drop down menu to add additional topics + subtopics + dates to certain boxes
    private void addTopicTab(JMenuBar jmb) {
        JMenu jmFile = new JMenu("Add Topic to existing courses");
        JMenuItem jmiAddTopicC1 = new JMenuItem("add topic to course1");
        JMenuItem jmiAddTopicC2 = new JMenuItem("add topic to course2");
        JMenuItem jmiAddTopicC3 = new JMenuItem("add topic to course3");
        JMenuItem jmiAddTopicC4 = new JMenuItem("add topic to course4");
        JMenuItem jmiAddTopicC5 = new JMenuItem("add topic to course5");
        JMenuItem jmiAddTopicC6 = new JMenuItem("add topic to course6");
        jmFile.add(jmiAddTopicC1);
        jmFile.add(jmiAddTopicC2);
        jmFile.add(jmiAddTopicC3);
        jmFile.add(jmiAddTopicC4);
        jmFile.add(jmiAddTopicC5);
        jmFile.add(jmiAddTopicC6);
        jmb.add(jmFile);

        //jmiOpen.addActionListener(this);
        jmiAddTopicC1.addActionListener(this);
        jmiAddTopicC2.addActionListener(this);
        jmiAddTopicC3.addActionListener(this);
        jmiAddTopicC4.addActionListener(this);
        jmiAddTopicC5.addActionListener(this);
        jmiAddTopicC6.addActionListener(this);
    }

    //EFFECTS: handles the action events when selected an option from the one of the menus
    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();

        if (ae.getSource() == b1) {
            actionPerformedForAddCourseWindowAdd();
            playSound();
        } else if (ae.getSource() == b2) {
            actionPerformedAddCourseWindowExit();
        }

        if (s.equals("exit")) {
            System.exit(0);
        } else if (s.equals("add course")) {
            addCourseWindow();
            addCourseWindow();
        } else if (s.equals("save")) {
            saveCourses();
        } else if (s.equals("load")) {
            loadCourses();
        } else if (s.equals("view")) {
            viewCourses();
        } else {
            jlab.setText(s + " Selected");
        }

        actionPerformedForAddTopicTab(ae);
        actionPerformedForDeleteCourse(ae);
    }

    //EFFECTS: constructs the popup window for when "add course" option is selected
    public void addCourseWindow() {
        fr = new JFrame();
        //Dimension d = new Dimension(300,400);
        //f.setMinimumSize(d);
        //f.setPreferredSize(d);
        addHeader = new JTextField();
        addHeader.setBounds(50,50,150,20);
        addTopic = new JTextField();
        addTopic.setBounds(50,100,150,20);
        addSubtopic = new JTextField();
        addSubtopic.setBounds(50,150,150,20);
        addDate = new JTextField();
        addDate.setBounds(50,200,150,20);
        b1 = new JButton("add");
        b1.setBounds(75,250,100,50);
        //b1.setBounds(25,250,100,50);
        //b2 = new JButton("cancel");
        //b2.setBounds(145,250,100,50);
        b1.addActionListener(this);
        //b2.addActionListener(this);
        fr.add(addHeader);
        fr.add(addTopic);
        fr.add(addSubtopic);
        fr.add(addDate);
        fr.add(b1);
        //f.add(b2);

        JLabel label = new JLabel("1: header, 2: topic, 3: subtopic, 4: date");
        label.setVerticalAlignment(JLabel.TOP);
        fr.add(label);

        fr.setSize(300,400);
        //f.setLayout(null);

        fr.setVisible(true);

    }

    //MODIFIES: this
    //EFFECTS: when action desired is to add a new course, converts input from text field and stores it as a header,
    //         topic, subtopic, or date. Determines what Course object to add to courses, and then adds the inputs
    //         to the desired course object.
    public void actionPerformedForAddCourseWindowAdd()  {

        String header = addHeader.getText();
        String topic = addTopic.getText();
        String subtopic = addSubtopic.getText();
        String date = addDate.getText();


        determineCourse();

        Content cc = courses.getLastContent();
        cc.modifyHeader(header);
        cc.addTopic(topic);
        cc.addSubtopic(subtopic);
        cc.addDate(date);


        if (courses.getContentlistNumContents() == 1 | tableModel1.getRowCount() == 0) {
            actionPerformedForAddCourseWindowAddC1(cc, topic, subtopic, date, header);


        } else if (courses.getContentlistNumContents() == 2 | tableModel2.getRowCount() == 0) {
            actionPerformedForAddCourseWindowAddC2(cc, topic, subtopic, date, header);

        } else if (courses.getContentlistNumContents() == 3 | tableModel3.getRowCount() == 0) {
            actionPerformedForAddCourseWindowAddC3(cc, topic, subtopic, date, header);

        } else if (courses.getContentlistNumContents() == 4 | tableModel4.getRowCount() == 0) {
            actionPerformedForAddCourseWindowAddC4(cc, topic, subtopic, date, header);

        } else if (courses.getContentlistNumContents() == 5 | tableModel5.getRowCount() == 0) {
            actionPerformedForAddCourseWindowAddC5(cc, topic, subtopic, date, header);

        } else if (courses.getContentlistNumContents() == 6 | tableModel6.getRowCount() == 0) {
            actionPerformedForAddCourseWindowAddC6(cc, topic, subtopic, date, header);

        }
    }

    //MODIFIES: tableModel1, pane1, and course1
    //EFFECTS: updates tableModel1, pane1, and course1 with new data provided by the action of adding a new
    //         course
    public void actionPerformedForAddCourseWindowAddC1(Content cc, String topic, String subtopic,
                                                       String date, String header) {
        setCourse1(cc);
        tableModel1.addRow(new Object[] {topic, subtopic, date});
        pane1.setBorder(BorderFactory.createTitledBorder(header));
    }

    //MODIFIES: tableModel2, pane2, and course2
    //EFFECTS: updates tableModel2, pane2, and course2 with new data provided by the action of adding a new
    //         course
    public void actionPerformedForAddCourseWindowAddC2(Content cc, String topic, String subtopic,
                                                       String date, String header) {
        setCourse2(cc);
        tableModel2.addRow(new Object[] {topic, subtopic, date});
        pane2.setBorder(BorderFactory.createTitledBorder(header));
    }

    //MODIFIES: tableModel3, pane3, and course3
    //EFFECTS: updates tableModel3, pane3, and course3 with new data provided by the action of adding a new
    //         course
    public void actionPerformedForAddCourseWindowAddC3(Content cc, String topic, String subtopic,
                                                       String date, String header) {
        setCourse3(cc);
        tableModel3.addRow(new Object[] {topic, subtopic, date});
        pane3.setBorder(BorderFactory.createTitledBorder(header));
    }

    //MODIFIES: tableModel4, pane5, and course4
    //EFFECTS: updates tableModel4, pane4, and course4 with new data provided by the action of adding a new
    //         course
    public void actionPerformedForAddCourseWindowAddC4(Content cc, String topic, String subtopic,
                                                       String date, String header) {
        setCourse4(cc);
        tableModel4.addRow(new Object[] {topic, subtopic, date});
        pane4.setBorder(BorderFactory.createTitledBorder(header));
    }

    //MODIFIES: tableModel5, pane5, and course5
    //EFFECTS: updates tableModel5, pane5, and course5 with new data provided by the action of adding a new
    //         course
    public void actionPerformedForAddCourseWindowAddC5(Content cc, String topic, String subtopic,
                                                       String date, String header) {
        setCourse5(cc);
        tableModel5.addRow(new Object[] {topic, subtopic, date});
        pane5.setBorder(BorderFactory.createTitledBorder(header));
    }

    //MODIFIES: tableModel6, pane6, and course6
    //EFFECTS: updates tableModel6, pane6, and course6 with new data provided by the action of adding a new
    //         course
    public void actionPerformedForAddCourseWindowAddC6(Content cc, String topic, String subtopic,
                                                       String date, String header) {
        setCourse6(cc);
        tableModel6.addRow(new Object[] {topic, subtopic, date});
        pane6.setBorder(BorderFactory.createTitledBorder(header));
    }


    //EFFECTS: forces add course window to shut down
    public void actionPerformedAddCourseWindowExit() {

        fr.dispose();

    }

    //EFFECTS: determines which course to be added
    public ContentList determineCourse() {
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
            System.exit(0);
            //actionPerformedAddCourseWindowExit();
        }
        return courses;
    }

    //EFFECTS: determines which popup window to appear for which course to add an additional topics to
    public void actionPerformedForAddTopicTab(ActionEvent ae) {
        String s = ae.getActionCommand();

        if (courses.contains(course1) & s == "add topic to course1") {
            addTopicC1Window();
        } else if (courses.contains(course2) & s == "add topic to course2") {
            addTopicC2Window();
        } else if (courses.contains(course3) & s == "add topic to course3") {
            addTopicC3Window();
        } else if (courses.contains(course4) & s == "add topic to course4") {
            addTopicC4Window();
        } else if (courses.contains(course5) & s == "add topic to course5") {
            addTopicC5Window();
        } else if (courses.contains(course6) & s == "add topic to course6") {
            addTopicC6Window();
        } else {
            //
        }

        actionPerformedForAddTopicTabContd1(ae);

        actionPerformedForAddTopicTabContd2(ae);
    }

    //EFFECTS: determines which function to handle adding the information passed into the textfield for
    //         additional topic to be added
    public void actionPerformedForAddTopicTabContd1(ActionEvent ae) {
        if (ae.getSource() == c1b1) {
            actionPerformedForAddTopicTabFunctionalityC1();
        }  else if (ae.getSource() == c2b1) {
            actionPerformedForAddTopicTabFunctionalityC2();
        } else if (ae.getSource() == c3b1) {
            actionPerformedForAddTopicTabFunctionalityC3();
        } else if (ae.getSource() == c4b1) {
            actionPerformedForAddTopicTabFunctionalityC4();
        } else if (ae.getSource() == c5b1) {
            actionPerformedForAddTopicTabFunctionalityC5();
        } else if (ae.getSource() == c6b1) {
            actionPerformedForAddTopicTabFunctionalityC6();
        }

    }

    //EFFECTS: determine which add topic window to dispose
    public void actionPerformedForAddTopicTabContd2(ActionEvent ae) {
        if (ae.getSource() == c1b2) {
            f1.dispose();
        } else if (ae.getSource() == c2b2) {
            f2.dispose();
        } else if (ae.getSource() == c3b2) {
            f3.dispose();
        } else if (ae.getSource() == c4b2) {
            f4.dispose();
        } else if (ae.getSource() == c5b2) {
            f5.dispose();
        } else if (ae.getSource() == c6b2) {
            f6.dispose();
        }
    }

    //EFFECTS: constructs the addtopic window for course1
    public void  addTopicC1Window() {
        f1 = new JFrame();
        //Dimension d = new Dimension(300,400);
        //f1.setMinimumSize(d);
        //f1.setPreferredSize(d);
        addTopic = new JTextField();
        addTopic.setBounds(50,50,150,20);
        addSubtopic = new JTextField();
        addSubtopic.setBounds(50,100,150,20);
        addDate = new JTextField();
        addDate.setBounds(50,150,150,20);
        c1b1 = new JButton("add");
        c1b1.setBounds(25,200,100,50);
        c1b2 = new JButton("cancel");
        c1b2.setBounds(145,200,100,50);
        c1b1.addActionListener(this);
        c1b2.addActionListener(this);
        f1.add(addTopic);
        f1.add(addSubtopic);
        f1.add(addDate);
        f1.add(c1b1);
        f1.add(c1b2);

        JLabel label = new JLabel("1: topic, 2: subtopic, 3: date");
        label.setVerticalAlignment(JLabel.TOP);
        f1.add(label);

        f1.setSize(300,300);
        //f.setLayout(null);

        f1.setVisible(true);

    }

    //MODIFIES: this
    //EFFECTS: functionality to pass information from the add topic textfield into course1
    public void actionPerformedForAddTopicTabFunctionalityC1() {
        String topic = addTopic.getText();
        String subtopic = addSubtopic.getText();
        String date = addDate.getText();


        course1.addTopic(topic);
        course1.addSubtopic(subtopic);
        course1.addDate(date);

        setCourse1(course1);
        tableModel1.addRow(new Object[] {topic, subtopic, date});

    }

    //EFFECTS: constructs the addtopic window for course2
    public void  addTopicC2Window() {
        f2 = new JFrame();
        //Dimension d = new Dimension(300,400);
        //f2.setMinimumSize(d);
        //f2.setPreferredSize(d);
        addTopic = new JTextField();
        addTopic.setBounds(50,50,150,20);
        addSubtopic = new JTextField();
        addSubtopic.setBounds(50,100,150,20);
        addDate = new JTextField();
        addDate.setBounds(50,150,150,20);
        c2b1 = new JButton("add");
        c2b1.setBounds(25,200,100,50);
        c2b2 = new JButton("cancel");
        c2b2.setBounds(145,200,100,50);
        c2b1.addActionListener(this);
        c2b2.addActionListener(this);
        f2.add(addTopic);
        f2.add(addSubtopic);
        f2.add(addDate);
        f2.add(c2b1);
        f2.add(c2b2);

        JLabel label = new JLabel("1: topic, 2: subtopic, 3: date");
        label.setVerticalAlignment(JLabel.TOP);
        f2.add(label);

        f2.setSize(300,300);
        //f.setLayout(null);

        f2.setVisible(true);

    }

    //MODIFIES: this
    //EFFECTS: functionality to pass information from the add topic textfield into course2
    public void actionPerformedForAddTopicTabFunctionalityC2() {
        String topic = addTopic.getText();
        String subtopic = addSubtopic.getText();
        String date = addDate.getText();


        course2.addTopic(topic);
        course2.addSubtopic(subtopic);
        course2.addDate(date);

        setCourse1(course2);
        tableModel2.addRow(new Object[] {topic, subtopic, date});

    }

    //EFFECTS: constructs the addtopic window for course3
    public void  addTopicC3Window() {
        f3 = new JFrame();
        //Dimension d = new Dimension(300,400);
        //f3.setMinimumSize(d);
        //f3.setPreferredSize(d);
        addTopic = new JTextField();
        addTopic.setBounds(50,50,150,20);
        addSubtopic = new JTextField();
        addSubtopic.setBounds(50,100,150,20);
        addDate = new JTextField();
        addDate.setBounds(50,150,150,20);
        c3b1 = new JButton("add");
        c3b1.setBounds(25,200,100,50);
        c3b2 = new JButton("cancel");
        c3b2.setBounds(145,200,100,50);
        c3b1.addActionListener(this);
        c3b2.addActionListener(this);
        f3.add(addTopic);
        f3.add(addSubtopic);
        f3.add(addDate);
        f3.add(c3b1);
        f3.add(c3b2);

        JLabel label = new JLabel("1: topic, 2: subtopic, 3: date");
        label.setVerticalAlignment(JLabel.TOP);
        f3.add(label);

        f3.setSize(300,300);
        //f.setLayout(null);

        f3.setVisible(true);

    }

    //MODIFIES: this
    //EFFECTS: functionality to pass information from the add topic textfield into course3
    public void actionPerformedForAddTopicTabFunctionalityC3() {
        String topic = addTopic.getText();
        String subtopic = addSubtopic.getText();
        String date = addDate.getText();


        course3.addTopic(topic);
        course3.addSubtopic(subtopic);
        course3.addDate(date);

        setCourse1(course3);
        tableModel3.addRow(new Object[] {topic, subtopic, date});

    }

    //EFFECTS: constructs the addtopic window for course4
    public void  addTopicC4Window() {
        f4 = new JFrame();
        //Dimension d = new Dimension(300,400);
        //f4.setMinimumSize(d);
        //f4.setPreferredSize(d);
        addTopic = new JTextField();
        addTopic.setBounds(50,50,150,20);
        addSubtopic = new JTextField();
        addSubtopic.setBounds(50,100,150,20);
        addDate = new JTextField();
        addDate.setBounds(50,150,150,20);
        c4b1 = new JButton("add");
        c4b1.setBounds(25,200,100,50);
        c4b2 = new JButton("cancel");
        c4b2.setBounds(145,200,100,50);
        c4b1.addActionListener(this);
        c4b2.addActionListener(this);
        f4.add(addTopic);
        f4.add(addSubtopic);
        f4.add(addDate);
        f4.add(c4b1);
        f4.add(c4b2);

        JLabel label = new JLabel("1: topic, 2: subtopic, 3: date");
        label.setVerticalAlignment(JLabel.TOP);
        f4.add(label);

        f4.setSize(300,300);
        //f.setLayout(null);

        f4.setVisible(true);

    }

    //MODIFIES: this
    //EFFECTS: functionality to pass information from the add topic textfield into course4
    public void actionPerformedForAddTopicTabFunctionalityC4() {
        String topic = addTopic.getText();
        String subtopic = addSubtopic.getText();
        String date = addDate.getText();


        course4.addTopic(topic);
        course4.addSubtopic(subtopic);
        course4.addDate(date);

        setCourse1(course4);
        tableModel4.addRow(new Object[] {topic, subtopic, date});

    }

    //EFFECTS: constructs the addtopic window for course5
    public void  addTopicC5Window() {
        f5 = new JFrame();
        //Dimension d = new Dimension(300,400);
        //f5.setMinimumSize(d);
        //f5.setPreferredSize(d);
        addTopic = new JTextField();
        addTopic.setBounds(50,50,150,20);
        addSubtopic = new JTextField();
        addSubtopic.setBounds(50,100,150,20);
        addDate = new JTextField();
        addDate.setBounds(50,150,150,20);
        c5b1 = new JButton("add");
        c5b1.setBounds(25,200,100,50);
        c5b2 = new JButton("cancel");
        c5b2.setBounds(145,200,100,50);
        c5b1.addActionListener(this);
        c5b2.addActionListener(this);
        f5.add(addTopic);
        f5.add(addSubtopic);
        f5.add(addDate);
        f5.add(c5b1);
        f5.add(c5b2);

        JLabel label = new JLabel("1: topic, 2: subtopic, 3: date");
        label.setVerticalAlignment(JLabel.TOP);
        f5.add(label);

        f5.setSize(300,300);
        //f.setLayout(null);

        f5.setVisible(true);

    }

    //MODIFIES: this
    //EFFECTS: functionality to pass information from the add topic textfield into course5
    public void actionPerformedForAddTopicTabFunctionalityC5() {
        String topic = addTopic.getText();
        String subtopic = addSubtopic.getText();
        String date = addDate.getText();


        course5.addTopic(topic);
        course5.addSubtopic(subtopic);
        course5.addDate(date);

        setCourse1(course5);
        tableModel5.addRow(new Object[] {topic, subtopic, date});

    }

    //EFFECTS: constructs the addtopic window for course5
    public void  addTopicC6Window() {
        f6 = new JFrame();
        //Dimension d = new Dimension(300,400);
        //f6.setMinimumSize(d);
        //f6.setPreferredSize(d);
        addTopic = new JTextField();
        addTopic.setBounds(50,50,150,20);
        addSubtopic = new JTextField();
        addSubtopic.setBounds(50,100,150,20);
        addDate = new JTextField();
        addDate.setBounds(50,150,150,20);
        c6b1 = new JButton("add");
        c6b1.setBounds(25,200,100,50);
        c6b2 = new JButton("cancel");
        c6b2.setBounds(145,200,100,50);
        c6b1.addActionListener(this);
        c6b2.addActionListener(this);
        f6.add(addTopic);
        f6.add(addSubtopic);
        f6.add(addDate);
        f6.add(c6b1);
        f6.add(c6b2);

        JLabel label = new JLabel("1: topic, 2: subtopic, 3: date");
        label.setVerticalAlignment(JLabel.TOP);
        f6.add(label);

        f6.setSize(300,300);
        //f.setLayout(null);

        f6.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: functionality to pass information from the add topic textfield into course6
    public void actionPerformedForAddTopicTabFunctionalityC6() {
        String topic = addTopic.getText();
        String subtopic = addSubtopic.getText();
        String date = addDate.getText();


        course6.addTopic(topic);
        course6.addSubtopic(subtopic);
        course6.addDate(date);

        setCourse1(course6);
        tableModel6.addRow(new Object[] {topic, subtopic, date});

    }


    //MODIFIES: this
    //EFFECTS: functionality to delete course 1-3
    public void actionPerformedForDeleteCourse(ActionEvent ae) {
        String s = ae.getActionCommand();
        if (s == "delete course1") {
            courses.deleteContent(course1);
            pane1.setBorder(BorderFactory.createTitledBorder("Header"));
            for (int i = 0; tableModel1.getRowCount() > i;) {
                tableModel1.removeRow(i);
            }
        } else if (s == "delete course2") {
            courses.deleteContent(course2);
            pane2.setBorder(BorderFactory.createTitledBorder("Header"));
            for (int i = 0; tableModel2.getRowCount() > i;) {
                tableModel2.removeRow(i);
            }
        } else if (s == "delete course3") {
            courses.deleteContent(course3);
            pane3.setBorder(BorderFactory.createTitledBorder("Header"));
            for (int i = 0; tableModel3.getRowCount() > i;) {
                tableModel3.removeRow(i);
            }
        }
        actionPerformedForDeleteCourseContd(ae);

    }

    //EFFECTS: functionality to delete course 4-6
    public void actionPerformedForDeleteCourseContd(ActionEvent ae) {
        String s = ae.getActionCommand();
        if (s == "delete course4") {
            courses.deleteContent(course4);
            pane4.setBorder(BorderFactory.createTitledBorder("Header"));
            for (int i = 0; tableModel4.getRowCount() > i;) {
                tableModel4.removeRow(i);
            }
        } else if (s == "delete course5") {
            courses.deleteContent(course5);
            pane5.setBorder(BorderFactory.createTitledBorder("Header"));
            for (int i = 0; tableModel5.getRowCount() > i;) {
                tableModel5.removeRow(i);
            }
        } else if (s == "delete course6") {
            courses.deleteContent(course6);
            pane6.setBorder(BorderFactory.createTitledBorder("Header"));
            for (int i = 0; tableModel6.getRowCount() > i;) {
                tableModel6.removeRow(i);
            }
        }
    }



    //EFFECTS: constructs box 1
    protected JPanel createBox1() {
        //JPanel pane1 = new JPanel();

        JComponent component = new JPanel();
        //component.add(makeTable());\
        makeTable1(component);
        Dimension size = new Dimension(500,460);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(
                new LineBorder(Color.black),
                "course1",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);

        String title;

        title = course1.getHeader();



        pane1.setBorder(BorderFactory.createTitledBorder(title));
        pane1.setLayout(new BoxLayout(pane1, BoxLayout.Y_AXIS));
        pane1.add(component);
        return pane1;
    }

    //MODIFIES: this
    //EFFECTS: constructs table for box1
    private JComponent makeTable1(JComponent j) {

        Dimension size = new Dimension(450,450);
        table1.setPreferredSize(size);
        table1.setRowHeight(40);
        noEditing(table1);
        JScrollPane jsp = new JScrollPane(table1);
        table1.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        add(jsp);

        j.add(jsp);

        tableModel1.addColumn("topic");
        tableModel1.addColumn("subtopic");
        tableModel1.addColumn("date");
        return j;
    }

    //EFFECTS: Constructs box 2
    protected JPanel createBox2() {

        //JPanel pane = new JPanel();

        JComponent component = new JPanel();
        //component.add(makeTable());\
        makeTable2(component);
        Dimension size = new Dimension(500,460);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(
                new LineBorder(Color.black),
                "course2",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);

        String title;

        title = course2.getHeader();

        pane2.setBorder(BorderFactory.createTitledBorder(title));
        pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));
        pane2.add(component);
        return pane2;
    }

    //MODIFIES: this
    //EFFECTS: constructs a table for box 2
    private JComponent makeTable2(JComponent j) {

        Dimension size = new Dimension(450,450);
        table2.setPreferredSize(size);
        table2.setRowHeight(40);
        noEditing(table2);
        JScrollPane jsp = new JScrollPane(table2);
        table2.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        add(jsp);

        j.add(jsp);

        tableModel2.addColumn("topic");
        tableModel2.addColumn("subtopic");
        tableModel2.addColumn("date");
        return j;
    }

    //EFFECTS: Constructs box 3
    protected JPanel createBox3() {
        //JPanel pane = new JPanel();

        JComponent component = new JPanel();
        //component.add(makeTable());\
        makeTable3(component);
        Dimension size = new Dimension(500,460);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(
                new LineBorder(Color.black),
                "course3",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);

        String title;

        title = course1.getHeader();

        pane3.setBorder(BorderFactory.createTitledBorder(title));
        pane3.setLayout(new BoxLayout(pane3, BoxLayout.Y_AXIS));
        pane3.add(component);
        return pane3;
    }

    //MODIFIES: this
    //EFFECTS: constructs a table for box 3
    private JComponent makeTable3(JComponent j) {
        Dimension size = new Dimension(450,450);
        table3.setPreferredSize(size);
        table3.setRowHeight(40);
        noEditing(table3);
        JScrollPane jsp = new JScrollPane(table3);
        table3.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        add(jsp);

        j.add(jsp);

        tableModel3.addColumn("topic");
        tableModel3.addColumn("subtopic");
        tableModel3.addColumn("date");
        return j;
    }

    //EFFECTS: Constructs box 4
    protected JPanel createBox4() {
        //JPanel pane = new JPanel();

        JComponent component = new JPanel();
        //component.add(makeTable());\
        makeTable4(component);
        Dimension size = new Dimension(500,460);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(
                new LineBorder(Color.black),
                "course4",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);

        String title;

        title = course4.getHeader();

        pane4.setBorder(BorderFactory.createTitledBorder(title));
        pane4.setLayout(new BoxLayout(pane4, BoxLayout.Y_AXIS));
        pane4.add(component);
        return pane4;
    }

    //MODIFIES: this
    //EFFECTS: Constructs a table for box 4
    private JComponent makeTable4(JComponent j) {
        Dimension size = new Dimension(450,450);
        table4.setPreferredSize(size);
        table4.setRowHeight(40);
        noEditing(table4);
        JScrollPane jsp = new JScrollPane(table4);
        table4.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        add(jsp);

        j.add(jsp);

        tableModel4.addColumn("topic");
        tableModel4.addColumn("subtopic");
        tableModel4.addColumn("date");
        return j;
    }

    //EFFECTS: Constructs box 5
    protected JPanel createBox5() {
        //JPanel pane = new JPanel();

        JComponent component = new JPanel();
        //component.add(makeTable());\
        makeTable5(component);
        Dimension size = new Dimension(500,460);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(
                new LineBorder(Color.black),
                "course5",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);

        String title;

        title = course5.getHeader();

        pane5.setBorder(BorderFactory.createTitledBorder(title));
        pane5.setLayout(new BoxLayout(pane5, BoxLayout.Y_AXIS));
        pane5.add(component);
        return pane5;
    }

    //MODIFIES: this
    //EFFECTS: Constructs a table for box 5
    private JComponent makeTable5(JComponent j) {
        Dimension size = new Dimension(450,450);
        table5.setPreferredSize(size);
        table5.setRowHeight(40);
        noEditing(table5);
        JScrollPane jsp = new JScrollPane(table5);
        table5.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        add(jsp);

        j.add(jsp);

        tableModel5.addColumn("topic");
        tableModel5.addColumn("subtopic");
        tableModel5.addColumn("date");
        return j;
    }

    //EFFECTS: constructs box 6
    protected JPanel createBox6() {
        //JPanel pane = new JPanel();

        JComponent component = new JPanel();
        //component.add(makeTable());\
        makeTable6(component);
        Dimension size = new Dimension(500,460);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(
                new LineBorder(Color.black),
                "course6",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);

        String title;

        title = course6.getHeader();

        pane6.setBorder(BorderFactory.createTitledBorder(title));
        pane6.setLayout(new BoxLayout(pane6, BoxLayout.Y_AXIS));
        pane6.add(component);
        return pane6;
    }

    //MODIFIES: this
    //EFFECTS: constructs a table for box 6
    private JComponent makeTable6(JComponent j) {
        Dimension size = new Dimension(450,450);
        table6.setPreferredSize(size);
        table6.setRowHeight(40);
        noEditing(table6);
        JScrollPane jsp = new JScrollPane(table6);
        table6.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        add(jsp);

        j.add(jsp);

        tableModel6.addColumn("topic");
        tableModel6.addColumn("subtopic");
        tableModel6.addColumn("date");
        return j;
    }

    // EFFECTS: saves the workroom to file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void saveCourses() {
        try {
            jsonWriter.open();
            jsonWriter.write(courses);
            jsonWriter.close();

        } catch (FileNotFoundException e) {
            //
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


        } catch (IOException e) {
            System.exit(0);
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
        ArrayList topics = c.getListOfTopic();
        ArrayList subtopics = c.getListOfSubTopics();
        ArrayList dates = c.getListOfDates();
        course6 = new Content(header, topics, subtopics, dates);
        courses.addContent(course6);

    }

    //EFFECTS: reloads table data
    public void viewCourses() {

        for (int i = 1; courses.getContentlistNumContents() - i >= 0; i++) {
            Content c = courses.getContent(i - 1);

            String topic;
            String subtopic;
            String date;

            String header = c.getHeader();
            ArrayList topics = c.getListOfTopic();
            ArrayList subtopics = c.getListOfSubTopics();
            ArrayList dates = c.getListOfDates();
            Object[][] data = new Object[topics.size()][3];

            // init 2d array (aka table data)
            for (int o = 0; data.length > o; o++) {
                String topicStr = topics.get(o).toString();
                String subtopicStr = subtopics.get(o).toString();
                String dateStr = dates.get(o).toString();
                data[o] = new Object[]{ topicStr, subtopicStr, dateStr};
            }

            doViewCourseChecker(c, data, header);

        }
    }

    //EFFECTS: determines which Course to view
    public void doViewCourseChecker(Content c, Object[][] data, String header) {
        if (c == course1) {
            setCourse1(c);
            doViewCourseFurther1(data, header);
            //tableModel1 = new DefaultTableModel(data, new Object[] {"topic", "subtopic", "date"});
            //table1.setModel(tableModel1);
            //pane1.setBorder(BorderFactory.createTitledBorder(header));

        } else if (c == course2) {
            setCourse2(c);
            doViewCourseFurther2(data, header);


        } else if (c == course3) {
            setCourse3(c);
            doViewCourseFurther3(data, header);


        } else if (c == course4) {
            setCourse4(c);
            doViewCourseFurther4(data, header);


        } else if (c == course5) {
            setCourse5(c);
            doViewCourseFurther5(data, header);
            pane5.setBorder(BorderFactory.createTitledBorder(header));

        } else if (c == course6) {
            setCourse6(c);
            doViewCourseFurther6(data, header);


        }
    }

    //MODIFIES: this
    //EFFECTS: updates table with new data
    public void doViewCourseFurther1(Object[][] data, String header) {
        tableModel1 = new DefaultTableModel(data, new Object[] {"topic", "subtopic", "date"});
        table1.setModel(tableModel1);
        pane1.setBorder(BorderFactory.createTitledBorder(header));

    }

    //MODIFIES: this
    //EFFECTS: updates table with new data
    public void doViewCourseFurther2(Object[][] data, String header) {
        tableModel2 = new DefaultTableModel(data, new Object[] {"topic", "subtopic", "date"});
        table2.setModel(tableModel2);
        pane2.setBorder(BorderFactory.createTitledBorder(header));

    }

    //MODIFIES: this
    //EFFECTS: updates table with new data
    public void doViewCourseFurther3(Object[][] data, String header) {
        tableModel3 = new DefaultTableModel(data, new Object[] {"topic", "subtopic", "date"});
        table3.setModel(tableModel3);
        pane3.setBorder(BorderFactory.createTitledBorder(header));

    }

    //MODIFIES: this
    //EFFECTS: updates table with new data
    public void doViewCourseFurther4(Object[][] data, String header) {
        tableModel4 = new DefaultTableModel(data, new Object[] {"topic", "subtopic", "date"});
        table4.setModel(tableModel4);
        pane4.setBorder(BorderFactory.createTitledBorder(header));

    }

    //MODIFIES: this
    //EFFECTS: updates table with new data
    public void doViewCourseFurther5(Object[][] data, String header) {
        tableModel5 = new DefaultTableModel(data, new Object[] {"topic", "subtopic", "date"});
        table5.setModel(tableModel5);
        pane5.setBorder(BorderFactory.createTitledBorder(header));

    }

    //MODIFIES: this
    //EFFECTS: updates table with new data
    public void doViewCourseFurther6(Object[][] data, String header) {
        tableModel6 = new DefaultTableModel(data, new Object[] {"topic", "subtopic", "date"});
        table6.setModel(tableModel6);
        pane6.setBorder(BorderFactory.createTitledBorder(header));

    }


    //EFFECTS: play a chime sound
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File("./src/main/ui/chime.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    //EFFECTS: makes a table not editable
    public void noEditing(JTable table) {
        table.setEnabled(false);
    }


}
