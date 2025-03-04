package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tracker_ServicesWCMS extends BasePage {

    public Tracker_ServicesWCMS(WebDriver driver){ super(driver);}

    public By loginTrackerAccount = By.xpath("//a[contains(text(),'log in to your Tracker Account')]");
    public By clickhere = By.xpath("//a[contains(text(),'click here')]");

}
