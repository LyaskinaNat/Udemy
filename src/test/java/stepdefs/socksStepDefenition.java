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
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.lang.Exception;

import static org.junit.Assert.assertEquals;

public class socksStepDefenition {

    WebDriver driver; // Created a variable called driver

    @Before ("@amazon")

    public void setupChromeDriver() throws Exception {

        //set WedDriverManager to download required ChromeDriver binary (.exe) file

        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println("Chrome browser was opened");
    }

    @After ("@amazon")

    public void tearDown()
    {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        System.out.println("Browser was closed after scenario execution");

    }

    @Given("User navigates to Amazon website")
    public void user_navigates_to_Amazon_website() throws Exception {
        driver.get("http://www.amazon.co.uk/");
        Thread.sleep(2000);

    }

    @Given("User types socks into the search section")
    public void user_types_socks_into_the_search_section() throws Exception {
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("socks");

    }


    @Given("User presses Search button gets redirected to the page containing list of links to different types if socks")
    public void user_presses_Search_button() throws Exception {
        driver.findElement(By.xpath("//input[@value='Go']")).click();

    }


    @When("User clicks on the first link from the list")
    public void user_clicks_on_the_first_item_from_the_list() {
        try {
            String link = driver.findElement(By.xpath("//li[@id='result_0']")).getText();
            System.out.println(link);
            driver.findElement(By.xpath("//h2[contains(text(),'IMITOR Cotton Quarter Athletic Socks, Running, spo')]")).click();


        } catch (Exception e) {
            System.out.println("Unable to access first link on the page: " + e.getMessage());
        }

    }

    @Then("User should be redirected to the corresponding to the chosen type of socks page")
    public void user_should_be_redirected_to_the_corresponding_to_the_chosen_type_of_socks_page() throws Exception {
        Thread.sleep(2000);
        String socks = driver.findElement(By.id("productTitle")).getText();
        System.out.println(socks);
        assertEquals("IMITOR Cotton Quarter Athletic Socks, Running, sports, Sneakers,Business, Everyday, Unisex (Black White Grey, 5 Pairs)", socks);


    }



}
