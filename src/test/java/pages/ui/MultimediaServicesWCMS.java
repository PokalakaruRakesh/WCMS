package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultimediaServicesWCMS extends BasePage {

    public MultimediaServicesWCMS(WebDriver driver) {
        super(driver);
    }

    public By RequestAppointment= By.xpath("//a[@title='Request an Appointment']");
    public By QuickGuide= By.xpath("//a[@title='Quick Guide']");
    public By ContactMultimediaTeam = By.xpath("//a[@title='Contact the Multimedia Team']");
}
