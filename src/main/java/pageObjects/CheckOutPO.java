package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUtil.SeleniumWrapper;

public class CheckOutPO {

    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By totalValueString = By.cssSelector(".cart-summary-line.cart-total > .value");


    By orderProceedToCheckOut = By.linkText("PROCEED TO CHECKOUT");
    public CheckOutPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public String getTotalValue() {
        WebElement totalValue = driver.findElement(totalValueString);
        return totalValue.getText();
    }

    public void proceedToCheckoutFinalOrder(){
        seleniumWrapper.click(orderProceedToCheckOut);
    }
}
