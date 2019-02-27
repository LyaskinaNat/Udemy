package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ContactUsSteps {

    @Given("I access webdriveruniversity contact us form")
    public void i_access_webdriveruniversity_contact_us_form()throws Exception {
        System.out.println("test");
    }

    @Given("I enter the valid firstname")
    public void i_enter_the_valid_firstname() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("I enter  the valid last name")
    public void i_enter_the_valid_last_name(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

    @Given("I enter a valid email address")
    public void i_enter_a_valid_email_address() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("I enter comments")
    public void i_enter_comments(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

    @When("I click on submit button")
    public void i_click_on_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the information should successfully be submitted via the contact form")
    public void the_information_should_successfully_be_submitted_via_the_contact_form() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }



}
