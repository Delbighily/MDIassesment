package amazonBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;
import pages.ProductPage;
import pages.TodayDealPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected LandingPage landingPage;
    protected TodayDealPage todayDealPage;
    protected ProductPage productPage;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.eg/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        landingPage =new LandingPage(driver);
        todayDealPage=new TodayDealPage(driver);
        productPage=new ProductPage(driver);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        String testCaseName= result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");
            takeScreenShot(destFile);
        }
        driver.quit();
    }


    public void takeScreenShot(File destFile){
        File file= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destFile);
            InputStream is =new FileInputStream(destFile);
            Allure.addAttachment("screenshot",is);
        } catch (IOException e) {
            throw new RuntimeException("not");
        }


    }
}

