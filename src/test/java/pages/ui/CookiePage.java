package pages.ui;

import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiePage extends BasePage {

	public CookiePage(WebDriver driver) {
		super(driver);
	}
	public By cookieAcceptAllBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public void handleOneTrustCookie() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(cookieAcceptAllBtn));
			Common.clickonWebElement(driver, cookieAcceptAllBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
