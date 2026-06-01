package utilities;

/**
 * ============================================================
 * Question 17 – Framework Design Challenge
 * ============================================================
 *
 * WHY POM (Page Object Model)?
 * ─────────────────────────────
 * - Separates test logic from UI interaction logic.
 * - Each web page has one corresponding Java class.
 * - Locators are centralized: change in one place when UI changes.
 * - Improves code reusability – the same page methods are shared across
 *   multiple test scenarios.
 * - Easier debugging: if a test fails, you know exactly which page class
 *   and method to inspect.
 *
 * WHY HOOKS?
 * ───────────
 * - @Before / @After hooks run automatically before/after each scenario.
 * - Handle cross-cutting concerns: browser setup, teardown, screenshots,
 *   and Extent Report logging.
 * - Decouples infrastructure code from business-logic step definitions.
 * - Keeps step definitions clean and readable.
 *
 * WHY BASE CLASS?
 * ────────────────
 * - Provides a single source of truth for the WebDriver instance.
 * - All page classes inherit driver + WaitUtility from BasePage.
 * - Eliminates duplication of driver initialization in every page.
 * - Easy to add shared utilities (scroll, JS executor, etc.) once and
 *   have all pages inherit them.
 *
 * WHY UTILITY CLASSES?
 * ─────────────────────
 * - ConfigReader:     centralizes all property file reads.
 * - WaitUtility:      single place for all wait strategies.
 * - ExcelUtility:     reusable POI-based Excel reader.
 * - ScreenshotUtility: consistent screenshot naming and storage.
 * - ExceptionHandler: centralized retry and exception logic.
 * - WebTableUtility:  reusable table data extraction.
 * Following Single Responsibility Principle: each utility does ONE thing.
 *
 * ============================================================
 * FRAMEWORK ARCHITECTURE DIAGRAM
 * ============================================================
 *
 *  ┌─────────────────────────────────────────────────────────┐
 *  │                  FEATURE FILES (.feature)               │
 *  │   login.feature | hotel_search.feature | ...            │
 *  └───────────────────────┬─────────────────────────────────┘
 *                          │ Cucumber parses Gherkin
 *                          ▼
 *  ┌─────────────────────────────────────────────────────────┐
 *  │               STEP DEFINITIONS                          │
 *  │   LoginSteps | HotelSearchSteps | RegistrationSteps     │
 *  └─────┬────────────────────────────────────┬─────────────┘
 *        │ calls                               │ calls
 *        ▼                                     ▼
 *  ┌─────────────────────┐          ┌────────────────────────┐
 *  │    PAGE CLASSES     │          │        HOOKS           │
 *  │  LoginPage          │          │  @Before → initDriver  │
 *  │  RegistrationPage   │          │  @After  → screenshot  │
 *  │  HotelSearchPage    │          │           → quit driver│
 *  │  BookingPage        │          │           → report     │
 *  └────────┬────────────┘          └──────────┬─────────────┘
 *           │ extends                           │
 *           ▼                                   │
 *  ┌─────────────────────┐                      │
 *  │      BASE PAGE      │◄─────────────────────┘
 *  │  (driver, waitUtil) │
 *  └────────┬────────────┘
 *           │
 *           ▼
 *  ┌─────────────────────────────────────────────────────────┐
 *  │                     UTILITIES                           │
 *  │  WaitUtility | ExcelUtility | ScreenshotUtility         │
 *  │  ConfigReader | ExceptionHandler | WebTableUtility      │
 *  └───────────────────────┬─────────────────────────────────┘
 *                          │
 *                          ▼
 *  ┌─────────────────────────────────────────────────────────┐
 *  │                  DRIVER FACTORY                         │
 *  │   ThreadLocal<WebDriver> – Chrome / Firefox / Edge      │
 *  │   No static driver. Thread-safe. (Question 7)           │
 *  └───────────────────────┬─────────────────────────────────┘
 *                          │
 *                          ▼
 *  ┌─────────────────────────────────────────────────────────┐
 *  │                    REPORTS                              │
 *  │   ExtentReportManager → HTML Spark Report               │
 *  │   Screenshots attached on Pass / Fail / Skip            │
 *  └─────────────────────────────────────────────────────────┘
 *
 *  RUNNER (TestRunner.java + testng.xml)
 *  ────────────────────────────────────────
 *  testng.xml → parallel="methods" thread-count="5"
 *  TestRunner → @DataProvider(parallel=true)
 *  Tags: @Smoke, @Regression, @E2E
 *
 * ============================================================
 */
public class FrameworkDesign {
    // This class is documentation only. No executable code required.
}
