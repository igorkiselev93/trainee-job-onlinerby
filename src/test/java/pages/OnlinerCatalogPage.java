package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlinerCatalogPage {

    private WebDriver driver;

    public OnlinerCatalogPage (WebDriver driver){
        this.driver = driver;
    }

    public OnlinerMobilePhonesPage openMobilePhonesPage (){
        // Wait presence of Electronics in catalog navigation and then click on it
        By electronicsSelector = By.xpath(
                "//span[@class='catalog-navigation-classifier__item-title-wrapper'][text()='Электроника']");
        WebElement electronics = new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(electronicsSelector));
        electronics.click();
        // Wait presence of Mobile phones in catalog navigation list and then click on it
        By mobilePhonesSelector = By.xpath(
                "//div[@class='catalog-navigation-list__aside-title'][contains(text(),'Мобильные телефоны')]");
        WebElement mobilePhones = new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(mobilePhonesSelector));
        mobilePhones.click();
        By mobilePhones2Selector = By.xpath(
                "//span[@class='catalog-navigation-list__dropdown-title'][contains(text(),'Мобильные телефоны')]");
        WebElement mobile2Phones = new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(mobilePhones2Selector));
        mobile2Phones.click();
        return new OnlinerMobilePhonesPage(driver);
    }

}
