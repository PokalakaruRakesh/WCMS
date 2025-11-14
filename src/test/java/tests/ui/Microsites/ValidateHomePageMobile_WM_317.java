package tests.ui.Microsites;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pages.ui.HomePage_WCMS;
import tests.ui.base.BaseTest;
import utils.JsonFileReader;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class ValidateHomePageMobile_WM_317 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-homepage-mobile-wm-317.json";
    private JSONObject testData;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // Load test data for WM-317
        try {
            testData = JsonFileReader.getTestData(TEST_DATA_PATH, "WM-317");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load test data for WM-317");
        }
    }

    @Test(description = "WM-317: Microsites|| Functional || Release 1 ||Mobile :Validate Home Page – Content, Assets, Navigation, and Components")
    @Description("Validate that the home page on mobile matches the approved document for content, assets, navigation, and components.")
    @Severity(SeverityLevel.CRITICAL)
    public void validateHomePageMobile_WM_317() {
        try {
            HomePage_WCMS homePage = page.getInstance(HomePage_WCMS.class);

            // Extract expected texts
            List<String> expectedTexts = new ArrayList<>();
            JSONArray testDataArray = (JSONArray) testData.get("TestData");
            if (testDataArray != null) {
                for (Object obj : testDataArray) {
                    JSONObject scenario = (JSONObject) obj;
                    if (scenario.containsKey("expectedText")) {
                        expectedTexts.add((String) scenario.get("expectedText"));
                    }
                    if (scenario.containsKey("expectedBlocks")) {
                        JSONArray blocks = (JSONArray) scenario.get("expectedBlocks");
                        for (Object block : blocks) {
                            expectedTexts.add((String) block);
                        }
                    }
                }
            }

            // Extract expected asset URLs
            List<String> expectedAssetUrls = new ArrayList<>();
            if (testDataArray != null) {
                for (Object obj : testDataArray) {
                    JSONObject scenario = (JSONObject) obj;
                    if (scenario.containsKey("expectedImageUrl")) {
                        expectedAssetUrls.add((String) scenario.get("expectedImageUrl"));
                    }
                    if (scenario.containsKey("asset")) {
                        expectedAssetUrls.add((String) scenario.get("asset"));
                    }
                }
            }

            // Extract expected navigation links
            List<String> expectedNavigationLinks = new ArrayList<>();
            if (testDataArray != null) {
                for (Object obj : testDataArray) {
                    JSONObject scenario = (JSONObject) obj;
                    if (scenario.containsKey("expectedMenuItems")) {
                        JSONArray menuItems = (JSONArray) scenario.get("expectedMenuItems");
                        for (Object item : menuItems) {
                            expectedNavigationLinks.add((String) item);
                        }
                    }
                    if (scenario.containsKey("expectedFooterLinks")) {
                        JSONArray footerLinks = (JSONArray) scenario.get("expectedFooterLinks");
                        for (Object linkObj : footerLinks) {
                            JSONObject link = (JSONObject) linkObj;
                            if (link.containsKey("label")) {
                                expectedNavigationLinks.add((String) link.get("label"));
                            }
                        }
                    }
                }
            }

            // Extract expected component selectors (using By)
            List<By> expectedComponentSelectors = new ArrayList<>();
            JSONArray locators = (JSONArray) testData.get("Locators");
            if (locators != null) {
                for (Object obj : locators) {
                    JSONObject locator = (JSONObject) obj;
                    String locatorType = (String) locator.get("locatorType");
                    String locatorValue = (String) locator.get("locatorValue");
                    if (locatorType != null && locatorValue != null) {
                        switch (locatorType.toLowerCase()) {
                            case "xpath":
                                expectedComponentSelectors.add(By.xpath(locatorValue));
                                break;
                            case "css":
                                expectedComponentSelectors.add(By.cssSelector(locatorValue));
                                break;
                            case "id":
                                expectedComponentSelectors.add(By.id(locatorValue));
                                break;
                            case "name":
                                expectedComponentSelectors.add(By.name(locatorValue));
                                break;
                            case "class":
                                expectedComponentSelectors.add(By.className(locatorValue));
                                break;
                            default:
                                // Ignore unknown types
                                break;
                        }
                    }
                }
            }

            // Call the comprehensive Page Object method
            homePage.validateHomePageContentAndLayout(
                expectedTexts,
                expectedAssetUrls,
                expectedNavigationLinks,
                expectedComponentSelectors
            );
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Test failed due to exception: " + e.getMessage();
        }
    }
}
