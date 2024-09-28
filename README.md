# Noon-Shopping-Website-Manual-Automation

Demo project using the **Ellithium Framework** for running both BDD and Non-BDD tests with Selenium WebDriver and Cucumber.

## Project Overview

This project demonstrates how to use the **Ellithium Framework** to implement UI tests with a focus on search functionality. The project automates the **Search Feature** and is designed to showcase key features such as:
- Running tests in **BDD Mode** using Cucumber.
- Writing and executing test scenarios using a Page Object Model (POM) design pattern.
- Utilizing utility classes provided by Ellithium for common Selenium actions like assertions, navigating pages, and interacting with web elements.

### Key Features:
- **Search Feature Tests**: Automated tests for various search-related scenarios, including filtering, sorting, and validation of results.
- **Configurable Setup**: Choose between BDD and Non-BDD modes in the config file to switch between testing styles.
- **Utilities**: Provided utilities like `DriverActions` and `AssertionExecutor` simplify writing efficient, maintainable tests.
- **Manual Testing**: There are up to 68 manual test cases covering the **Search** and **Checkout** features.

## Project Structure

```text
Noon-Shopping-Website-Manual-Automation
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
│   │   │   │   └── Ellithium-Test-Report-2024-09-28-5-42-44PM.html
│   │   │   ├── allure-results
│   │   ├── Cucumber
│   │   │   └── cucumber.html
│   │   │   └── cucumber.json
│   ├── ScreenShots
│   │   ├── Failed
│   │   │   └── CHROME-Verify that user can search with partially product name-2024-09-28-5-42-37PM.png
├── .idea
│   └── compiler.xml
│   └── encodings.xml
│   └── jarRepositories.xml
│   └── misc.xml
│   └── uiDesigner.xml
│   └── vcs.xml
│   └── workspace.xml
└── TestNGRunner.xml
└── pom.xml
└── Manual-Test-Cases-.xlsx
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

  Scenario: Verify Search result updated according to the applied filter
    Given The search results are displayed
    When the user applies filters (e.g., brand)
    Then the search results should be filtered accordingly

  Scenario: Verify Search result updated according to the applied sorting method
    Given The search results are displayed
    When the user chooses to sort the results (e.g., price)
    Then the search results should be sorted accordingly

  Scenario: Verify that the "No Results Found" message is displayed when there are no matching items
    Given The user enters a search query
    When no items match the search query
    Then a "No Results Found" message should be displayed

  Scenario: Verify that user can search with product Company name
    Given the user enters Company name in the search field
    When they click the Search button or press Enter key
    Then company products should be displayed

  Scenario: Verify that user can search with partially typed product name
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
  
For reports, you can open:
```ext
├── Test-Output
│   ├── Reports
│   │   ├── Allure
```

---