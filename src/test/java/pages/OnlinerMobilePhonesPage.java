package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlinerMobilePhonesPage {

    private WebDriver driver;

    public OnlinerMobilePhonesPage (WebDriver driver){
        this.driver = driver;
    }

    public OnlinerMobilePhonesPage chooseApple(){
        // Wait presence of Filter-control manufacturer and then click on it
        By manufacturerSelector = By.xpath(
                "//span[text()='Производитель']/../following-sibling::div[1]//div[@class='schema-filter-control__item']");
        WebElement manufacturer = new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(manufacturerSelector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manufacturer);
        manufacturer.click();
        // Wait presence of Apple checkbox and then click on it
        By checkboxSelector = By.xpath("//span[@class='schema-filter__checkbox-text'][text()='Apple']");
        WebElement checkbox = new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(checkboxSelector));
        checkbox.click();
        // Click on manufacturer to hide that block
        manufacturer.click();
        return this;
    }

    public int getFirstMobileCost () {
        // Wait presence of search results and then get cost of first mobile
        By costOfFirstMobileSelector = By.cssSelector(
                ".schema-product__group:nth-child(1) >div:nth-child(1) > .schema-product__part_2:nth-child(2) > div:nth-child(1) .schema-product__price span");
        WebElement costOfFirstMobile = new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(costOfFirstMobileSelector));

        // Get cost of first mobile and compare it
        int cost = Integer.parseInt(costOfFirstMobile.getText().split(",")[0]);
        return cost;
    }
}
