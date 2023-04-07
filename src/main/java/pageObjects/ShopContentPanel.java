package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUtil.SeleniumWrapper;

public class ShopContentPanel {
    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
    By proceedToCheckOutBtn = By.cssSelector(".cart-content-btn .btn-primary");

    public ShopContentPanel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public void proceedToCheckOut() {
        seleniumWrapper.click(proceedToCheckOutBtn);
    }

    public void continueShopping(){seleniumWrapper.click(continueShoppingBtn);}


}
