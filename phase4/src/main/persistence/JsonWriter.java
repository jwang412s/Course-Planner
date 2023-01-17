package persistence;

import org.json.JSONObject;
import java.io.*;
import model.ContentList;

// Represents a writer that writes JSON representation of ContentList to file
//TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of ContentList to file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public void write(ContentList cl) {
        JSONObject json = cl.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    //TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    private void saveToFile(String json) {
        writer.print(json);
    }
}
