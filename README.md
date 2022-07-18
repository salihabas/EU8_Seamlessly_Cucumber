# EU8_Seamlessly_Cucumber-app

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

     (e.g.)    yourModulePage.getModuleElement("Files").click(); 
     (You should use your module name such as "Dashboard", "Files", "Photos","Activity", "Contacts", "Notes", "Deck", "Tasks" as a parameter)

      The other WebElement what you'll able to use : 
               yourModulePage.setStatusLink
               yourModulePage.settingsLink


***You should obey some rules to avoid Github conflict

1) Don't change existing files. (If you need, let me know firstly)
2) Create new branch. (you can name it as "US-JIRA ID_FeatureName" e.g. SYMU-678_Tasks)
3) Don't push to Master. (We already added a rule to protect our remote master branch)
4) Before push your code, update your local master branch.(**IMPORTANT**)
   After that you should merge your updated local master to --> your local feature branch
   If there is any conflict, solve it on your local firstly.
5) You should commit and push just only your files (yourModule.feature, yourModulePage.java, step_definitions.java)
   Maybe you can be changing inside cukesrunner (tags, dryrun.. )
6) Create pull request and assign your review mate as a reviewer on Github
7) Your review mate will merge your branch to remote project on GitHub after review process is done.
8) Let me know after your push and merge when you have any merge-conflict

     
 

    
    
    
