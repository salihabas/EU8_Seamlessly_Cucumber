# cydeo-library-app

!!! You shouldn't any change existing files.

You will create new feature files for your task
   - As a precondition (You can copy it from contacts.feature file)
   
   Background: Pre_condition User is on dashboard page with valid credential
    Given user is on the login page
    And user enters "Employee12" as a username
    And user enters "Employee123" as a password
    And user clicks login button
    And user can logged in
    
    (You can change username and password to yours)
    
    
You will create YourModulePage.java file under pages package(POM structure). You should extend BasePage.
Normally we define it as an object inside your module_stepdefinition.java.
                
                YourModulePage yourModulePage = new YourModulePage();
                
 You can call some methods and WebElements thanks to this object from BasePage.java  
      
     (e.g.)    yourModulePage.getModuleElement("Files").click(); (You should use "Dashboard", "Files", "Photos",
                                                                  "Activity", "Contacts", "Notes", "Deck", "Tasks" as a parameter)

      The other WebElement what you'll able to use : 
               yourModulePage.setStatusLink
               yourModulePage.settingsLink
               
 
 You should obey some rules to avoid Github conflict 
 
 1) You shouldn't any change existing files. (If you need, let me know firstly)
 2) You should create new branch. (you can name it as "yourmodule_name" e.g. contacts_salih)
 3) You mustn't push to Master.
 4) You mustn't any merge on GitHub. I will do it. 
 5) You should commit and push just only your files (yourModule.feature, yourModulePage.java, step_definitions.java)
     Maybe you can be changing inside cukesrunner (tags, dryrun.. ) 
 6) Before push your code, You should update your local master branch. 
     After that you should merge your updated local master to --> your local feature branch
     If there is any conflict you should solve it on your local firstly.
 7) Let me know after your push. I will be waiting your message.
     
 

    
    
    
