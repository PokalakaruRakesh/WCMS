package pages.ui;


import base.utils.JsonFileReader;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import com.google.gson.JsonObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WCMSContentPage extends  BasePage {
    public WCMSContentPage(WebDriver driver) {
        super(driver);
    }
    JsonFileReader jsonFileReader =new JsonFileReader();

    private String menu = "(//button[text()='[MENU]'])[2]";
    private String submenu = "(//div[contains(@class,'submenuMain')]/following::a[text()='[SUBMENU]'])[2]";
    private String mainHeader = "//h2[text()='[MAINHEADER]']";
    private String header = "//h4[text()='[HEADER]']";
    private String subheader = "//h6[contains(text(),'[SUBHEADER]')]";
    private String textUnderMainheader = "//h2[text()='[MAINHEADER]']/..//p[text()='[TEXT]']";
    private String textUnderHeader = "//h4[text()='[HEADER]']/..//p[text()='[TEXT]']";
    private String headerUnderMainheader = "//h2[text()='[MAINHEADER]']/..//h6[text()='[HEADER]']";
    private String subheaderUnderHeader = "//h4[text()='[HEADER]']/..//h6[text()='[SUBHEADER]']";
    private String subheaderUnderHeader1 = "//h4[text()='[HEADER]']/..//h4[text()='[SUBHEADER]']";
    private String subheaderUnderMainheader = "//h2[text()='[MAINHEADER]']/..//h2[text()='[SUBHEADER]']";
    private String linkUnderHeader = "//h4[text()='[HEADER]']/..//a[text()='[LINK]']";
    private String buttonUnderHeader = "//h4[text()='[HEADER]']/..//a[text()='[TEXT]']";
    private String buttonUnderSubheader = "//h6[text()='[HEADER]']/..//button[text()='[BUTTON]']";
    private String linkUnderSubheader = "//h6[text()='[HEADER]']/../../a[text()='[LINK]";
    private String linkUnderSubheader1 = "//h6[text()='[HEADER]']/../../following-sibling::div/a[text()='[LINK]']";
    private String textUnderSubheader = "//h6[text()='[SUBHEADER]']/../../div//*[text()='[TEXT]']";
    private String textUnderSubheader1 = "//h4[text()='[SUBHEADER]']/../../div//p[text()='[TEXT]']";
    private String imageTextUnderHeader = "//span[text()='[TEXT1]']/../../following-sibling::div[text()='[TEXT2]']";


    public By getMenu(String menuName) {
        return By.xpath(menu.replace("[MENU]", menuName));
    }
    public By getSubmenu(String submenuName) {
        return By.xpath(submenu.replace("[SUBMENU]", submenuName));
    }
    public By getMainHeader(String mainheader) {
        return By.xpath(mainHeader.replace("[MAINHEADER]", mainheader));
    }

    public By getHeader(String headerName) {
        return By.xpath(header.replace("[HEADER]", headerName));
    }
    public By getsubheader(String subheaderName) {
        return By.xpath(subheader.replace("[HEADER]", subheaderName));
    }

    public By getTextUnderMainheader(String mainheader, String text) {
        return By.xpath(textUnderMainheader.replace("[MAINHEADER]", mainheader).replace("[TEXT]", text));
    }

    public By getSubheaderUnderMainheader(String mainheader, String subheader) {
        return By.xpath(subheaderUnderMainheader.replace("[MAINHEADER]", mainheader).replace("[SUBHEADER]", subheader));
    }

    public By getHeaderUnderMainheader(String mainheader, String header) {
        return By.xpath(headerUnderMainheader.replace("[MAINHEADER]", mainheader).replace("[HEADER]", header));
    }

    public By getSubheaderUnderHeader(String header, String subheader) {
        return By.xpath(subheaderUnderHeader.replace("[HEADER]", header).replace("[SUBHEADER]", subheader));
    }
    public By getSubheaderUnderHeader1(String header, String subheader) {
        return By.xpath(subheaderUnderHeader1.replace("[HEADER]", header).replace("[SUBHEADER]", subheader));
    }

    public By getTextUnderHeader(String header, String text) {
        return By.xpath(textUnderHeader.replace("[HEADER]", header).replace("[TEXT]", text));
    }

    public By getLinkUnderHeader(String header, String link) {
        return By.xpath(linkUnderHeader.replace("[HEADER]", header).replace("[LINK]", link));
    }

    public By getButtonUnderHeader(String header, String text) {
        return By.xpath(buttonUnderHeader.replace("[HEADER]", header).replace("[TEXT]", text));
    }
    public By getButtonUnderSubheader(String header, String button) {
        return By.xpath(buttonUnderSubheader.replace("[HEADER]", header).replace("[BUTTON]", button));
    }

    public By getLinkUnderSubheader(String header, String link) {
        return By.xpath(linkUnderSubheader.replace("[HEADER]", header).replace("[LINK]", link));
    }
    public By getLinkUnderSubheader1(String header, String link) {
        return By.xpath(linkUnderSubheader1.replace("[HEADER]", header).replace("[LINK]", link));
    }

    public By getTextUnderSubheader(String subheader, String text) {
        return By.xpath(textUnderSubheader.replace("[SUBHEADER]", subheader).replace("[TEXT]", text));
    }
    public By getTextUnderSubheader1(String subheader, String text) {
        return By.xpath(textUnderSubheader1.replace("[SUBHEADER]", subheader).replace("[TEXT]", text));
    }

    public By getImageTextUnderHeader(String text1, String text2) {
        return By.xpath(imageTextUnderHeader.replace("[TEXT1]", text1).replace("[TEXT2]", text2));
    }


    @Step("Navigate to page")
    public void NavigateToPage(String menu,String submenu) {
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(getMenu(menu)),10);
            getElement(getMenu(menu)).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.explicitWaitForVisibility(driver,getElement(getSubmenu(submenu)),10);
            getElement(getSubmenu(submenu)).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Step("Get json data")
    public JsonObject jsonData(String JsonfileName, String JsonPrimeElement) {
        JsonObject jsonObject = null;
        try {
            jsonObject=jsonFileReader.readJsonData(JsonfileName,JsonPrimeElement);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to get json data", e);
        }
        return jsonObject;
    }
    @Step("Get json value")
    public String jsonValue(JsonObject jsonObject, String element) {
        String value = null;
        try {
            value=jsonObject.get(element).toString().replace('"',' ').trim();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to get json data", e);
        }
        return value;
    }
}
