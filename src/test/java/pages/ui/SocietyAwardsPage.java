package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SocietyAwardsPage extends BasePage {
    public SocietyAwardsPage(WebDriver driver) {
        super(driver);
    }

    public By societyAwardsLink = By.xpath("//a[contains(text(),'Learn more about Society Awards')]");
    public By staffContactMail = By.xpath("//a[text()='mzamorski@astm.org']");
    public By awardOfMerit = By.xpath("//button[text()='Award Of Merit']");
    public By awardOfMeritLink = By.xpath("//a[text()='Award of Merit Guidelines PDF']");
    public By cavanaughMemorialAward = By.xpath("//button[text()='W.T. Cavanaugh Memorial Award']");
    public By cavanaughMemorialAwardLink = By.xpath("//a[text()='W.T. Cavanaugh Memorial Award Guidelines PDF']");
    public By dudleyMedalAward = By.xpath("//button[text()='Charles B. Dudley Medal Award']");
    public By dudleyMedalAwardLink = By.xpath("//a[text()='Charles B. Dudley Medal Award Guidelines PDF']");
    public By journalTesting = By.xpath("//button[text()='Journal of Testing and Evaluation Award']");
    public By journalTestingLink = By.xpath("//a[text()='Journal of Testing and Evaluation Award Guidelines PDF']");
    public By painterMemorialAward = By.xpath("//button[text()='Robert J. Painter Memorial Award']");
    public By painterMemorialAwardLink = By.xpath("//a[text()='Robert J. Painter Memorial Award Guidelines PDF']");
    public By thomasPresident = By.xpath("//button[contains(text(),'James A. Thomas President')]");
    public By thomasPresidentLink = By.xpath("//a[contains(text(),'James A. Thomas President')]");
    public By vossAward = By.xpath("//button[text()='Walter C. Voss Award']");
    public By vossAwardLink = By.xpath("//a[text()='Walter C. Voss Award Guidelines PDF']");
    public By gumpertzAward = By.xpath("//button[text()='Werner H. Gumpertz Award']");
    public By gumpertzAwardLink = By.xpath("//a[text()='Werner H. Gumpertz Award Guidelines PDF']");
}
