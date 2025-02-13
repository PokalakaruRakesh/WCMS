package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsPage_WCMS extends BasePage {
    public NewsPage_WCMS(WebDriver driver) {
        super(driver);
    }

    public By DifferencePodcast = By.xpath("//a[contains(text(),'Biobased Plastic vs. Biodegradable Plastic – What')]");
    public By DifferencePodcastReadMore= By.xpath("//a[contains(@href, 'biobased-plastic-vs-biodegradable-plastic')][2]");
    public By RollerCoastersTechnologyNewHeightsPodcast= By.xpath("//a[contains(text(),'How Roller Coasters Are Using Technology to Reach New Heights – Podcast')]");
    public By RollerCoastersTechnologyNewHeightsPodcastReadMore= By.xpath("//a[text()='Read More' and @href='/news/how-roller-coasters-are-using-technology-to-reach-new-heights-podcast']");
    // //a[@title='View issue']
    public By Viewissue= By.xpath("//a[@title='View Issue']");
    public By PublicityRequestForm= By.xpath("//a[contains(text(), 'Fill out this form to start the process.')]");
    public By playPauseButtonLocator = By.xpath("//svg[contains(@class, 'play-pause-button')]");

}
