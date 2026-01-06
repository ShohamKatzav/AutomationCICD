# Selenium Framework Design

A comprehensive Selenium WebDriver automation framework built with Java, TestNG, and Cucumber BDD. This framework implements the Page Object Model design pattern and includes advanced features like data-driven testing, parallel execution, extent reporting, and retry mechanisms.

## 🚀 Features

- **Page Object Model (POM)** - Clean separation of test logic and page elements
- **Data-Driven Testing** - JSON-based test data management
- **BDD Support** - Cucumber integration with Gherkin syntax
- **Parallel Execution** - Run tests concurrently for faster execution
- **Extent Reports** - Beautiful HTML test reports with screenshots
- **Retry Mechanism** - Automatic retry for flaky tests
- **Multiple Browser Support** - Chrome, Firefox, and Edge
- **Screenshot on Failure** - Automatic screenshot capture when tests fail
- **Maven Profiles** - Different test suite configurations
- **WebDriverManager** - Automatic driver management

## 🛠️ Technologies Used

- **Java 8**
- **Selenium WebDriver 4.34.0**
- **TestNG 7.11.0**
- **Cucumber 7.27.0**
- **Maven 3.x**
- **ExtentReports 5.1.2**
- **Jackson Databind 2.19.2** (JSON parsing)
- **WebDriverManager 6.1.1**

## 📋 Prerequisites

- Java JDK 8 or higher
- Maven 3.6 or higher
- Chrome/Firefox/Edge browser installed

## ⚙️ Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/SeleniumFrameworkDesign.git
cd SeleniumFrameworkDesign
```

2. Install dependencies:
```bash
mvn clean install -DskipTests
```

## 🏃 Running Tests

### Run all tests:
```bash
mvn test
```

### Run specific test suite:
```bash
mvn test -P Regression
mvn test -P Purchase
mvn test -P ErrorValidation
mvn test -P CucumberTests
```

### Run with specific browser:
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge
```

### Run in headless mode:
```bash
mvn test -Dbrowser=chromeheadless
```

### Run specific test class:
```bash
mvn test -Dtest=SubmitOrderTest
```

## 🔧 Configuration

### Browser Configuration
Edit `src/main/java/shohamkatzav/resources/GlobalData.properties`:
```properties
browser=chrome
```

### Test Data
Edit test data in `src/test/java/shohamkatzav/data/PurchaseOrder.json`:
```json
[
  {
    "email": "your-email@gmail.com",
    "password": "YourPassword",
    "product": "PRODUCT NAME"
  }
]
```

## 📊 Test Reports

After test execution, reports are generated in:
- **Extent Reports**: `reports/index.html`
- **Cucumber Reports**: `target/cucumber.html`
- **Screenshots**: `reports/*.png` (on test failure)

Open the HTML files in a browser to view detailed test results.

## 🧪 Test Suites

### Regression Suite (`testng.xml`)
Runs all tests with listeners enabled for reporting.

### Purchase Suite (`Purchase.xml`)
Focuses on purchase-related test cases.

### Error Validation Suite (`ErrorValidation.xml`)
Tests error handling and validation scenarios.

### Cucumber BDD Suite
Run BDD tests with Cucumber and Gherkin scenarios.

## 📝 Writing Tests

### Using Page Object Model:
```java
@Test
public void testExample() {
    ProductCatalog productCatalog = landingPage.loginApplication("email", "password");
    productCatalog.addProductToCart("PRODUCT NAME");
    CartPage cartPage = productCatalog.goToCartPage();
    Assert.assertTrue(cartPage.verifyProductDisplay("PRODUCT NAME"));
}
```

### Using Cucumber BDD:
```gherkin
Feature: Purchase the order from Ecommerce Website
  
  Scenario: Positive Test of Submitting the order
    Given I landed on Ecommerce Page
    And Logged in with username Shoham@gmail.com and password Aa123456!
    When I add product ZARA COAT 3 from Cart
    And Checkout ZARA COAT 3 and submit the order
    Then "Thankyou for the order." message is displayed on ConfirmationPage
```

## 🔄 Continuous Integration

This framework is CI/CD ready. Maven profiles can be used in Jenkins, GitHub Actions, or any CI tool:

```bash
mvn clean test -P Regression
```

## 📧 Contact

Shoham Katzav - shohamkatzav95@gmail.com

Project Link: [https://github.com/ShohamKatzav/AutomationCICD](https://github.com/ShohamKatzav/AutomationCICD)


⭐ Star this repository if you find it helpful!
