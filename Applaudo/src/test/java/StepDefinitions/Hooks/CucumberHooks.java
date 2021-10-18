package StepDefinitions.Hooks;

import Utils.SeleniumDriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;


public class CucumberHooks {

    @Before
    public void setUp() {
        SeleniumDriverClass.setUpDriver();
        System.out.println("Setting the Browsers");

    }
    @AfterTest
    public String getBase64Screeshot(Scenario scenario) throws IOException {
        WebDriver driver=SeleniumDriverClass.getDriver();
        String base64Screenshot = "";
//        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = sdf.format(date);
        FileUtils.copyFile(src, new File("screenshot/"+ "image_"+ sDate + ".png"));

        byte[] fileContent = FileUtils.readFileToByteArray(src);
        base64Screenshot = "data:image/png:base64," + Base64.getEncoder().encodeToString(fileContent);

        return base64Screenshot;
    }

    public static byte[] getByteScreenshot() throws IOException {
        WebDriver driver=SeleniumDriverClass.getDriver();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;


    }

    @After
    public void tearDown(Scenario scenario) {

//        @After
//        public static void tearDown(Scenario scenario) {

            WebDriver driver=SeleniumDriverClass.getDriver();
            System.out.println(scenario.isFailed());
            if (scenario.isFailed()) {
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotBytes, "image/png", "screenshot");


            }
//            SeleniumDriver.tearDown();


        SeleniumDriverClass.tearDown();
    }

//    @AfterSuite
//    public void teadDown() {
//        SeleniumDriverClass.tearDown();
//
//    }
}
