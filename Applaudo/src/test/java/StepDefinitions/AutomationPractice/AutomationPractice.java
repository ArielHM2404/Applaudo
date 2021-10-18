package StepDefinitions.AutomationPractice;

import PageActions.AutomationPractice.AutomationPracticePA;
import Utils.SeleniumDriverClass;
import Utils.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class AutomationPractice {
    AutomationPracticePA automationPA = null;

    public AutomationPractice() {
        this.automationPA = new AutomationPracticePA();
        PageFactory.initElements(SeleniumDriverClass.getDriver(), automationPA);
    }

    @Given("I navigate to {string} Home Page")
    public void i_navigate_to_home_page(String webpage) {
        SeleniumDriverClass.navigateToPage(webpage);
    }
    @Then("I Validate Screen title")
    public void i_validate_screen_title() {
        String title = SeleniumDriverClass.getDriver().getTitle();
        System.out.println("verifying title" + title);
        Utils.customWait(5);
    }

    @Given("I Sign in {string} and {string}")
    public void i_sign_in_and(String username, String password) {
        automationPA.login(username, password);
        Utils.customWait(5);
    }


    @Given("I need to create and Account with and email")
    public void i_need_to_create_and_account_with_and_email(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String email = data.get(0).get("Email");
        automationPA.userRegister(email);
    }

    @Given("I enter my personal information")
    public void i_enter_my_personal_information(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String email = data.get(0).get("Email");
        String title = data.get(0).get("Title");
        String firstName = data.get(0).get("FirstName");
        String lastName = data.get(0).get("LastName");
        String password= data.get(0).get("Password");
        String day = data.get(0).get("Day");
        String month = data.get(0).get("Month");
        String year = data.get(0).get("Year");
        automationPA.fillPersonalInformation(email, title, firstName, lastName,
                password, day,  month,  year);
    }

    @Then("I enter my address information")
    public void i_enter_my_address_information(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String firstName = data.get(0).get("FirstName");
        String lastName = data.get(0).get("LastName");
        String address = data.get(0).get("Address");
        String city = data.get(0).get("City");
        String state= data.get(0).get("State");
        String postalCode = data.get(0).get("PostalCode");
        String country = data.get(0).get("Country");
        String phone = data.get(0).get("Home phone");
        String cellPhone = data.get(0).get("Mobile phone");
        String altEmail = data.get(0).get("AltEmail");
        automationPA.fillAddressInformation(firstName, lastName, address, city, state, postalCode,
                country, phone, cellPhone, altEmail);
    }

    @Then("I move back to HomePage")
    public void i_move_back_to_home_page() {
        automationPA.backToHomePage();

    }

    @When("I add {string} items to shopping cart")
    public void i_add_items_to_shopping_cart(String amount) {

        automationPA.getitemsToShop(amount);
    }

    @But("I delete {string} item from shopping cart")
    public void I_delete_item_from_shopping_cart(String amount) {

        automationPA.deleteDesitedItems(amount);
        Utils.customWait(5);
    }

    @And("I move to shopping cart")
    public void I_move_to_shopping_cart() {
        automationPA.clickShoppingCart();

    }
    @When("I delete {int} item from shopping cart")
    public void i_delete_item_from_shopping_cart(Integer amount) {

    }
    @Then("I proceed with order purchase")
    public void i_proceed_with_order_purchase() {

    }

    @Given("I Scroll down until Store Location")
    public void i_scroll_down_until_store_location() {

        automationPA.navigateToEndOfPage();
    }
    @Then("I verify Store Information")
    public void i_verify_store_information() {

        automationPA.getStoreInformation();
    }



}
