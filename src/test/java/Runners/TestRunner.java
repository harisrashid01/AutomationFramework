package Runners;

import io.cucumber.java.*;
import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "StepDefinition",
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Before()
    public void setup() {
        // Any setup code can go here, if needed
    }

    @BeforeAll()
    public static void beforeAll() {
        // This method will run once before all tests
        System.out.println("Starting Test Suite...");
    }

    @BeforeStep()
    public void beforeStep() {
        // This method will run before each step
        System.out.println("Executing a step...");
    }

    @BeforeSuite
    public void beforeSuite() {
        // This method will run once before the test suite
        System.out.println("Initializing Test Suite...");
    }

    @BeforeTest
    public void beforeTest() {
        // This method will run once before each test
        System.out.println("Preparing for tests...");
    }

    @BeforeClass
    public void beforeClass() {
        // This method will run once before each class
        System.out.println("Setting up test class...");
    }

    @BeforeMethod
    public void beforeMethod() {
        // This method will run before each test method
        System.out.println("Preparing for test method...");
    }

    @After
    public void tearDown() {
        // Any cleanup code can go here, if needed
        System.out.println("Test execution completed.");
    }

    @AfterAll()
    public static void afterAll() {
        // This method will run once after all tests
        System.out.println("Test Suite completed.");
    }

    @AfterStep()
    public void afterStep() {
        // This method will run after each step
        System.out.println("Step execution finished.");
    }

    @AfterSuite
    public void afterSuite() {
        // This method will run once after the test suite
        System.out.println("Finalizing Test Suite...");
    }

    @AfterTest
    public void afterTest() {
        // This method will run once after each test
        System.out.println("Test execution finished.");
    }

    @AfterClass
    public void afterClass() {
        // This method will run once after each class
        System.out.println("Cleaning up test class...");
    }

    @AfterMethod
    public void afterMethod() {
        // This method will run after each test method
        System.out.println("Test method execution completed.");
    }

}
