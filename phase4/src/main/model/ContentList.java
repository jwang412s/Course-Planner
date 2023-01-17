package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Usable;


import java.util.ArrayList;

//represents a list of contents
public class ContentList implements Usable {
    ArrayList<Content> contentList;






    // Construct a toDoList
    // EFFECTS: creates a list of content
    public ContentList() {
        //super();
        contentList = new ArrayList<>();



    }
    //maybe initialize courses1-6 here

    //MODIFIES: this
    //EFFECTS: adds a content to list of content
    public void addContent(Content content) {

        contentList.add(content);
    }

    //MODIFIES: this
    //EFFECTS: deletes content from list of content
    public void deleteContent(Content c) {
        if (contentList.contains(c)) {
            contentList.remove(c);
        }
    }




    //EFFECTS: retrieves content at index i of list of contex
    public Content getContent(int i) {
        return contentList.get(i);
    }
/*
    //EFFECTS: retrieves content at index last of list of contex
    public Content getLastContent() {
        if (contentList.size() > 0) {
            return contentList.get(contentList.size() - 1);
        } else {
            return contentList.get(0);
        }

    }

 */

    //EFFECTS: retrieves content at index last of list of context and catches SizeException
    public Content getLastContent() {
        Content c;
        try {
            c = obtainLastContent();
        } catch (ArrayIndexOutOfBoundsException e) {
            c = null;
        }
        return c;
    }

    //EFFECTS: obtains the latest content in ContentList and throws a SizeException
    public Content obtainLastContent() throws ArrayIndexOutOfBoundsException {
        return contentList.get(contentList.size() - 1);
    }


    //EFFECTS: returns the integer size value of the length of the list of content
    public int getContentlistNumContents() {
        return contentList.size();
    }

    //EFFECTS: returns true if content list contains the specified content, false otherwise.
    public boolean contains(Content c) {
        return contentList.contains(c);
    }


    @Override
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("contents", contentsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private JSONArray contentsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Content t : contentList) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

}
