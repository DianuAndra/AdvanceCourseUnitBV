import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTest extends BasePage {
    @Test
    public void addItemToCart() throws InterruptedException {
        driver.get("https://www.automationtesting.co.uk/");
        homePage.scrollPage(500);
        homePage.openTestStoreApp();

        // add T-shirt
        testStorePO.selectProduct(testStorePO.getHummingBirdTshirt());
        singleProductPO.selectSize("L");
        singleProductPO.changeColorToBlack();

        Thread.sleep(2000);
        for(int i=0; i<2; ++i){
            singleProductPO.increaseQuantityByOne();
        }

        singleProductPO.clickAddToCart();
        shopContentPanel.continueShopping();
        singleProductPO.goBackToHomePage();

        //add poster

        homePage.scrollPage(400);
        testStorePO.selectProduct(testStorePO.getFramedPoster());

        Thread.sleep(2000);
        singleProductPO.selectPosterDimension("21");
        singleProductPO.increaseQuantityByOne();

        singleProductPO.clickAddToCart();

        //add mug
        shopContentPanel.continueShopping();
        singleProductPO.goBackToHomePage();
        homePage.scrollPage(400);

        testStorePO.selectProduct(testStorePO.getBestIsYetToComeMug());

        singleProductPO.clickAddToCart();

        // click PROCEED TO CHECKOUT
        shopContentPanel.proceedToCheckOut();

        checkOutPO.proceedToCheckoutFinalOrder();

        Thread.sleep(3000);

        orderFormPersInfo.chooseGender();
        orderFormPersInfo.enterFirstName();
        orderFormPersInfo.enterLastName();
        orderFormPersInfo.enterEmail();
        orderFormPersInfo.tickAgreeTermsAndConditions();
        orderFormPersInfo.clickContinueBtn();

        //add Address
        Thread.sleep(2000);

        orderFormDelivery.enterCompany();
        orderFormDelivery.enterAddress();
        orderFormDelivery.enterCity();
        orderFormDelivery.selectState();
        orderFormDelivery.enterPostalCode();
        orderFormDelivery.selectCountry();
        orderFormDelivery.enterPhone();

        Thread.sleep(2000);
        orderFormDelivery.clickContinueBtn();

        //shipping method
        Thread.sleep(2000);

        orderFormShippingMethod.enterDeliveryMessage();
        orderFormShippingMethod.clickContinueBtn();

        //payment
        orderFormPayment.choosePaymentMethod();
        orderFormPayment.tickAgreeTermsAndConditions();

        Thread.sleep(2000);


        // get total value
        String totalValue = checkOutPO.getTotalValue();

        try {
            Assertions.assertEquals(totalValue, "$234.26");
            report.createTest("Add product").pass("Product added successfully!");
        } catch (AssertionError e) {
            report.createTest("Add product").fail("Could NOT buy product!");
            Assertions.fail("Could not buy product!");
        }

    }



}
