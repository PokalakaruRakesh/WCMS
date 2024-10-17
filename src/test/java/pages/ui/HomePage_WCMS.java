package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage_WCMS extends BasePage {

	public HomePage_WCMS(WebDriver driver) {
		super(driver);
	}
	public By learnMoreaboutAstm = By.xpath("//a[@title='Learn More About ASTM ']");
	public By standardizationNews = By.xpath("(//main[contains(@class, 'container-xl')]//a)[1]\n");
}

