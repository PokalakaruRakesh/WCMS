package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmergingProfessionalsProgramWCMS extends BasePage {

    public EmergingProfessionalsProgramWCMS(WebDriver driver) {
        super(driver);
    }

    public static By videolink=By.xpath("//a[text()='Emerging Professionals Program']']");
    public static WebElement getVideoLink(){
        return  driver.findElement(videolink);
    }
    public static By Nominationform= By.xpath("//a[contains(text(),'Click here for a nomination form')]");
}
