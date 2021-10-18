package PageActions.AutomationPractice;

import PageLocatorsClasses.AutomationPracticePL.AutomationPracticePL;
import Utils.SeleniumDriverClass;
import Utils.Utils;
import io.github.sukgu.support.ElementFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static Utils.SeleniumDriverClass.wait;

public class AutomationPracticePA {
    WebDriver driver;
    AutomationPracticePL automationPracticePL = null;

    public AutomationPracticePA() {
        this.automationPracticePL = new AutomationPracticePL(SeleniumDriverClass.getDriver());
        ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
        PageFactory.initElements(SeleniumDriverClass.getDriver(), automationPracticePL);
    }

    public void login(String username, String password) {

        automationPracticePL.getSignIn.click();
        automationPracticePL.getEmailInput.sendKeys(username);
        automationPracticePL.getPasswordInput.sendKeys(password);
        automationPracticePL.getSubmitBtn.click();
    }

    public void userRegister(String email) {
        automationPracticePL.getSignIn.click();
        automationPracticePL.getEmailCreateAccount.sendKeys(email);
        automationPracticePL.getCreateAccountBtn.click();
    }

    public void navigateToEndOfPage() {
        Utils.scrollToElement(automationPracticePL.getStoreInformation1);
    }

    public void getStoreInformation() {
        //? In case we want to print all footers categories
//        List <WebElement> storeInfo = (List<WebElement>) automationPracticePL.getStoreInformation;

        List <WebElement> storeI = automationPracticePL.getStore;

        for (WebElement information : storeI) {
            System.out.println(information.getText());
        }

        //? In case we want to print all footers categories
//        for (WebElement information : storeI) {
//            WebElement test = SeleniumDriverClass.getDriver().findElement(By.tagName("li"));
//            System.out.println(test.getText());
//            System.out.println(storeI);
//        }
    }

    public void getitemsToShop(String amount) {

        Actions actions = new Actions(SeleniumDriverClass.getDriver());
        Utils.scrollToElement(automationPracticePL.ImageHover);

        int quantity = Integer.parseInt(amount);
        List<WebElement> clothes = automationPracticePL.getItem.findElements(By.tagName("li"));
        System.out.println(clothes.size());

        System.out.println(automationPracticePL.getItems.size());

        for ( int i = 1; i < automationPracticePL.getItems.size(); i++) {

            actions.moveToElement((WebElement) automationPracticePL.getItems.get(i-1)).perform();
            actions.moveToElement(automationPracticePL.getaddToCart).click().build().perform();
            automationPracticePL.getContinueBtn.click();

            System.out.println(i);
            if (i == quantity)
            break;
        }
    }

    public void deleteDesitedItems(String amount) {
        int quantity = Integer.parseInt(amount);

        for (int i = 0; i < quantity; i++) {

//            wait.until(ExpectedConditions.elementToBeClickable(automationPracticePL.getDeleteItem));
            wait.until(ExpectedConditions.visibilityOf(automationPracticePL.getDeleteItem));
            Utils.customWait(1);
            automationPracticePL.getDeleteItem.click();
            Utils.customWait(2);
//            i++;
            if (i == quantity) {
                break;
            }
        }
    }

    public void fillPersonalInformation(String email, String title, String firstName, String lastName,
                                               String password, String day, String month, String year) {
        //? Select Object
        Select days = new Select(automationPracticePL.getdays);
        Select months = new Select(automationPracticePL.getMonths);
        Select years = new Select(automationPracticePL.getYears);

        //! converting Month value to number selection to be selected in webpage
        month = monthSelection(month);

        switch (title) {
            case "1":
                automationPracticePL.getGenderTitleMr.click();
                break;
            case "2":
                automationPracticePL.getGenderTitleMrs.click();
                break;
            default:
                Assert.fail("Invalid selection, gender must be 1 == Mr. or 2 == Mrs.");
        }

        automationPracticePL.getFistName.sendKeys(firstName);
        automationPracticePL.getLasName.sendKeys(lastName);
        automationPracticePL.getEmail.clear();
        automationPracticePL.getEmail.sendKeys(email);
        automationPracticePL.getRegisterPassword.sendKeys(password);

        days.selectByValue(day);
        months.selectByValue(month);
        years.selectByValue(year);
    }

    public void fillAddressInformation(String firstName, String lastName, String address, String city, String state, String postalCode,
                                              String country, String phone, String cellPhone, String altEmail) {
        //* Select Objects
        Select stateSelection = new Select(automationPracticePL.getState);
        Select countrySelection = new Select(automationPracticePL.getCountry);

        automationPracticePL.getAddressFirstName.clear();
        automationPracticePL.getAddressFirstName.sendKeys(firstName);
        automationPracticePL.getAddressLastName.clear();
        automationPracticePL.getAddressLastName.sendKeys(lastName);
        automationPracticePL.getAddress.sendKeys(address);
        automationPracticePL.getCity.sendKeys(city);
        stateSelection.selectByVisibleText(state);
        automationPracticePL.getPostalCode.sendKeys(postalCode);
        countrySelection.selectByVisibleText(country);
        automationPracticePL.getAddressPhone.sendKeys(phone);
        automationPracticePL.getAddressMobileNumber.sendKeys(cellPhone);
        automationPracticePL.getAltEmail.sendKeys(altEmail);
        automationPracticePL.getRgisterBtn.click();

    }

    public String monthSelection(String monthSelection) {

        switch (monthSelection) {
            case "January":
                monthSelection = "1";
                break;
            case "February":
                monthSelection = "2";
                break;
            case "March":
                monthSelection = "3";
                break;
            case "April":
                monthSelection = "4";
                break;
            case "May":
                monthSelection = "5";
                break;
            case "June":
                monthSelection = "6";
                break;
            case "July":
                monthSelection = "7";
                break;
            case "August":
                monthSelection = "8";
                break;
            case "September":
                monthSelection = "9";
                break;
            case "October":
                monthSelection = "10";
                break;
            case "November":
                monthSelection = "11";
                break;
            case "December":
                monthSelection = "12";
                break;
            default:
                Assert.fail("Incorrect Month");
        }
        return monthSelection;
    }

    public void backToHomePage() { automationPracticePL.getBackToHomePage.click(); }
    public void clickShoppingCart() { automationPracticePL.getShoppingCart.click(); }




}
