package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class SeleniumDriverClass {

    /*
     * WebDriver
     * TestNG
     * Screenshot
     * Log4j
     * Properties
     * Keywords
     * Database
     * JavaMail
     * Extent
     * Listeners
     * Excel
     * Waits
     *
     */

//    public WebDriver driver;
    public static Logger log = Logger.getLogger(SeleniumDriverClass.class.getName());
    public static Properties Config = new Properties();
    public static FileInputStream fis;
    public static WebDriverWait wait;
//    static WebElement dropdown;


    public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
    private static SeleniumDriverClass seleniumDriver;

    //Init WevDriver
    private static WebDriver driver;
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    public SeleniumDriverClass() {
         String browserName = null;

        PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");


        try {
            fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Config.load(fis);
            log.info("Config Properties loaded !!!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        browserName = Config.getProperty("browser");


        if(browserName.equals("chrome")) {


            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");


            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            log.info("Chrome Browser Launched !!!");

        }else if(browserName.equals("firefox")) {


            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            log.info("Firefox Browser Launched !!!");
        }

        log.info("Navigating to the URL : "+Config.getProperty("testsiteurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,Integer.parseInt(Config.getProperty("explicit.wait")));

    }



    public static void navigateToPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUp() {
        String browserName;


        PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");



        try {
            fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Config.load(fis);
            log.info("Config Properties loaded !!!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        browserName = Config.getProperty("browser");


        if(browserName.equals("chrome")) {


            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");


            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            log.info("Chrome Browser Launched !!!");
        }else if(browserName.equals("firefox")) {


            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            log.info("Firefox Browser Launched !!!");
        }

        //DriverManager.setWebDriver(driver);

        driver.get(Config.getProperty("testsiteurl"));
        log.info("Navigating to the URL : "+Config.getProperty("testsiteurl"));
//        DbManager.setMysqlDbConnection();
        log.info("Database connection established");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,Integer.parseInt(Config.getProperty("explicit.wait")));





    }


    public static void setUpDriver() {
        if (seleniumDriver == null) {
            seleniumDriver = new SeleniumDriverClass();


        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }


    public static void PAGE_LOAD_TIMEOUT(int i) {
    }


}
