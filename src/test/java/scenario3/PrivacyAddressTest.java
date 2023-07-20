package scenario3;

import amazonBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrivacyAddressTest extends BaseTest {
    @Test(description = "Verify that user cannot see “Your Address” until signed in")
    public void cantShowAddressUntilSignedIn(){
        landingPage.checkHomePage();
        landingPage.moveToAccList();
        landingPage.clickOnYourAddress();

        //Assert that you have to login first no orders are displayed and sign in email field is displayed
        Assert.assertTrue(landingPage.isSignInVisible());
    }
}
