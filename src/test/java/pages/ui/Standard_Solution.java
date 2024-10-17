package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Standard_Solution {

    // Standard and Solution
    public By getstandardandSolution = By.xpath("(//header//button[contains(text(), 'Standards & Solutions')])[last()]\n");
    public By viewStandardbtn = By.xpath("//main//div[2]//div[2]//a[position()=1]");
    public By findIndividaulStandardbtn = By.xpath("//*[contains(text(),'Find an individual standard')]");
    public By laboratoryServicesLearnmore = By.xpath("//div[6]//a[contains(text(), 'Learn More')]");

}
