package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AboutPage extends BasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getLearnMoreLinksUnderTiles(String section){
        return driver.findElements(By.xpath("//h4[text()='"+section+"']/../div//a[text()='Learn More']"));
    }
    public By viewOpenOpportunitiesLink = By.xpath("//a[@title='VIEW OPEN OPPORTUNITIES']");
    public By interactiveTimelineLink = By.xpath("//a[@title='Interactive Timeline']");
    public By viewBtnUnderHistory = By.xpath("//a[@title='View']");
    public By learnMoreBtnUnderGlobalCooperation = By.xpath("//h4[text()='Global Cooperation']/../a[text()='Learn More']");

    public By viewBtnUnderGovernance= By.xpath("//a[@title='VIEW']");
    public By governanceBoardOfdirectors= By.xpath("//h4[text()='Governance']/../div//a[text()='Learn More']");


    public By videoLink = By.xpath("(//iframe[@title='Video'])[1]");
    public WebElement getVideoLink(){
        return  driver.findElement(videoLink);
    }
}
