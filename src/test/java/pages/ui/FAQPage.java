package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FAQPage extends BasePage {
    public FAQPage(WebDriver driver) {
        super(driver);
    }

    public By selectLinkByHeader(String header,String text) {
        return By.xpath(" //button[contains(text(),'"+header+"')]/../..//*[contains(text(),'"+text+"')]/..");}

}
