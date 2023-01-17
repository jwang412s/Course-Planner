package ui;

import java.io.FileNotFoundException;

public class ContentOrganizerApp {

    BoxesDisplay bx;


    public static void main(String[] args) {
        new ContentOrganizerApp();

    }

    //Constructs the ContentOrganizer app
    public ContentOrganizerApp() {
        try {
            new BoxesDisplay();
        } catch (FileNotFoundException e) {
            System.exit(0);
        }

    }


}
