package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnvironmentalProductDeclarationsWCMS extends BasePage {

    public EnvironmentalProductDeclarationsWCMS(WebDriver driver) {
        super(driver);
    }

    public static By PCRsEPDsCurrentlyPublished=By.xpath("//a[text()='PCRs and EPDs Currently Published']");
    public static By AboutTheProgram=By.xpath("//a[text()='About the Program']");
    public static By WhyASTM=By.xpath("//a[text()='Why ASTM']");
    public static By ProductCategoryRuleDevelopment=By.xpath("//a[text()='Product Category Rule Development']");
    public static By EPDVerification=By.xpath("//a[text()='EPD Verification Process']");
    public static By FrequentlyAskedQuestions=By.xpath("//a[text()='Frequently Asked Questions']");
    public static By ContactUs=By.xpath("//a[text()='Contact Us']");
    public static By EPDHereLink=By.xpath("//h4[text()='Environmental Product Declarations']/..//a[text()='here']");
    public static By FAQHereLink=By.xpath("//h4[text()='Frequently Asked Questions']/..//a[text()='here']");
    public static By ContactUsMail=By.xpath("//a[text()='cert@astm.org']");


}
