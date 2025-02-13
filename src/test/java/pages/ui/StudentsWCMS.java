package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudentsWCMS extends BasePage{
    public StudentsWCMS(WebDriver driver) {
        super(driver);
    }

    public By ApplyOnline = By.xpath("//a[text()='fill out our easy online application.']");
    public By GraduateScholarship = By.xpath("//a[contains(text(),'Click here for the graduate scholarship application')]");
    public By ProfessorYearAward = By.xpath("//a[contains(text(),'Click here for Professor of the Year nomination fo')]");
    public By MatterScholarship = By.xpath("//a[contains(text(),'Click here for the Katharine and Bryant Mather Sch')]");
    public By ProjectGrants = By.xpath("//a[contains(text(),'Click here for the ASTM grant application form')]");
}
