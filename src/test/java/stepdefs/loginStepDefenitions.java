package stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.lang.Exception;
import static org.junit.Assert.assertEquals;


public class loginStepDefenitions {

    WebDriver driver; // Created a variable called driver

    @Before ("@chrome_br")

    public void setupChromeDriver() throws Exception {

        //set WedDriverManager to download required ChromeDriver binary (.exe) file

        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println("Chrome browser was opened");
    }

    @Before ("@safari_br")

    public void setupSafariDriver() throws Exception {
        this.driver = new SafariDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println("Safari browser was opened");
    }

    @Before ("@firefox_br")

    public void setupFirefoxDriver() throws Exception {

        // Set System properties for ChromeDriver explicitly

        String exePath = "scr/test/drivers/geckodriver.exe";
        System.setProperty("webdriver.firefox.driver", exePath );
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println("Firefox browser was opened");
    }


    @After ("@chrome_br, @safari_br, @firefox_br")
    public void tearDown()
    {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        System.out.println("Browser was closed after scenario execution");

    }


    @Given("^User navigates to WebDriverUniversity website$")
    public void user_navigates_to_Udemy_website() throws Exception {

        driver.get("http://www.webdriveruniversity.com/");

    }


    @Given("^User clicks on the Login option$")
    public void user_clicks_on_the_Login_option() throws NoSuchElementException {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'LOGIN PORTAL')]")));
        element.click();


    }

    @Given("^User enters a valid username$")
    public void user_enters_a_valid_user_name() throws NoSuchWindowException {
        //store the current window handle
        @SuppressWarnings("unused")
        String winHandleBefore = driver.getWindowHandle();
        //Perform the click operation that opens new window
        //Switch to new window opened

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));


            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("webdriver");
            System.out.println("User entered valid user name");



    }


    @Given("^User enters a valid password$")
    public void user_enters_a_valid_password()throws NoSuchElementException {

            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));

            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("webdriver123");
            System.out.println("User entered valid password");



    }

    @When("^User clicks on the Login button$")
    public void user_clicks_on_the_Login_button() throws Throwable {

            driver.findElement(By.xpath("//button[@id='login-button']")).click();
            System.out.println("User clicked on the login button");
            Thread.sleep(1000);

    }

    @Then("^User should be shown login success message$")
    public void user_should_be_taken_to_the_success_login_page() throws AssertionError {

            Alert alert = driver.switchTo().alert();
            System.out.println("Login success/failure message: " + (alert).getText());
            assertEquals("validationsucceeded", alert.getText().toLowerCase().replaceAll("\\s", ""));
            alert.accept();

    }


    @Given("^User enters \"([^\"]*)\" username$")
    public void user_enters_username(String username) throws NoSuchWindowException {



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

    }

    @Given("^User enters \"([^\"]*)\" password$")
    public void user_enters_password(String password) throws Throwable {


                driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
                System.out.println("User entered their password");
                Thread.sleep(1000);


    }

    @Then("^User should be shown login \"([^\"]*)\" message$")
    public void user_should_be_shown_login_message(String message) throws AssertionError {


                Alert alert = driver.switchTo().alert();
                System.out.println("Login success/failure message: " + (alert).getText());
                assertEquals(message.toLowerCase().replaceAll("\\s", ""), alert.getText().toString().toLowerCase().replaceAll("\\s", ""));
                alert.accept();
             }



}

