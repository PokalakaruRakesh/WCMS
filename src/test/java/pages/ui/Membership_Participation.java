package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Membership_Participation extends BasePage {
    public Membership_Participation(WebDriver driver) {
        super(driver);
    }

//How to Get Involved Page
    public By BecomeASTMMember = By.xpath("//a[contains(text(),'Become an ASTM member')]");
    public By RequestFinancialAssistance = By.xpath("//a[contains(text(),'Request Financial Assistance')]");




}
