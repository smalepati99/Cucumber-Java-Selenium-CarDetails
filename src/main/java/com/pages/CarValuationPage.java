package com.pages;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CarValuationPage {

    private WebDriver driver;

    // 1. By Locators
    private By valuationPageHeader = By.cssSelector("[data-test-id='fullWidthHeading1']");
    private By acceptCookiesBtn = By.cssSelector("[class='sc-mqi3p7-0 gihvmi']");
    private By regTextBox = By.id("vrm");
    private By submitBtn = By.cssSelector("[class='sc-mqi3p7-0 iPGgoA']");
    private By carDetailsText = By.xpath("//*[@class='sc-bYMpWt gWpvVJ' or @class='sc-1s46il7-1 fPxaEb']");
    private By carNotFoundErrMsg = By.xpath("[//*[@id='your-registration-number-form']/div/div[1]/span");
    private By carRegNumber = By.xpath("//*[text()='Reg' or @class='sc-1s46il7-1 fPxaEb']");
    private By carMakeModel = By.xpath("//*[text()='Make/model' or @class='sc-1s46il7-1 fPxaEb']");

    // 2. Constructor of the page class
    public CarValuationPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of page in the form of methods

    public void enterRegistrationNumber(String regNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(regTextBox)).isDisplayed();
        driver.findElement(regTextBox).sendKeys(regNumber);
    }

    public void clickAcceptCookies() {
        if (driver.findElements(acceptCookiesBtn).size() > 0) {
            driver.findElement(acceptCookiesBtn).click();
        } else {
            System.out.println("Accept Cookies button is not displaying at the moment");
        }
    }

    public void clickSubmitBtn() {
        driver.findElement(submitBtn).click();
    }

    public String getCarDetailsText() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(carDetailsText)).isDisplayed();
        return driver.findElement(carDetailsText).getText();
    }

    public String getCarValuationPageHeader() {
        return driver.findElement(valuationPageHeader).getText();
    }

    public void getCarValuation(String reg, List<String> detailsOnWeb) {
        ConfigReader configReader = new ConfigReader();
        String baseurl = configReader.getApplicationUrl();
        DriverFactory.getDriver().get(baseurl);
        clickAcceptCookies();
        enterRegistrationNumber(reg);
        clickSubmitBtn();
        detailsOnWeb.add(getCarDetailsText());

    }
}
