package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StandardizationNewsWCMS extends BasePage {
    public StandardizationNewsWCMS(WebDriver driver) {
        super(driver);
    }

    public By DifferencePodcast = By.xpath("//a[contains(text(),'Biobased Plastic vs. Biodegradable Plastic – What')]");
    public By DifferencePodcastReadMore = By.xpath("//a[contains(@href, 'biobased-plastic-vs-biodegradable-plastic')][2]");
    public By RollerCoastersTechnologyNewHeightsPodcast = By.xpath("//a[contains(text(),'How Roller Coasters Are Using Technology to Reach New Heights – Podcast')]");
    public By RollerCoastersTechnologyNewHeightsPodcastReadMore = By.xpath("//a[text()='Read More' and @href='/news/how-roller-coasters-are-using-technology-to-reach-new-heights-podcast']");
}
