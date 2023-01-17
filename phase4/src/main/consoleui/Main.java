package consoleui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new ContentOrganizer();
        } catch (FileNotFoundException e) {
            System.out.println("Can't runt application");
        }
    }
}
