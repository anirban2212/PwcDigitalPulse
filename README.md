This project is used to validate the PwC Digital website.

Prerequisites for this project::

JDK(version 11 is preferable)
Maven
IDE(Eclipse,Intellij)
The cucumber plugin should be installed in the project.
TestNG plugin should be installed in the project.
Steps to execute the project:

Take a pull of the codebase from Git Hub.

Build the project to download the maven dependencies for the project.

Execute the TestRunner.java file under src/test/java/runner file to execute the existing feature files. @smoke, @Sanity, and @Regression tags are used in the CucumberRunner.java file.

Check the test-output folder for the spark and html report.

**Note::Last execution report is attached in the test-output folder.
