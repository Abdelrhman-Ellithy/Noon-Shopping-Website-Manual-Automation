Here’s a README file for your **Ellithium-Demo-Project**, incorporating the provided class information and project structure:

---

# Ellithium-Demo-Project

Demo project using the **Ellithium Framework** for running both BDD and Non-BDD tests with Selenium WebDriver and Cucumber.

## Project Overview

This project demonstrates how to use the **Ellithium Framework** to implement UI tests with a focus on search functionality. The project is designed to showcase key features such as:
- Running tests in **BDD Mode** using Cucumber.
- Writing and executing test scenarios using a Page Object Model (POM) design pattern.
- Utilizing utility classes provided by Ellithium for common Selenium actions like assertions, navigating pages, and interacting with web elements.

### Key Features:
- **Search Feature Tests**: Automated tests for various search-related scenarios, including filtering, sorting, and validation of results.
- **Configurable Setup**: Choose between BDD and Non-BDD modes in the config file to switch between testing styles.
- **Utilities**: Provided utilities like `DriverActions` and `AssertionExecutor` simplify writing efficient, maintainable tests.

## Project Structure

```text
Ellithium-Demo-Project
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Pages
│   │   │   │   └── SearchPage.java
│   │   ├── resources
│   │   │   ├── features
│   │   │   │   └── Search.feature
│   │   │   ├── properties
│   │   │   │   ├── default
│   │   │   │   │   └── allure.properties
│   │   │   │   │   └── config.properties
│   │   │   │   │   └── log4j2.properties
│   ├── test
│   │   ├── java
│   │   │   ├── APITests
│   │   │   │   └── MyEndPointTests.java
│   │   │   ├── Base
│   │   │   │   └── BaseStepDefinitions.java
│   │   │   ├── Runner
│   │   │   │   └── TestRunner.java
│   │   │   ├── stepDefinitions
│   │   │   │   └── SearchStepDefinitions.java
│   │   ├── resources
│   │   │   ├── TestData
├── Test-Output
│   ├── Logs
│   │   └── Test.log
│   ├── Reports
│   │   ├── Allure
│   │   │   ├── allure-report
│   │   │   │   └── Ellithium-Test-Report-2024-09-28-10-55-48AM.html
│   │   │   ├── allure-results

│   │   ├── Cucumber
│   │   │   └── cucumber.html
│   │   │   └── cucumber.json
│   ├── ScreenShots
│   │   ├── Failed
│   │   │   └── CHROME-Verify that user can search with partially product name-2024-09-28-1-40-02PM.png
│   │   │   └── CHROME-Verify that user can search with partially product name-2024-09-28-10-55-45AM.png
├── .idea
│   └── compiler.xml
│   └── encodings.xml
│   └── jarRepositories.xml
│   └── misc.xml
│   └── vcs.xml
│   └── workspace.xml
└── TestNGRunner.xml
└── pom.xml
└── README.md
```

## Configuration

In the `config.properties` file, you can specify whether the tests should run in **BDD Mode** (Cucumber) or **Non-BDD Mode**. The appropriate setup class must be extended depending on the mode:

- **BDD Mode**:
  ```properties
  runMode=BDD
  ```
  Extend from `BDDSetup` in your runner class.

- **Non-BDD Mode**:
  ```properties
  runMode=NonBDD
  ```
  Extend from `NonBDDSetup` in your runner class.

## Key Classes

### 1. `BaseStepDefinitions.java` (Base Package)
Handles the initialization of the WebDriver through the `DriverFactory` provided by the Ellithium framework.

### 2. `TestRunner.java` (Runner Package)
Defines the Cucumber options for running feature files. This class is responsible for running tests in **BDD Mode** by extending `BDDSetup`.

### 3. `SearchStepDefinitions.java` (stepDefinitions Package)
Contains the Cucumber step definitions for the search feature. Uses `AssertionExecutor` for test assertions and `SearchPage` for page-specific actions.

### 4. `SearchPage.java` (Pages Package)
Handles all interactions with the search page using helper methods from the `DriverActions` utility class.

## Example Feature File (BDD Mode)

```gherkin
Feature: Search

  Background:
    Given The user is on the homepage

  Scenario: User Search query is Accepted
    When they type a search query into the search bar
    Then the search query should be accepted and processed

  Scenario: Only Relevant Items Returned in the Results
    Given The user has entered a search query
    When they click the Search button or press Enter key
    Then the search results page should display items matching the search query

  @Run
  Scenario: Verify user can search with partially typed product name
    Given the user enters product name partially in the search field
    When they click the Search button or press Enter key
    Then products relevant to that name should be displayed
```

## Test Results and Reports

- **Screenshots of failed tests**: Saved in `Test-Output/ScreenShots/Failed`.
- **Log files**: Generated in `Test-Output/Logs/Test.log`.
- **Allure Reports**: Generated in `Test-Output/Reports/Allure/allure-report`.

## Running Tests

- Ensure all required dependencies are set up in `pom.xml`.
- To run the tests in **BDD Mode**, simply execute the `TestRunner` class located in the `Runner` package.
  
For reports, Allure can be used to visualize test results:
```bash
allure serve Test-Output/Reports/Allure/allure-report
```

---

This README file provides a clear structure, guiding the user through the purpose and setup of the demo project with Ellithium. Let me know if you need further customization!