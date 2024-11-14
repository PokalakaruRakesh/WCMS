package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketInsightsInnovation_WCMS extends BasePage{
    public MarketInsightsInnovation_WCMS(WebDriver driver) {
        super(driver);
    }
    public By askASTM = By.xpath("//a[contains(@title,'Ask ASTM')]");
    public By contactUs = By.xpath("//a[contains(@title,'Contact Us')]");
    public By getInvolved = By.xpath("//a[contains(@title,'Get Involved')]");

    public By ASTMXcellerate=By.xpath("//a[contains(@href,'https://astmxcellerate.com/')][normalize-space()='Learn More']");
    public By standardizationImpactReport= By.xpath("//a[contains(@href,'https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-0403/t/page/fm/0')][normalize-space()='Learn More']");
    public By MarketIntelligenceWohlersReports= By.xpath("//a[@href='https://wohlersassociates.com/reports/']");
    public By SpecialtyReports= By.xpath("//a[@target='_self'][normalize-space()='Learn More']");

    public By AMCOE= By.xpath("//a[@class='d-block mt-auto' and @href='https://amcoe.org/']");
    public By ETCOE= By.xpath("//a[@class='d-block mt-auto'][normalize-space()='Learn More']");
    public By MarketInsight = By.xpath("//a[@href='/standards-and-solutions/market-insights-and-innovation/market-insights'][normalize-space()='Learn More']");
    public By MarketInnovations = By.xpath("//a[@href='/standards-and-solutions/market-insights-and-innovation/innovation']");
    public By Standards1= By.xpath("//a[contains(text(),'Browse the latest ASTM standards by')]");
    public By Membership= By.xpath("//a[normalize-space()='Join Us']");

}
