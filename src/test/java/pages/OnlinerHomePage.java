package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlinerHomePage {

    private static final String homePageURL = "https://www.onliner.by/";
    private WebDriver driver;


    public OnlinerHomePage (WebDriver driver){
        this.driver = driver;
    }

    public OnlinerHomePage openHomePage () {
        driver.get(homePageURL);
        return this;
    }

    public OnlinerCatalogPage openCatalogPage (){
        By catalogSelector = By.xpath("//span[@class='b-main-navigation__text'][text()='Каталог']");
        WebElement catalog = new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(catalogSelector));
        catalog.click();
        return new OnlinerCatalogPage(driver);
    }

}
