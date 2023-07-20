package scenario1;

import amazonBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify that user cannot log in with valid but not registered email")
    public void testSuccessfullSignin() {
        landingPage.checkHomePage();
        landingPage.clickSignInLink();
        landingPage.fillInEmailField("mdiTest@gmail.com");
        landingPage.PressOnContinue();
        Assert.assertTrue(landingPage.msgError(),"expected error message is not displayed");
    }
    }