package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUtil.SeleniumWrapper;

public class OrderFormPayment {
    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By payByBankWireOption = By.xpath("//span[.='Pay by bank wire']");

    By termsAndConditions = By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']");

    By orderWithAnObligationToPayBtn = By.cssSelector(".btn.btn-primary.center-block");
    public OrderFormPayment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public void choosePaymentMethod(){
        seleniumWrapper.click(payByBankWireOption);
    }

    public void tickAgreeTermsAndConditions(){
//        seleniumWrapper.click(termsAndConditions)
           driver.findElement(termsAndConditions).click();
        ;
    }

    public void clickPlaceOrder(){
        seleniumWrapper.click(orderWithAnObligationToPayBtn);
    }
}
