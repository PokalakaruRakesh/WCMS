package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.ui.base.BaseTest;

import java.time.Duration;
import java.util.List;

public class BasePage extends Page {
    public Logger log = Logger.getLogger(BaseTest.class);

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeader(By locator) {
        return getElement(locator).getText();
    }


    @Override
    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            waitForElementPresent(locator);
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Some error occured while creating element" + locator.toString());
            e.getStackTrace();
        }
        return element;
    }

    @Override
    public void waitForElementPresent(By locator) {

        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(locator), 20);
        } catch (Exception e) {
            System.out.println("Some exception occured while waiting for the element" + locator.toString());
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            System.out.println("Some exception occured while waiting for the title" + title);
            System.out.println(e.getStackTrace());
        }

    }

    public List<WebElement> getElements(By locator) {
        try {
            waitForElementPresent(locator);
            return driver.findElements(locator);
        } catch (Exception e) {
            System.out.println("Some error occured while getting list of elements" + locator.toString());
            e.getStackTrace();
            return null;
        }
    }

    public WebElement getElementNew(By locater) {
        new WebDriverWait(driver, 30).pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.visibilityOfElementLocated(locater));
        return driver.findElement(locater);
    }

    public List<WebElement> getElementsNew(By locater) {
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(locater), 30);
        return driver.findElements(locater);
    }

    public WebElement getElementWithoutWait(By locater) {
        return driver.findElement(locater);
    }

    public void clickOnMethod(By locator) {
        try {
            ReusableMethods.scrollIntoView(getElement(locator), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementStaleness(driver, getElement(locator),2);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(locator));
            getElement(locator).click();
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.toString());
        }
    }
}
