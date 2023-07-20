package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class LandingPage {
    private WebDriver driver;

    //Elements used in scenario1
    private By signInLink=By.id("nav-link-accountList");
    private By emailField=By.id("ap_email");
    private By continueButton=By.id("continue");
    private By errorMsg=By.id("auth-error-message-box");





    //Elements used in scenario2
    private By allTab=By.id("nav-hamburger-menu");
    private By todayDealLink=By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[17]/a");
    private By yourOrders =By.id("nav_prefetch_yourorders");
    private By yourAddress=By.id("nav_prefetch_youraddresses");
    private By yourLists=By.xpath("//*[@id=\"nav-al-your-account\"]/a[4]");
    private By images=By.className("al-intro-benefit-icon");
    private By signInBtn=By.className("a-button-inner");






    //This method is used in all Scenarios to check whether on the right page
    public LandingPage(WebDriver driver) {this.driver = driver;}
    @Step
    public void checkHomePage(){
        WebElement parent = driver.findElement(By.xpath("/html/body"));
        List<WebElement> warrantDiv = parent.findElements(By.xpath("//*[@id=\"nav-bb-logo\"]"));
        if (!warrantDiv.isEmpty()) {
            driver.findElement(By.xpath("//*[@id=\"nav-bb-logo\"]")).click();
        }

    }


    //Methods Below are used in Scenario1
    @Step
    public void clickSignInLink(){
        driver.findElement(signInLink).click();
    }
    @Step
    public void fillInEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    @Step
    public void PressOnContinue(){
        driver.findElement(continueButton).click();
    }

    public boolean msgError(){ return driver.findElement(errorMsg).isDisplayed();}




    //method Below are used in Scenario2
    @Step
    public void PressOnAll(){
        driver.findElement(allTab).click();
    }
    @Step
    public TodayDealPage PressTodayDeals(){
        driver.findElement(todayDealLink).click();
        return new TodayDealPage(driver);
    }




    //method Below are used in Scenario3
    @Step
    public void moveToAccList() {
        Actions actions = new Actions(driver);
        WebElement accAndLis = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accAndLis).perform();
    }
    @Step
    public void clickOnYourOrders(){
        driver.findElement(yourOrders).click();
    }
    @Step
    public void clickOnYourAddress(){
        driver.findElement(yourAddress).click();
    }
    @Step
    public void clickOnYourLists(){
        driver.findElement(yourLists).click();
    }

    public boolean isSignInVisible(){return driver.findElement(emailField).isDisplayed();}
    public boolean isImagesVisible(){return driver.findElement(images).isDisplayed();}
    public boolean isSignInBtnVisible(){return driver.findElement(signInBtn).isDisplayed();}
}
