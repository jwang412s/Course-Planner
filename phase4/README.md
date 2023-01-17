
# My Personal Project

## Boxed ToDo/Schedule Chart 
** Phase 1: Task 2**

 - What will the application do? :
     - The application will resemble a whiteboard split into 6 boxes; two rows of 3.
     Each box will have a header that can be modified, and below the header will be a section
     where the user can type in a topic that will be bulleted. There will also be the
     option to add a sub-bullet to it, so the user can write details about the topic. When the 
     user decides to submit and save this entry, an option to set a calendar date will appear. 
     
 - Who will use it? :
     - this application is primarily for students to use. In each header the student can
     input the title of their course, and below they can create their todo list for that course, as well
     as reminders for sections they need to review and basic course details they might tend to forget.
     It can also be used by anyone who wants to have an organized view of what they need to do in a given 
     week. They can name headers like "cooking", "shopping", "house work", "work out" and keep track
     of the things going on in their lives.
 
 - Why is this project of interest to you?
    - This project is of interest to me because I essentially have a physical version of this application.
    In my room I have a white board sectioned off into squares, one for each course/lab that I have as well 
    as a miscellaneous box for other small details of my life. When I was thinking about what project 
    to do, I thought that I would like to make a program that I would still use after I have finished this
    course. I looked around my room and thought that it would be a good investment of my time to turn
    my whiteboard into a program, and remove the need to keep such a large object leaning against my wall.
    
## User Stories
**Phase 1: Task 3**
 - As a user, I would like to view and access all 6 boxes in the collection
 - As a user, I would like to be able to modify the name of the header of a box
 - As a user, I would like to add a topic, and add its corresponding subtopic and date
 - As a user, i would like to be able to add multiple topics and sub-topics and dates in a box
 - As a user, I would like to view the list of topics, sub-topics, and dates in a box
 - As a user, I would like to modify a box that I have created by deleting the first topic, 
   subtopic, and date in the box.
 - As a user, I would like to modify a box that I have created by adding additional topic, subtopic, and date
 - As a user, I would like to be able to delete a box from the total list of boxes. 
 - As a user, I would like to be able to do all the above with all 6 boxes. 
 - for phase 1, instead of constructing boxes each box will be considered a course, and I will realize 
 the boxes when GUI is allowed to be implemented.
 
 **Phase 1: Task 2**
 - As a user, I want to be able to save my to-do list to file
 - As a user, I want to be able to be able to load my to-do list from file 
 
 **Phase 4: Task 2**
 - option 1: one method that throws a checked exception
 can be found in ContentList class, and getLastContent() method. tested testExceptions calss in test file model package
 
 **Phase 4: Task 3**
 - If I had more time to work on this project, I would change my point of control and create another class
 in the model package to instantiate the 6 courses and initialize the creation of each course in courseList.
 - If I had more time I would like to go back and attempt to make my original design of 2 subclasses for BoxesDisplay,
 where I would have a class for boxes, and a class for menu actions. 
 - If I had more time to work I would like to refactor redundant code; fix abstractions to create a method 
 that works for all redundant code, and pass in relevant information for each different course. 
 - If I had more time I think I would also like to create an abstract class for menu, and have several 
 class extending the menu class, each one for a different tab. 