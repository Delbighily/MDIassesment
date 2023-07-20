package scenario3;

import amazonBase.BaseTest;
import org.testng.annotations.Test;

public class PrivacyTestList extends BaseTest {
    @Test(description = "Verify that user cannot see “Your Lists” until signed in but can see intro screen")
    public void cantShowListsUntilSignedIn(){
        landingPage.checkHomePage();
        landingPage.moveToAccList();
        landingPage.clickOnYourLists();
    }
}
