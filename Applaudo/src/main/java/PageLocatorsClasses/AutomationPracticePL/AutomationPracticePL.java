package PageLocatorsClasses.AutomationPracticePL;

import io.github.sukgu.support.ElementFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class AutomationPracticePL<getStoreInformation1> {


    WebDriver driver;

    public  AutomationPracticePL (WebDriver driver) {
        this.driver = driver;

        ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
        // need to use decorator if you want to use @FindElementBy in your PageFactory model.
        PageFactory.initElements(decorator, this);
    }

    //! LOGIN PAGE -----------------------------------
    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    public WebElement getSignIn;

    @FindBy ( how = How.XPATH, using = "//*[@id=\"email\"]")
    public WebElement getEmailInput;

    @FindBy ( how = How.ID_OR_NAME, using = "passwd")
    public WebElement getPasswordInput;

    @FindBy (how = How.ID, id = "SubmitLogin")
    public WebElement getSubmitBtn;

    @FindBy (how = How.PARTIAL_LINK_TEXT, using = "View my shopping cart")
    public WebElement shoppingCart;

    @FindBy (how = How.LINK_TEXT, using = "Check out")
    public WebElement getCheckout;

    @FindBy (how = How.NAME, using = "email_create")
    public WebElement getEmailCreateAccount;

    @FindBy (how = How.ID, using = "SubmitCreate")
    public WebElement getCreateAccountBtn;

    @FindBy (how = How.XPATH, using = "//*[@id=\"header_logo\"]/a/img")
    public WebElement getBackToHomePage;

    @FindBy (how = How.CLASS_NAME, using = "toggle-footer")
    public WebElement  getStoreInformation1;

    @FindBy (className = "toggle-footer")
    public List<WebElement> getStoreInformation;

    @FindAll({
            @FindBy (how = How.ID, using = "block_contact_infos")
    })
    public List<WebElement> getStore;


    //*CREATE ACCOUNT WEBELEMENTS ---------------------------------

    @FindBy (how = How.XPATH, using = "((//div[@class = 'clearfix'])[2]/div/label/div/span/input)[1]")
    public WebElement getGenderTitleMr;

    @FindBy (how = How.XPATH, using = "((//div[@class = 'clearfix'])[2]/div/label/div/span/input)[2]")
    public WebElement getGenderTitleMrs;

    @FindBy (how = How.ID, using = "customer_firstname")
    public WebElement getFistName;

    @FindBy (how = How.ID, using = "customer_lastname")
    public WebElement getLasName;

    @FindBy (how = How.ID, using = "email")
    public WebElement getEmail;

    @FindBy (how = How.ID, using = "passwd")
    public WebElement getRegisterPassword;

    @FindBy (how = How.ID, using = "firstname")
    public WebElement getAddressFirstName;

    @FindBy (how = How.ID, using = "lastname")
    public WebElement getAddressLastName;

    @FindBy (how = How.ID, using = "address1")
    public WebElement getAddress;

    @FindBy (how = How.NAME, using = "city")
    public WebElement getCity;

    @FindBy (how = How.ID, using = "postcode")
    public WebElement getPostalCode;

    @FindBy (how = How.ID, using = "phone")
    public WebElement getAddressPhone;

    @FindBy (how = How.ID, using = "phone_mobile")
    public WebElement getAddressMobileNumber;

    @FindBy (how = How.ID, using = "alias")
    public WebElement getAltEmail;

    @FindBy (how = How.ID, using = "id_country")
    public WebElement getCountry;

    @FindBy (how = How.ID, using = "days")
    public WebElement getdays;

    @FindBy (how = How.ID, using = "months")
    public WebElement getMonths;

    @FindBy (how = How.ID, using = "years")
    public WebElement getYears;

    @FindBy (how = How.ID, using = "id_state")
    public WebElement getState;

    @FindBy (how = How.ID, using = "submitAccount")
    public WebElement getRgisterBtn;


    //? HOME PAGE ------------------------------

    @FindBy (xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    public WebElement getShoppingCart;



    @FindAll({
            @FindBy (xpath = "//*[@id=\"homefeatured\"]/li")
    })
    public List<WebElement> getItems;

    @FindBy(id = "homefeatured")
    public WebElement getItem;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li")
    public WebElement ImageHover;

    @FindBy (partialLinkText = "Add to cart")
    public WebElement getaddToCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    public WebElement getContinueBtn;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span/text()[1]")
    public WebElement getProceedToCheckoutBtn;


    //? Shopping Cart summary

    @FindBy(xpath = "(//tbody/tr/td[7]/div/a)[1]")
    public WebElement getDeleteItem;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span/text()")
    public WebElement getGetProceedToCheckoutBtn;

    @FindBy(name = "message")
    public WebElement getCommenTexttArea;

    @FindBy(how = How.ID_OR_NAME, using = "cgv")
    public WebElement getTOSCheckBox;

    @FindBy(className = "bankwire")
    public WebElement getPaymentMethod;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span/text()")
    public WebElement getConfirmBtn;

    @FindAll({
            @FindBy(xpath = "//div[@class = 'box']")
    })
    public WebElement getOrderConfirmationMessage;











}
