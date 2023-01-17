package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Usable;

import java.util.ArrayList;

//represents one Content that contains a header, topics, subtopics, and dates
public class Content implements Usable {
    private String header;

    //private String topic;
    //private String subTopic;
    private ArrayList<String> listOfDates;
    private ArrayList<String> listOfTopics;
    private ArrayList<String> listOfSubTopics;

    public Content(String header, ArrayList listOfTopics, ArrayList listOfSubTopics, ArrayList listOfDates) {
        this.header = header;
        this.listOfTopics = listOfTopics;
        this.listOfSubTopics = listOfSubTopics;
        this.listOfDates = listOfDates;

        //this.header = "";
        //this.listOfTopics = new ArrayList<>();
        //this.listOfSubTopics = new ArrayList<>();
        //this.listOfDates = new ArrayList<>();
    }

    //Getters

    //EFFECTS: get header
    public String getHeader() {
        return header;
    }

    //EFFECTS: get list of topic
    public ArrayList getListOfTopic() {
        return listOfTopics;
    }

    //EFFECTS: get list of subtopics
    public ArrayList getListOfSubTopics() {
        return listOfSubTopics;
    }

    //EFFECTS: get list of dates
    public ArrayList getListOfDates() {
        return listOfDates;
    }

    //EFFECTS: get first topic from list of topics
    public String getTopic() {
        return listOfTopics.get(0);
    }

    //EFFECTS: get first subtopic from list of sub topics
    public String getSubTopic() {
        return listOfSubTopics.get(0);
    }

    //EFFECTS: get first date from list of dates
    public String getDate() {
        return listOfDates.get(0);
    }


    //MODIFIES: this
    //EFFECTS: changes the header title to a different string.
    public void modifyHeader(String h) {
        if (h != "Header") {
            header = h;
        }

    }

    //REQUIRES: header not be left as header
    //MODIFIES: this
    //EFFECTS: adds a topic to the list of topics
    public void addTopic(String t) {
        listOfTopics.add(t);
    }

    //REQUIRES: list of topic to not be empty
    //MODIFIES: this
    //EFFECTS: adds a subtopic to the list of subtopics
    public void addSubtopic(String s) {
        listOfSubTopics.add(s);
    }

    //REQUIRES: list of subtopic to not be empty
    //MODIFIES: this
    //EFFECTS: replaces empty string with the date
    public void addDate(String d) {
        listOfDates.add(d);

    }

    //REQUIRES: header to have already been modified
    //MODIFIES: this
    //EFFECTS: changes the header back to "Header"
    public void undoModifyHeader() {
        header = "Header";
    }

    //REQUIRES: list of topic not be empty
    //MODIFIES: this
    //EFFECTS: removes Topic from the list of Topics and shifts all the topics in the list
    //one place up
    public void deleteTopic(String t) {
        listOfTopics.remove(t);
    }

    //REQUIRES: list of subtopic to not be empty
    //MODIFIES: this
    //EFFECTS: removes subtopic from the list of subtopics
    public void deleteSubtopic(String s) {
        listOfSubTopics.remove(s);
    }

    //REQUIRES: date not be blank
    //MODIFIES: this
    //EFFECTS: changes the date back to empty string
    public void deleteDate(String d) {
        listOfDates.remove(d);
    }

    //@Override
   // public JSONObject toJson() {
    //    JSONObject json = new JSONObject();

    //    json.put("header", header);
   //     json.put("topics", listOfTopics);
   //     json.put("subtopics", listOfSubTopics);
    //    json.put("dates", listOfDates);
    //    return json;
    //}

    @Override
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("header", getHeader());
        json.put("topics", listOfTopicsToJson());
        json.put("subtopics", listOfSubTopicsToJson());
        json.put("dates", listOfDatesToJson());
        return json;
    }

    // EFFECTS: returns things in this listOfTopics as a JSON array
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private JSONArray listOfTopicsToJson() {

        JSONArray jsonArray = new JSONArray();
        for (String t : listOfTopics) {
            jsonArray.put(t);
        }

        return jsonArray;
    }

    // EFFECTS: returns things in this listOfSubTopics as a JSON array
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private JSONArray listOfSubTopicsToJson() {

        JSONArray jsonArray = new JSONArray();
        for (String s : listOfSubTopics) {
            jsonArray.put(s);
        }

        return jsonArray;
    }

    // EFFECTS: returns things in this listOfDates as a JSON array
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private JSONArray listOfDatesToJson() {

        JSONArray jsonArray = new JSONArray();
        for (String d : listOfDates) {
            jsonArray.put(d);
        }

        return jsonArray;
    }


}




