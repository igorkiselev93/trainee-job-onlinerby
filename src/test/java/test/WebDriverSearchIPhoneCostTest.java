package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OnlinerHomePage;

public class WebDriverSearchIPhoneCostTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void iphoneCostShouldBeHigh() {
        int cost = new OnlinerHomePage(driver).
                openHomePage().
                openCatalogPage().
                openMobilePhonesPage().
                chooseApple().
                getFirstMobileCost();
        Assert.assertTrue(cost > 100, "iPhone's cost less then 100 BYN. It's strange");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
