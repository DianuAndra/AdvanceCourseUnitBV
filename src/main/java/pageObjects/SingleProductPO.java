package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUtil.SeleniumWrapper;

public class SingleProductPO {

    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By sizeDropdown = By.id("group_1");

    By dimensionDropdown = By.id("group_3");
    By quantityControlUp = By.cssSelector(".touchspin-up");
    By addToCartBtn = By.cssSelector(".add-to-cart");

    By homepageLink = By.xpath("//span[text()='Home']");
    By changeColorOption = By.xpath("//ul[@id='group_2']/li[2]/label/input");

    public SingleProductPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public void selectSize(String size) {
        Select option = new Select(driver.findElement(sizeDropdown));
        option.selectByVisibleText(size);
    }


    public void selectPosterDimension(String dimension) {
        Select option = new Select(driver.findElement(dimensionDropdown));
        option.selectByValue(dimension);
    }

    public void changeColorToBlack() throws InterruptedException {
//        seleniumWrapper.click(changeColorOption);
        driver.findElement(changeColorOption).click();
    }
    public void increaseQuantityByOne() {
        seleniumWrapper.click(quantityControlUp);
    }

    public void clickAddToCart() {
        seleniumWrapper.click(addToCartBtn);
    }

    public void goBackToHomePage(){
        seleniumWrapper.click(homepageLink);
    }

}
