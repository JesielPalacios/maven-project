INSTRUCTIONS:

Import the Assessment Project as a Maven Project. For example, using Eclipse:
	File -> Import
	-Select "Existing Maven Projects"
	-Select the Assessment project folder and Eclipse should recognize your pom.xml file
	-If the project does not build you may not have the proper JDK configured (use 1.6 or greater. Java 8 is preferred)
		-pom.xml is set for 1.8 Java compatibility. If you do not have this installed, reconfiguring this 
		property for 1.6 or 1.7 may be necessary (lines 9-10)
		
In the Package Explorer window in Eclipse, open the "src/test/java" folder.
	Right click on "com.tech", select "Run As", and select "JUnit Test"
	
In the JUnit window you should see Runs at 6/6, Errors at 3, and Failures at 2
	If you don't see these numbers or were unable to get to this step, there may be a problem in your project setup. 
	Please contact the test administrator before proceeding.

For IntelliJ:
	1. After opening IntelliJ, go to File -> New -> Project From Existing Sources, click on the folder containing everything and hit Open
	2. Import project from external model -> choose Maven -> Next
	3. Check the box that says "Import Maven projects automatically", others should be default -> Keep hitting Next then finish
	4. In the project pane, open src -> test -> java -> com.tech, right click on AssesmentChecker, and hit Run. This should run
	the tests you need to fix!

Your task is to complete the code in the com.tech.solution package in the src/main/java folder so that Errors and Failures are both at 0. You have 90 minutes.

Some notes:
	-Review db.sql and data.sql in the data directory. The first file defines the database structure, the second populates the database with test data.
		-You'll need to review the first file when writing SQL queries to accomplish the PerformanceDataDao solution.
	-There is Javadoc defined for all of the Interfaces. 
		-You can review this by hovering over the methods from your Eclipse IDE or by opening the Interface files directly.
	-The architecture of this setup is based on Spring, but you should not need to write any Spring code to accomplish the task. 
		-Focus on the areas marked TODO. These can be listed in the Eclipse view called "Tasks"
	-You should only need to modify the code in the "com.tech.solution" package. Do not modify the code in any other area.

Good luck!
