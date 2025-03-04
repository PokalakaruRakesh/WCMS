package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CopyrightAndPermissionsWCMS extends BasePage {

    public CopyrightAndPermissionsWCMS(WebDriver driver) {
        super(driver);
    }

    public By SinglePDFDownload = By.xpath("//a[text()='Single PDF Download']");
    public By SubscriptionProducts = By.xpath("//a[text()='Subscription Products']");
    public By ASTMTechnicalMail = By.xpath("//a[contains(@href,'khooper@astm')]");
    public By PermissionMail = By.xpath("(//a[contains(@href,'marketplace.copyright')])[1]");

    public By ReturnPolicyWebform = By.xpath("//a[text()='webform']");

    public By ReceiptInvoiceMail = By.xpath("//*[text()='Receipt/Invoice']/..//a[text()='train@astm.org']");
    public By CustomerCancellationMail = By.xpath("//*[contains(text(),'Customer Cancellation')]/following::a[text()='train@astm.org']");
}









