package stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.lang.Exception;


import static org.junit.Assert.assertEquals;


public class loginStepDefenitions {

    WebDriver driver; // Created a variable called driver

    @Before ("@chrome")

    public void setupChromeDriver() throws Exception {

        //set WedDriverManager to download required ChromeDriver binary (.exe) file

        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println("Chrome browser was opened");
    }

    @Before ("@safari")

    public void setupSafariDriver() throws Exception {
        this.driver = new SafariDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println("Safari browser was opened");
    }

    @Before ("@firefox")

    public void setupFirefoxDriver() throws Exception {

        // Set System properties for ChromeDriver explicitly

        String exePath = "scr/test/drivers/geckodriver.exe";
        System.setProperty("webdriver.firefox.driver", exePath );
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println("Firefox browser was opened");
    }


    @After ("@chrome, @safari, @firefox")
    public void tearDown()
    {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        System.out.println("Browser was closed after scenario execution");

    }


    @Given("^User navigates to WebDriverUniversity website$")
    public void user_navigates_to_Udemy_website()
    {

        try {
            driver.get("http://www.webdriveruniversity.com/");

        }

        catch (Exception e) {
            System.out.println("Unable to access WebDriverUniversity Website: " + e.getMessage());
        }
    }


    @Given("^User clicks on the Login option$")
    public void user_clicks_on_the_Login_option() {

        try {
            Thread.sleep(2000);

        driver.findElement(By.xpath("//h1[contains(text(),'LOGIN PORTAL')]")).click();

        }
        catch (Exception e) {
            System.out.println("Unable to click on login option: " + e.getMessage());
        }
    }

    @Given("^User enters a valid username$")
    public void user_enters_a_valid_user_name() throws Exception {
        //store the current window handle
        @SuppressWarnings("unused")
        String winHandleBefore = driver.getWindowHandle();
        //Perform the click operation that opens new window
        //Switch to new window opened

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));


            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("webdriver");
            System.out.println("User entered valid user name");
        }
        catch (Exception e) {
            System.out.println("Element is not visible: " + e.getMessage());
        }


    }


    @Given("^User enters a valid password$")
    public void user_enters_a_valid_password() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));

            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("webdriver123");
            System.out.println("User entered valid password");
        }
        catch (Exception e) {
            System.out.println("Element is not visible: " + e.getMessage());
        }

    }

    @When("^User clicks on the Login button$")
    public void user_clicks_on_the_Login_button() {
        try {


            driver.findElement(By.xpath("//button[@id='login-button']")).click();
            System.out.println("User clicked on the login button");
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println("Unable to click on login button: " + e.getMessage());
        }
    }

    @Then("^User should be shown login success message$")
    public void user_should_be_taken_to_the_success_login_page() {
        try {


            Alert alert = driver.switchTo().alert();
            System.out.println("Login success/failure message: " + (alert).getText());
            assertEquals("validationsucceeded", alert.getText().toString().toLowerCase().replaceAll("\\s", ""));
            alert.accept();
        }
        catch (Exception e) {
            System.out.println("Assertion action failed: " + e.getMessage());
        }
    }


    @Given("^User enters \"([^\"]*)\" username$")
    public void user_enters_username(String username) {
        try {

            //store the current window handle
            @SuppressWarnings("unused")
            String winHandleBefore = driver.getWindowHandle();
            //Perform the click operation that opens new window
            //Switch to new window opened

            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }

            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
            System.out.println("User entered their user name");
        } catch (Exception e) {
            System.out.println("Unable to enter username: " + e.getMessage());
        }
    }

    @Given("^User enters \"([^\"]*)\" password$")
    public void user_enters_password(String password) {
            try {

                driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
                System.out.println("User entered their password");
                Thread.sleep(1000);
            }
            catch (Exception e) {
                System.out.println("Unable to enter password: " + e.getMessage());
            }

    }

    @Then("^User should be shown login \"([^\"]*)\" message$")
    public void user_should_be_shown_login_message(String message) {
            try {

                Alert alert = driver.switchTo().alert();
                System.out.println("Login success/failure message: " + (alert).getText());
                assertEquals(message.toLowerCase().replaceAll("\\s", ""), alert.getText().toString().toLowerCase().replaceAll("\\s", ""));
                alert.accept();
            }
            catch (Exception e) {
                System.out.println("Assertion action failed: " + e.getMessage());
            }


    }



}

