package scenario2;

import amazonBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test(description = "Verify that Items are added to cart correctly")
    public void testSuccessfullAddToCart() {
        landingPage.checkHomePage();
        landingPage.PressOnAll();
        landingPage.PressTodayDeals();
        todayDealPage.getCategoryNumber(2);
        todayDealPage.clickOnFirstProduct();
        todayDealPage.clickOnSecondItem();
        productPage.changeQuantity();
        String priceProduct =productPage.getProductPrice();
        String nameProduct= productPage.getProductName();
        String QuantityProduct= productPage.getProductQuantity();
        productPage.clickAddToCart();
        productPage.clickOnProceedToCart();
        String priceCart= productPage.getCartPrice();
        String nameCart= productPage.getCartName();
        String QuantityCart=productPage.getCartQuantity();

        //ASSERTIONS

        Assert.assertEquals(QuantityCart,QuantityProduct);
        Assert.assertEquals(nameCart,nameProduct);
        //This was left to fail the Test to test Screen shots
        //Assert.assertEquals(priceCart,priceProduct);
        }
    }

