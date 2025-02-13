package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnniversaryCaseStudiesWCMS extends BasePage {

    public AnniversaryCaseStudiesWCMS(WebDriver driver) {
        super(driver);
    }

    public By AircraftBrakingMeasurements = By.xpath("//h5[contains(text(),'Aircraft Braking Measurements')]/../../a[text()='Learn More']");
    public By AmusementRides = By.xpath("//h5[contains(text(),'Amusement Rides')]/../../a[text()='Learn More'] ");
    public By BabyCribs = By.xpath("//h5[contains(text(),'Baby Cribs')]/../../a[contains(text(),'Learn More')]");
    public By BarrierFaceCoverings = By.xpath("//h5[contains(text(),'Barrier Face Coverings ')]/../../a[contains(text(),'Learn More')]");
    public By BiodegradablePlastic = By.xpath("//h5[contains(text(),'Biodegradable Plastic ')]/../../a[contains(text(),'Learn More')]");
    public By BiodieselFuelBlend = By.xpath("//h5[contains(text(),'Biodiesel Fuel Blend ')]/../../a[contains(text(),'Learn More')]");
    public By Disinfection = By.xpath("//h5[contains(text(),'Disinfection ')]/../../a[contains(text(),'Learn More')]");
    public By Infrastructure = By.xpath("//h5[contains(text(),'Infrastructure')]/../../a[contains(text(),'Learn More')]");
}
