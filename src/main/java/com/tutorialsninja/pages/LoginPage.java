package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    //Declaring WebElement type variables
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButtonLogout;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddress;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement loginButton;

    //This method will get text
    public String getReturningCustomerText() {
        Reporter.log("The Returning Customer Text is " + returningCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "The Returning Customer Text is " + returningCustomerText.getText());
        return getTextFromElement(returningCustomerText);
    }
    //This method will get text
    public String getAccountLogoutText() {
        Reporter.log("The Logout Account Text is " + accountLogoutText.toString());
        CustomListeners.test.log(Status.PASS, "The Logout Account Text is " + accountLogoutText.getText());
        return getTextFromElement(accountLogoutText);
    }
    //This method will click on continue button
    public void clickOnContinueButtonLogout() {
        Reporter.log("Click on Continue Button " + continueButtonLogout.toString());
        clickOnElement(continueButtonLogout);
        CustomListeners.test.log(Status.PASS, "Click on Continue Button");

    }
    //This method will send text to email field
    public void sendTextToEmailAddressField(String emailId) {
        sendTextToElement(emailAddress, emailId);
    }
    //This method will send text to password field
    public void sendTextToPasswordField(String lPassword) {
        sendTextToElement(password, lPassword);
    }
    //This method will click on Login button
    public void clickOnLoginButton() {
        Reporter.log("Click on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on Login Button ");

    }
}
