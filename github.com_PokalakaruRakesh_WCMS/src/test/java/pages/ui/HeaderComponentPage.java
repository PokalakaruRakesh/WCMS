// ADD THESE NEW METHODS TO EXISTING CLASS - DO NOT MODIFY EXISTING CODE

    // Locators for actual header components as per UI and provided locators
    private By astmLogo = By.xpath("//img[contains(@class, 'astm-logo')]");
    private By homeLink = By.linkText("Home");
    private By aboutAstmButton = By.xpath("//button[contains(text(),'About ASTM')]");
    private By membershipParticipationButton = By.xpath("//button[contains(text(),'Membership & Participation')]");
    private By standardsSolutionsButton = By.xpath("//button[contains(text(),'Standards & Solutions')]");
    private By newsButton = By.xpath("//button[contains(text(),'News')]");
    private By helpButton = By.xpath("//button[contains(text(),'Help')]");
    private By faqLink = By.linkText("FAQ");

    /**
     * Validates that all main header components are displayed after login.
     * This is a comprehensive method for INT-123: validate header components.
     * Throws AssertionError if any component is missing.
     */
    public void validateAllHeaderComponentsVisible() {
        waitForElementPresent(astmLogo);
        if (!getElement(astmLogo).isDisplayed()) {
            throw new AssertionError("ASTM Logo is not displayed in header");
        }
        waitForElementPresent(homeLink);
        if (!getElement(homeLink).isDisplayed()) {
            throw new AssertionError("Home link is not displayed in header");
        }
        waitForElementPresent(aboutAstmButton);
        if (!getElement(aboutAstmButton).isDisplayed()) {
            throw new AssertionError("About ASTM button is not displayed in header");
        }
        waitForElementPresent(membershipParticipationButton);
        if (!getElement(membershipParticipationButton).isDisplayed()) {
            throw new AssertionError("Membership & Participation button is not displayed in header");
        }
        waitForElementPresent(standardsSolutionsButton);
        if (!getElement(standardsSolutionsButton).isDisplayed()) {
            throw new AssertionError("Standards & Solutions button is not displayed in header");
        }
        waitForElementPresent(newsButton);
        if (!getElement(newsButton).isDisplayed()) {
            throw new AssertionError("News button is not displayed in header");
        }
        waitForElementPresent(helpButton);
        if (!getElement(helpButton).isDisplayed()) {
            throw new AssertionError("Help button is not displayed in header");
        }
        waitForElementPresent(faqLink);
        if (!getElement(faqLink).isDisplayed()) {
            throw new AssertionError("FAQ link is not displayed in header");
        }
    }

    // Locators for header components based on provided locators and HTML
    private By aboutASTMButton = By.xpath("//button[text()='About ASTM']");
    private By submenuCloseButton = By.xpath("//button[@data-testid='collapse-submenu-button']");

    /**
     * Comprehensive method to validate all main header components are displayed
     * as per INT-555: User should be able to see the header components successfully
     */
    public boolean validateAllHeaderComponentsDisplayed() {
        boolean allDisplayed = true;
        waitForElementPresent(homeLink);
        allDisplayed &= getElement(homeLink).isDisplayed();

        waitForElementPresent(aboutASTMButton);
        allDisplayed &= getElement(aboutASTMButton).isDisplayed();

        waitForElementPresent(membershipParticipationButton);
        allDisplayed &= getElement(membershipParticipationButton).isDisplayed();

        waitForElementPresent(standardsSolutionsButton);
        allDisplayed &= getElement(standardsSolutionsButton).isDisplayed();

        waitForElementPresent(newsButton);
        allDisplayed &= getElement(newsButton).isDisplayed();

        waitForElementPresent(helpButton);
        allDisplayed &= getElement(helpButton).isDisplayed();

        waitForElementPresent(faqLink);
        allDisplayed &= getElement(faqLink).isDisplayed();

        return allDisplayed;
    }

    /**
     * Clicks the submenu close button in the header (if visible)
     */
    public void clickSubmenuCloseButton() {
        waitForElementPresent(submenuCloseButton);
        clickOnMethod(submenuCloseButton);
    }