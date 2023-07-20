package scenario3;

import amazonBase.BaseTest;
import org.testng.annotations.Test;

public class PrivacyTestOrders extends BaseTest {

    @Test(description = "Verify that user cannot see “Your Orders” until signed in")
    public void cantShowOrdersUntilSignedIn(){
        landingPage.checkHomePage();
        landingPage.moveToAccList();
        landingPage.clickOnYourOrders();
    }

}
