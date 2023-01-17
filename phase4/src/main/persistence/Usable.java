package persistence;

import org.json.JSONObject;

//TODO citation: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public interface Usable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
