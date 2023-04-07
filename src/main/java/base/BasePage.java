package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    public static String screenShotDestinationPath;
    public static ExtentReports report = new ExtentReports();
    public HomePagePO homePage = new HomePagePO(driver);
    public TestStorePO testStorePO = new TestStorePO(driver);
    public SingleProductPO singleProductPO = new SingleProductPO(driver);

    public ShopContentPanel shopContentPanel = new ShopContentPanel(driver);
    public CheckOutPO checkOutPO = new CheckOutPO(driver);

    public OrderFormPersInfo orderFormPersInfo = new OrderFormPersInfo(driver);

    public OrderFormDelivery orderFormDelivery = new OrderFormDelivery(driver);

    public OrderFormShippingMethod orderFormShippingMethod = new OrderFormShippingMethod(driver);

    public OrderFormPayment orderFormPayment = new OrderFormPayment(driver);


    @BeforeAll
    public static void setup() throws IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "/report/"));
        FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "/screenshots/"));

        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/report/");
        report.attachReporter(spark);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        driver = null;
        report.flush();
    }

    @AfterEach
    public void takeScreenshot(TestInfo testInfo) throws Exception {
        takeSnapShot(driver, System.getProperty("user.dir") + "/screenshots/" + this.getClass().getName() + "/" + testInfo.getDisplayName() + ".png");
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public String takeSnapShot(String name) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String destFile = System.getProperty("user.dir") + "\\screenshots\\" + timestamp() + ".png";
        screenShotDestinationPath = destFile;

        try {
            FileUtils.copyFile(srcFile, new File(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return name;
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static String getScreenshotDestinationPath() {
        return screenShotDestinationPath;
    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

    public static Properties properties;

    {
        try {
            properties = readPropertiesFile("src/main/resources/config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
