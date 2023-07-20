package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;

    private By quantityDD=By.id("quantity");
    private By addCartBtn=By.id("add-to-cart-button");
    private By warrantyPopUp=By.id("attach-warranty");
    private By NoButton=By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input");
    private By continueToCart=By.xpath("//*[@id=\"sw-gtc\"]/span/a");
    private By productName=By.id("productTitle");
    private By productPrice=By.xpath("//*[@id=\"corePrice_feature_div\"]/div/span[1]/span[2]");
    private By productQuantity=By.id("quantity");

    //Cart element Locators
    private By cartPrice=By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/div/div/div[1]/p/span");
    private By cartName=By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/li[1]/span/a/span[1]/span/span[2]");
    private By cartQuantity=By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]");





    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void changeQuantity(){
        Select quanDropDown= new Select(driver.findElement(quantityDD));
        quanDropDown.selectByVisibleText("2");
    }

    @Step
    //To check and handle if site offeres extended warranty
    public void clickAddToCart(){
        WebElement parent = driver.findElement(By.xpath("//*[@id=\"addToCart\"]/div/div/div"));
        List<WebElement> warrantDiv = parent.findElements(By.xpath("//*[@id=\"abbWrapper\"]"));


        if (!warrantDiv.isEmpty()) {
            //site offers warranty but will be rejected
            driver.findElement(addCartBtn).click();

            try {
                Thread.sleep(Duration.ofSeconds(2));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.findElement(NoButton).click();
        }else {//site won't offer extended warranty
            driver.findElement(addCartBtn).click();
        }
    }


    public void clickOnProceedToCart(){
        driver.findElement(continueToCart).click();
    }

    //For assertions
    public String getProductName(){return driver.findElement(productName).getText();}
    public String getProductPrice(){return driver.findElement(productPrice).getText();}
    public String getProductQuantity(){return driver.findElement(productQuantity).getAttribute("value");}
    public String getCartName(){return driver.findElement(cartName).getText();}
    public String getCartPrice(){return driver.findElement(cartPrice).getText();}
    public String getCartQuantity(){return driver.findElement(cartQuantity).getText();}



}
