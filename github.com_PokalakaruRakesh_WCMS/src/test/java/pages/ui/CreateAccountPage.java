// ADD THESE NEW METHODS TO EXISTING CLASS - DO NOT MODIFY EXISTING CODE

    /**
     * Complete the Create Account flow as per INT-999.
     * This method covers all test steps: navigation, field entry (valid/invalid), password scenarios, cancel, blank submission, and final valid submission.
     *
     * @param firstName         First Name to enter (valid or invalid)
     * @param middleName        Middle Name to enter
     * @param lastName          Last Name to enter
     * @param organization      Organization/Company to enter
     * @param email             Email to enter (valid or invalid)
     * @param password          Password to enter (weak/strong)
     * @param confirmPassword   Confirm Password to enter (matching/different)
     * @param submit            true to click Submit, false to only fill fields
     * @param clickCancel       true to click Cancel after filling fields
     * @param leaveBlankFields  true to leave required fields blank and click Submit
     */
    public void completeCreateAccountFlow_INT_999(String firstName, String middleName, String lastName, String organization, String email, String password, String confirmPassword, boolean submit, boolean clickCancel, boolean leaveBlankFields) {
        // Navigate to Create Account page is assumed to be handled by the test or navigation utility
        if (!leaveBlankFields) {
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys(firstName);

            driver.findElement(By.id("middlename")).clear();
            driver.findElement(By.id("middlename")).sendKeys(middleName);

            driver.findElement(By.id("lastname")).clear();
            driver.findElement(By.id("lastname")).sendKeys(lastName);

            driver.findElement(By.id("additional_organization")).clear();
            driver.findElement(By.id("additional_organization")).sendKeys(organization);

            driver.findElement(By.id("email_address")).clear();
            driver.findElement(By.id("email_address")).sendKeys(email);

            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);

            driver.findElement(By.id("password-confirmation")).clear();
            driver.findElement(By.id("password-confirmation")).sendKeys(confirmPassword);
        }
        if (clickCancel) {
            driver.findElement(By.xpath("//a[contains(@href, 'https://stage-store.astm.org/')]")).click();
            return;
        }
        if (submit || leaveBlankFields) {
            driver.findElement(By.id("send2")).click();
        }
    }

    /**
     * Checks if the confirmation message is displayed after account creation.
     * The actual locator for the confirmation message should be updated as per the application.
     * @return true if confirmation message is displayed, false otherwise
     */
    public boolean isAccountCreationConfirmationDisplayed() {
        // TODO: Replace with actual locator for confirmation message
        By confirmationMessage = By.xpath("<PLACEHOLDER_CONFIRMATION_MESSAGE>");
        try {
            return driver.findElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
