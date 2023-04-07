package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUtil.SeleniumWrapper;

public class OrderFormShippingMethod {
    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By deliveryMsgTextbox = By.cssSelector("textarea#delivery_message");

    By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

    public OrderFormShippingMethod(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }



    public void enterDeliveryMessage(){
        seleniumWrapper.sendKeys(deliveryMsgTextbox,"Please come after 4pm.");
    }

    public void clickContinueBtn(){
        seleniumWrapper.click(continueBtn);
    }
}
