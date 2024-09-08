Playwright Maven Test Automation Project

This project is an automated testing framework using Playwright for browser automation, written in Java and managed with Maven.

Prerequisites
Before setting up the project, ensure you have the following tools installed on your machine:

Java Development Kit (JDK): Version 22.0.2 or higher

TestNG: Version 7.8.0 or higher

Apache Maven: Version 3.10.1 or higher

Playwright: Version 1.46.0 or higher

IntelliJ IDEA (or any other Java IDE): Optional but recommended for code editing and running the tests


To verify Java installation:
    java -version

Expected output:
    java version "22.0.2" 2024-XX-XX

To verify Maven installation:
    mvn -version

Expected output:
    Apache Maven 3.10.1

***********************

Setup Instructions

Install Maven dependencies:
    mvn clean install

Install Playwright browsers:
    mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"


***********************

Configure Project
Ensure the config.properties file is set up correctly. This file can be found in:
    src/main/resources/config.properties

***********************

Run Tests

To execute all tests, use the following Maven command:
    mvn clean test

***********************

Reporting

After running tests there is integrated ExtentReport that will generate HTML file report in the following directory:
    /HomeProject/test-output/ExtentReport.html

