package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUtil.SeleniumWrapper;

public class TestStorePO {

    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By hummingBirdTshirt = By.linkText("Hummingbird Printed T-Shirt");

    By framedPoster = By.linkText("The Best Is Yet To Come'...");

    public By getBestIsYetToComeMug() {
        return bestIsYetToComeMug;
    }

    By bestIsYetToComeMug = By.linkText("Mug The Best Is Yet To Come");


    public By getHummingBirdTshirt() {
        return hummingBirdTshirt;
    }

    public By getFramedPoster() {
        return framedPoster;
    }

    public TestStorePO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public void selectProduct(By chosenProduct){
        seleniumWrapper.click(chosenProduct);
    }
}
