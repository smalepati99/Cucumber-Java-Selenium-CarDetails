# Car Valuation - Car Details Check - BDD-Cucumber/Selenium based Test Automation Framework

## Notes:

1. Developed this test automation framework using Selenium, Java & Cucumber
2. The values in the in Output file - "car_output_v1.txt" are moved to feature file (data table)

## TechStack used to develop this framework
1. Java - as a coding language
2. IntelliJ - IDE
3. Selenium WebDriver - Test Automation Tool
4. Cucumber BDD - Behavior-driven development leveraging GHERKIN Syntax
5. Cucumber Datatables
6. POM - Page Object Model
7. OS - MacOS


This framework predominantly is structured in to 2 following core folders:

1. src/main
2. src/test

Other Files and Folders of Significance:

1. Feature File - src/test/resources/AppFeatures/CarValuation.feature
2. StepDefinition File - src/test/java/stepdefinitions/CarValuationPageSteps.java
3. Inputfiles - src/main/Inputfiles
4. Config File (to add additional inputfile references) - src/test/resources/config/config.properties
5. Utilities - src/main/java/com/qa/util
6. Pages - src/main/java/com/pages/CarValuationPage.java
7. Test Runner - src/test/java/testrunners/MyTestRunner.java
8. Hooks - src/test/java/AppHooks/ApplicationHooks.java


**Pre-requisites:**
1. Make sure you have the following plugins in your IDE(IntelliJ for example)
   1. Cucumber for JAVA
   2. Gherkin



