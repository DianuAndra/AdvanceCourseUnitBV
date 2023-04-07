package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUtil.SeleniumWrapper;

public class OrderFormDelivery {
    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By companyNameField = By.cssSelector("input[name='company']");
    By addressField = By.cssSelector("[name='address1']");
    By cityField = By.cssSelector("input[name='city']");
    By stateDropdown = By.cssSelector("select[name='id_state']");
    By postcodeField = By.cssSelector("input[name='postcode']");
    By countryDropdown = By.cssSelector("select[name='id_country']");
    By phoneField = By.cssSelector("input[name='phone']");
    By continueBtn = By.cssSelector("button[name='confirm-addresses']");


    public OrderFormDelivery(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }


    public void enterCompany(){
        seleniumWrapper.sendKeys(companyNameField,"Endava");
    }

    public void enterAddress(){
        seleniumWrapper.sendKeys(addressField,"Soarelui nr.7");
    }

    public void enterCity(){
        seleniumWrapper.sendKeys(cityField,"Brasov");
    }

    public void selectState(){
        Select stateOption = new Select(driver.findElement(stateDropdown));
        stateOption.selectByVisibleText("Texas");
    }

    public void enterPostalCode(){
        seleniumWrapper.sendKeys(postcodeField,"50044");
    }

    public void selectCountry(){
        Select countryOption = new Select(driver.findElement(countryDropdown));
        countryOption.selectByVisibleText("United States");
    }

    public void enterPhone(){
        seleniumWrapper.sendKeys(phoneField,"0741210699");
    }

    public void clickContinueBtn(){
        seleniumWrapper.click(continueBtn);
    }
}
