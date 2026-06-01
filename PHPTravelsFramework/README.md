# PHPTravels Selenium BDD Automation Framework

A complete enterprise-grade test automation framework built with:
**Java | Selenium WebDriver 4 | Cucumber BDD | TestNG | Maven | Extent Reports | Apache POI**

---

## Framework Architecture

```
PHPTravelsFramework/
├── pom.xml                              ← Maven dependencies
├── testng.xml                           ← Parallel execution config
└── src/test/
    ├── java/
    │   ├── base/
    │   │   ├── DriverFactory.java       ← Q7: ThreadLocal<WebDriver>
    │   │   └── BasePage.java            ← Q17: Base class for all pages
    │   ├── pages/
    │   │   ├── LoginPage.java           ← Q1: Login module
    │   │   ├── RegistrationPage.java    ← Q2: Registration module
    │   │   ├── HotelSearchPage.java     ← Q3+Q4+Q9: Search & prices
    │   │   └── BookingPage.java         ← Q5: Complete booking
    │   ├── stepdefinitions/
    │   │   ├── LoginSteps.java          ← Q1 step impl
    │   │   ├── RegistrationSteps.java   ← Q2 step impl
    │   │   └── HotelSearchSteps.java    ← Q3+Q4+Q5 step impl
    │   ├── hooks/
    │   │   └── Hooks.java               ← Q11+Q17: Before/After hooks
    │   ├── utilities/
    │   │   ├── ConfigReader.java        ← Q13: config.properties reader
    │   │   ├── WaitUtility.java         ← Q10: Reusable wait methods
    │   │   ├── ExcelUtility.java        ← Q1+Q4: Apache POI Excel
    │   │   ├── ScreenshotUtility.java   ← Q11: Screenshot capture
    │   │   ├── ExceptionHandler.java    ← Q14: Exception handling
    │   │   ├── WebTableUtility.java     ← Q16: Dynamic web table
    │   │   ├── XPathReference.java      ← Q9: Advanced XPath docs
    │   │   ├── DebuggingAnswers.java    ← Q20: Bug fixes explained
    │   │   └── FrameworkDesign.java     ← Q17: Design docs + diagram
    │   ├── runners/
    │   │   ├── TestRunner.java          ← Q6: Parallel runner
    │   │   └── SmokeTestRunner.java     ← Q10: Tags execution
    │   ├── listeners/
    │   │   ├── RetryAnalyzer.java       ← Retry failed tests
    │   │   └── CustomTestListener.java  ← TestNG listener
    │   └── reports/
    │       └── ExtentReportManager.java ← Thread-safe Extent Reports
    └── resources/
        ├── features/
        │   ├── login.feature            ← Q1 feature file
        │   ├── registration.feature     ← Q2 feature file
        │   └── hotel_search.feature     ← Q3+Q4+Q5 feature files
        ├── testdata/
        │   └── TestData.xlsx            ← Excel for DDT
        ├── config/
        │   └── config.properties        ← Browser, URL, paths
        └── extent.properties            ← Extent report config
```

---

## Prerequisites

- Java JDK 11+
- Maven 3.6+
- Chrome / Firefox / Edge browser installed

---

## How to Run

### Run all tests:
```bash
mvn test
```

### Run only Smoke tests:
```bash
mvn test -Dcucumber.filter.tags="@Smoke"
```

### Run only Regression tests:
```bash
mvn test -Dcucumber.filter.tags="@Regression"
```

### Run on Firefox:
```bash
mvn test -Dbrowser=firefox
```
Or change `browser=firefox` in `config.properties`.

### Run on Edge:
```bash
mvn test -Dbrowser=edge
```

---

## Question-to-File Mapping

| Question | File(s) |
|----------|---------|
| Q1 – Login Module | `LoginPage.java`, `LoginSteps.java`, `login.feature` |
| Q2 – Registration | `RegistrationPage.java`, `RegistrationSteps.java`, `registration.feature` |
| Q3 – Hotel Search | `HotelSearchPage.java`, `HotelSearchSteps.java`, `hotel_search.feature` |
| Q4 – Price Validation | `HotelSearchPage.java` (getAllHotelPrices, HashMap, Collections) |
| Q5 – Booking Workflow | `BookingPage.java`, `HotelSearchSteps.java`, `hotel_search.feature` |
| Q6 – Parallel Execution | `TestRunner.java`, `testng.xml` |
| Q7 – Thread Safe Driver | `DriverFactory.java` (ThreadLocal) |
| Q9 – Advanced XPath | `XPathReference.java`, used in all Page classes |
| Q10 – Wait Utility | `WaitUtility.java` |
| Q11 – Screenshot Utility | `ScreenshotUtility.java`, `Hooks.java` |
| Q13 – Cross Browser | `DriverFactory.java`, `config.properties` |
| Q14 – Exception Handling | `ExceptionHandler.java` |
| Q15 – Assertions | `LoginSteps.java`, `HotelSearchSteps.java` |
| Q16 – Web Table | `WebTableUtility.java` |
| Q17 – Framework Design | `FrameworkDesign.java`, `BasePage.java`, `Hooks.java` |
| Q20 – Debugging | `DebuggingAnswers.java` |

---

## Excel Test Data Structure (TestData.xlsx)

**Sheet: LoginData**

| username | password |
|----------|----------|
| user@phptravels.com | demouser |
| invalid@gmail.com | invalid |
| (blank) | demouser |
| user@phptravels.com | (blank) |

---

## Key Design Decisions

### Thread Safety (Q6 + Q7)
- `ThreadLocal<WebDriver>` in `DriverFactory` ensures each parallel thread has its own browser.
- No static WebDriver fields anywhere in the framework.
- `Thread.sleep()` is never used — all waits use `WebDriverWait` with `ExpectedConditions`.

### Exception Handling (Q14)
- `ExceptionHandler.safeClick()` retries on `StaleElementReferenceException`.
- `ElementClickInterceptedException` falls back to JavaScript click.
- `NoSuchElementException` and `TimeoutException` provide clear error messages.
- Generic `retryOnException()` wrapper continues execution on non-critical failures.

### Debugging Answers (Q20)
1. `driver.findElement(By.id("login")).click;` → **Missing `()`** → Fix: `.click()`
2. `Assert.assertEquals(true, false)` → **Wrong arguments / always fails** → Fix: `Assert.assertTrue(condition)`
3. `Scenario Login Validation` → **Missing `Scenario:` keyword** → Fix: `Scenario: Login Validation`
4. `new WebDriverWait(driver, 10)` → **Selenium 3 API** → Fix: `new WebDriverWait(driver, Duration.ofSeconds(10))`
