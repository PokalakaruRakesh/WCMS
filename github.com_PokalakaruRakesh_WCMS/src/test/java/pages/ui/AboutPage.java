// ADD THESE NEW METHODS TO EXISTING CLASS - DO NOT MODIFY EXISTING CODE

    /**
     * Complete flow for 'Learn More About ASTM' scenario (INT-444):
     *  - Clicks 'Learn More About ASTM' button
     *  - Verifies 'About ASTM Overview' header is visible
     *  - Validates that 'Global ASTM Standards' is listed under the header
     *
     * This method encapsulates the full user flow for INT-444 as per Page Object design rules.
     *
     * @return true if the expected content is present, false otherwise
     */
    public boolean completeLearnMoreAboutASTMFlow() {
        // Locator for 'Learn More About ASTM' button
        By learnMoreAboutASTMButton = By.linkText("Learn More About ASTM ");
        // Locator for 'About ASTM Overview' header
        By aboutASTMOverviewHeader = By.xpath("//h2[@class='styles_mainTitle__RuNUL text-left title' and text()='About ASTM Overview']");
        // Locator for 'Global ASTM Standards' count (h2 with text '13,000+')
        By astmStandardsCount = By.xpath("//h2[text()='13,000+']");
        // Locator for 'Global ASTM standards' subtitle
        By globalASTMStandardsSubtitle = By.xpath("//h6[text()='Global ASTM standards']");

        try {
            // Click 'Learn More About ASTM' button if present
            waitForElementPresent(learnMoreAboutASTMButton);
            clickOnMethod(learnMoreAboutASTMButton);

            // Wait for 'About ASTM Overview' header
            waitForElementPresent(aboutASTMOverviewHeader);
            if (!getElement(aboutASTMOverviewHeader).isDisplayed()) {
                return false;
            }

            // Check that '13,000+' is present (ASTM standards count)
            waitForElementPresent(astmStandardsCount);
            if (!getElement(astmStandardsCount).isDisplayed()) {
                return false;
            }

            // Check that 'Global ASTM standards' subtitle is present under the count
            waitForElementPresent(globalASTMStandardsSubtitle);
            if (!getElement(globalASTMStandardsSubtitle).isDisplayed()) {
                return false;
            }

            return true;
        } catch (Exception e) {
            // Optionally log the exception
            return false;
        }
    }
