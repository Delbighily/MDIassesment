package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodayDealPage {
    private WebDriver driver;


    //xpathes are morly used here as it is not related to the content.
    private By list=By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul");
    private By firstProduct =By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/a");
    private By secondItem=By.xpath("//*[@id=\"octopus-dlp-asin-stream\"]/ul/li[2]/span/div/div[1]/a/div");


    public TodayDealPage(WebDriver driver) {
        this.driver = driver;
    }





    /*The method below is created to find category by index and to handle
    difference between index and counting numbers*/
    @Step
    public void getCategoryNumber(int num) {

        WebElement myList = driver.findElement(list);
        List<WebElement> listItems = myList.findElements(By.tagName("li"));
        WebElement Item = listItems.get(num-1);
        Item.click();
    }



    @Step
    public void clickOnFirstProduct(){
        driver.findElement(firstProduct).click();
    }
    @Step
    public void clickOnSecondItem(){driver.findElement(secondItem).click();}
   }
