// ADD THESE NEW METHODS TO EXISTING CLASS - DO NOT MODIFY EXISTING CODE

    /**
     * Complete user flow for 'Learn More About ASTM' scenario (INT-444):
     * 1. Clicks the 'Learn More About ASTM' link
     * 2. Waits for 'About ASTM Overview' header
     * 3. Verifies 'Global ASTM Standards' stat is listed under the header
     *
     * This method encapsulates the full scenario as per the test case.
     * @return true if all validations pass, false otherwise
     */
    public boolean completeLearnMoreAboutASTMFlow() {
        try {
            // Step 1: Click on the 'Learn More About ASTM' link
            By learnMoreAboutASTMLink = By.linkText("Learn More About ASTM");
            waitForElementPresent(learnMoreAboutASTMLink);
            clickOnMethod(learnMoreAboutASTMLink);

            // Step 2: Wait for the 'About ASTM Overview' header to be visible
            By aboutASTMOverviewHeader = By.xpath("//h2[@data-testid='title' and contains(text(),'About ASTM Overview')]");
            waitForElementPresent(aboutASTMOverviewHeader);
            WebElement header = getElement(aboutASTMOverviewHeader);
            if (header == null || !header.isDisplayed()) {
                return false;
            }

            // Step 3: Validate 'Global ASTM Standards' stat is listed under the header
            By globalASTMStandardsStat = By.xpath("//h2[contains(text(),'13,000+')]");
            waitForElementPresent(globalASTMStandardsStat);
            WebElement stat = getElement(globalASTMStandardsStat);
            if (stat == null || !stat.isDisplayed()) {
                return false;
            }

            // Optionally, validate the subtitle text under the stat
            By globalASTMStandardsSubtitle = By.xpath("//h6[@data-testid='title' and contains(text(),'Global ASTM standards')]");
            waitForElementPresent(globalASTMStandardsSubtitle);
            WebElement subtitle = getElement(globalASTMStandardsSubtitle);
            if (subtitle == null || !subtitle.isDisplayed()) {
                return false;
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
