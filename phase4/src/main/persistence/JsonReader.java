package persistence;

import model.Content;
import model.ContentList;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

//TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

//// Represents a reader that reads a ContentList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public JsonReader(String source) {

        this.source = source;
    }

    // EFFECTS: reads contentList from file and returns it;
    // throws IOException if an error occurs reading data from file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public ContentList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCourses(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses contentList from JSON object and returns it
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private ContentList parseCourses(JSONObject jsonObject) {
        ContentList cl = new ContentList();
        addCourses(cl, jsonObject);
        return cl;
    }

    // MODIFIES: cl
    // EFFECTS: parses thingies from JSON object and adds them to contentList
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void addCourses(ContentList cl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("contents");
        for (Object json : jsonArray) {
            JSONObject nextCourse = (JSONObject) json;
            addCourse(cl, nextCourse);
        }
    }

    // MODIFIES: cl
    // EFFECTS: parses thingy from JSON object and adds it to contentList
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void addCourse(ContentList cl, JSONObject jsonObject) {
        ArrayList<String> theseTopics = new ArrayList<>();
        ArrayList<String> theseSubTopics = new ArrayList<>();
        ArrayList<String> theseDates = new ArrayList<>();
        String thisHeader = jsonObject.getString("header");

        JSONArray topics = jsonObject.getJSONArray("topics");
        for (Object topic : topics) {
            String t = topic.toString();
            theseTopics.add(t);
        }

        JSONArray subtopics = jsonObject.getJSONArray("subtopics");
        for (Object subTopic : subtopics) {
            String s = subTopic.toString();
            theseSubTopics.add(s);
        }

        JSONArray dates = jsonObject.getJSONArray("dates");
        for (Object date : dates) {
            String d = date.toString();
            theseDates.add(d);
        }

        Content course = new Content(thisHeader, theseTopics, theseSubTopics, theseDates);
        cl.addContent(course);

    }




}
