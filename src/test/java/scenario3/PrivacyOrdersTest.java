package scenario3;

import amazonBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrivacyOrdersTest extends BaseTest {

    @Test(description = "Verify that user cannot see “Your Orders” until signed in")
    public void cantShowOrdersUntilSignedIn(){
        landingPage.checkHomePage();
        landingPage.moveToAccList();
        landingPage.clickOnYourOrders();

        //Assert that you have to login first no orders are displayed and sign in email field is displayed
        Assert.assertTrue(landingPage.isSignInVisible());
    }

}
