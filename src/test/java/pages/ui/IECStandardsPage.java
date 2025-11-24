package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;
import java.util.Arrays;
import java.util.List;

public class IECStandardsPage extends BasePage {

    public IECStandardsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By mainPageHeading = By.xpath("//h2[contains(@class,'infoBanner_title__9abIf') and text()='IEC Standards']");
    private By section1Heading = By.xpath("//h3[text()='What is International Electrotechnical Commission (IEC)?']");
    private By section2Heading = By.xpath("//h3[text()='Digital and PDF Access to IEC Standards']");
    private By section3Heading = By.xpath("//h3[text()='Create a Technical Document Library']");
    private By categorySectionHeading = By.xpath("//h2[contains(@class,'textCard_certificationHeading__Fm1OE') and text()='IEC Standards By Category']");
    private By footerHeading = By.xpath("//h2[contains(@class,'infoBanner_title__9abIf') and text()='For more information']");

    private By contactUsButton1 = By.xpath("//a[text()='Contact Us'][@href='/contact-us']");
    private By meetWithASTMRepButton = By.xpath("//a[text()='Meet with an ASTM representative']");
    private By learnMoreCompassButton = By.xpath("//a[text()='Learn More about ASTM Compass']");
    private By contactUsButton2 = By.xpath("//a[text()='Contact Us'][@href='https://www.astm.org/standards-and-solutions/enterprise-solutions/salesforce']");
    private By emailLink = By.xpath("//a[@href='mailto:sales@astm.org']");

    // Navigation Locators
    private By standardsNavButton = By.xpath("//button[@title='Standards']");
    private By iecStandardsLink = By.xpath("//a[text()='IEC Standards' and @href='/standards/iec']");

    @Step("Validate IEC Standards page headers, buttons, and links as per WM-333")
    public void validateIECStandardsPageContent() {
        // Wait for and validate URL
        WaitStatementUtils.waitForUrlContains(driver, "/standards/iec", 15);
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.equals("https://qa-regional.astm.org/standards/iec")) {
            throw new AssertionError("Expected IEC Standards page URL not loaded. Actual: " + currentUrl);
        }

        // Validate headers in order
        List<By> expectedHeaders = Arrays.asList(
                mainPageHeading,
                section1Heading,
                section2Heading,
                section3Heading,
                categorySectionHeading,
                footerHeading
        );
        List<String> expectedHeaderTexts = Arrays.asList(
                "IEC Standards",
                "What is International Electrotechnical Commission (IEC)?",
                "Digital and PDF Access to IEC Standards",
                "Create a Technical Document Library",
                "IEC Standards By Category",
                "For more information"
        );
        for (int i = 0; i < expectedHeaders.size(); i++) {
            WebElement headerElement = getElement(expectedHeaders.get(i));
            String actualText = headerElement.getText().trim();
            if (!actualText.equals(expectedHeaderTexts.get(i))) {
                throw new AssertionError("Header text mismatch at index " + i + ". Expected: '" + expectedHeaderTexts.get(i) + "', Actual: '" + actualText + "'");
            }
        }

        // Validate buttons/links below headers
        // Contact Us below Section 1
        WebElement contactUs1 = getElement(contactUsButton1);
        if (!contactUs1.isDisplayed() || !contactUs1.isEnabled()) {
            throw new AssertionError("Contact Us button (Section 1) not visible/clickable");
        }
        // Meet with ASTM representative below Section 2
        WebElement meetRep = getElement(meetWithASTMRepButton);
        if (!meetRep.isDisplayed() || !meetRep.isEnabled()) {
            throw new AssertionError("Meet with an ASTM representative button not visible/clickable");
        }
        // Learn More about ASTM Compass below Section 3
        WebElement learnMoreCompass = getElement(learnMoreCompassButton);
        if (!learnMoreCompass.isDisplayed() || !learnMoreCompass.isEnabled()) {
            throw new AssertionError("Learn More about ASTM Compass button not visible/clickable");
        }
        // Contact Us in Footer
        WebElement contactUs2 = getElement(contactUsButton2);
        if (!contactUs2.isDisplayed() || !contactUs2.isEnabled()) {
            throw new AssertionError("Contact Us button (Footer) not visible/clickable");
        }
        // Email link in Footer
        WebElement email = getElement(emailLink);
        if (!email.isDisplayed()) {
            throw new AssertionError("sales@astm.org email link not visible");
        }
    }

    @Step("Navigate to IEC Standards page via main menu")
    public void navigateToIECStandardsPage() {
        clickOnMethod(standardsNavButton);
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(iecStandardsLink), 10);
        clickOnMethod(iecStandardsLink);
        WaitStatementUtils.waitForUrlContains(driver, "/standards/iec", 15);
    }
}
