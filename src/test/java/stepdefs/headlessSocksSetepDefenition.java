package stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.lang.Exception;
import static org.junit.Assert.assertEquals;

public class headlessSocksSetepDefenition {

    static protected WebDriver driver; // Created a variable called driver
    String link;
    String socks;


    @Before ("@headless")

    public static void setupHeadlessChromeDriver() {

        //Static protected WebDriver driver


            ChromeDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

            System.out.println("Headless Chrome browser was opened");

    }

    @After ("@headless")

    public void tearDown()
    {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        System.out.println("Browser was closed after scenario execution");

    }

    @Given("User navigates to Amazon website >")
    public void user_navigates_to_Amazon_website() throws Exception {

            driver.get("http://www.amazon.co.uk/");
            System.out.println("Chrome navigated to Amazon");


    }

    @Given("User types socks into the search section >")
    public void user_types_socks_into_the_search_section() throws NoSuchElementException {

            WebDriverWait wait = new WebDriverWait(driver,10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
            element.sendKeys("socks");
            System.out.println("Chrome searched for socks");

    }


    @Given("User presses Search button gets redirected to the page containing list of links to different types if socks >")
    public void user_presses_Search_button() throws NoSuchElementException {

            driver.findElement(By.xpath("//input[@value='Go']")).click();
            System.out.println("Chrome clicked on search button");


    }


    @When("User clicks on the first link from the list >")
    public void user_clicks_on_the_first_item_from_the_list() throws NoSuchElementException {

            WebDriverWait wait = new WebDriverWait(driver,10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/h2[1]")));
            link = driver.findElement(By.xpath("//li[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/h2[1]")).getText();
            element.click();
            System.out.println("Chrome clicked on first item from the list");

    }

    @Then("User should be redirected to the corresponding to the chosen type of socks page >")
    public void user_should_be_redirected_to_the_corresponding_to_the_chosen_type_of_socks_page() throws AssertionError {

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
            socks = driver.findElement(By.id("productTitle")).getText();
            assertEquals(link, socks);
            System.out.println("Assertion was performed");
            System.out.println(link);
            System.out.println(socks);

    }

}
