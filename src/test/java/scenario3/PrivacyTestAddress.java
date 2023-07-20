package scenario3;

import amazonBase.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import javax.management.Descriptor;

public class PrivacyTestAddress extends BaseTest {
    @Test(description = "Verify that user cannot see “Your Address” until signed in")
    public void cantShowAddressUntilSignedIn(){
        landingPage.checkHomePage();
        landingPage.moveToAccList();
        landingPage.clickOnYourAddress();
    }
}
