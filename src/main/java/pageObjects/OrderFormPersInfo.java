package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUtil.SeleniumWrapper;

public class OrderFormPersInfo {
    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By genderMrs = By.xpath("(//input[@name='id_gender'])[2]");

    By firstName = By.xpath("//input[@name='firstname']");

    By lastName = By.xpath("//input[@name='lastname']");

    By email = By.xpath("//input[@name='email']");

    By agreeTermsAndConditions = By.xpath("//input[@name='psgdpr']");

    By continueBtn = By.xpath("//form[@id='customer-form']//button[@name='continue']");


    public OrderFormPersInfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public void chooseGender(){
        //seleniumWrapper.click(genderMrs);
        driver.findElement(genderMrs).click();
    }

    public void enterFirstName(){
        seleniumWrapper.sendKeys(firstName,"Andra");
    }

    public void enterLastName(){
        seleniumWrapper.sendKeys(lastName,"Dia");
    }

    public void enterEmail(){
        seleniumWrapper.sendKeys(email,"andratest@gmail.com");
    }

    public void tickAgreeTermsAndConditions (){
//        seleniumWrapper.click(agreeTermsAndConditions);
        driver.findElement(agreeTermsAndConditions).click();
    }

    public void clickContinueBtn (){
        seleniumWrapper.click(continueBtn);
    }

}
