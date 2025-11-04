// ADD THESE NEW METHODS TO EXISTING CLASS - DO NOT MODIFY EXISTING CODE

    /**
     * Performs the Create Account flow for INT-999 test case, handling both valid and invalid input scenarios as per the test case description.
     * This method covers:
     * - Entering valid/invalid First Name, Middle Name, Last Name, Organization, Email, Password, Confirm Password
     * - Submitting the form
     * - Handling Cancel action
     * - Leaving required fields blank and submitting
     *
     * @param firstName         First Name input (valid or invalid)
     * @param middleName        Middle Name input
     * @param lastName          Last Name input
     * @param organization      Organization/Company input
     * @param email             Email input (valid or invalid)
     * @param password          Password input (weak or strong)
     * @param confirmPassword   Confirm Password input (matching or not)
     * @param submit            If true, submits the form; if false, clicks Cancel
     */
    public void completeCreateAccountFlow(
            String firstName,
            String middleName,
            String lastName,
            String organization,
            String email,
            String password,
            String confirmPassword,
            boolean submit
    ) {
        // Fill First Name
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(firstName);

        // Fill Middle Name
        driver.findElement(By.id("middlename")).clear();
        driver.findElement(By.id("middlename")).sendKeys(middleName);

        // Fill Last Name
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys(lastName);

        // Fill Organization
        driver.findElement(By.id("additional_organization")).clear();
        driver.findElement(By.id("additional_organization")).sendKeys(organization);

        // Fill Email
        driver.findElement(By.id("email_address")).clear();
        driver.findElement(By.id("email_address")).sendKeys(email);

        // Fill Password
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        // Fill Confirm Password
        driver.findElement(By.id("password-confirmation")).clear();
        driver.findElement(By.id("password-confirmation")).sendKeys(confirmPassword);

        if (submit) {
            // Click Create Account button
            driver.findElement(By.xpath("//button[@title='Create Account']")).click();
        } else {
            // Click Cancel link
            driver.findElement(By.linkText("Cancel")).click();
        }
    }

    /**
     * Checks if the confirmation message is displayed after successful account creation.
     * @return true if confirmation message is visible, false otherwise
     */
    public boolean isConfirmationMessageDisplayed() {
        // Placeholder: Update with actual confirmation message locator if available
        By confirmationMessage = By.xpath("//div[contains(@class,'message-success') or contains(text(),'Thank you for registering')]");
        try {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(confirmationMessage), 10);
            return driver.findElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
