package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    //Declaring WebElement type variables
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(name = "firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneNo;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/form/fieldset[3]/div/div//label[1]/input")
    WebElement subscribeButtonYes;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/form/fieldset[3]/div/div//label[2]/input")
    WebElement subscribeButtonNo;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacyButton;
    @CacheLookup
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedMessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButtonAfterAccountCreation;
    //this method will get text
    public String getRegisterAccountText() {
        Reporter.log("The Register Account Text is " + registerAccountText.toString());
        CustomListeners.test.log(Status.PASS, "The Register Account Text is " + registerAccountText.getText());
        return getTextFromElement(registerAccountText);
    }
    //this method will send text to first name field
    public void sendTextFirstNameField(String fName) {
        Reporter.log("Enter user first name " + fName + " to First Name field " + firstName.toString());
        sendTextToElement(firstName, fName);
        CustomListeners.test.log(Status.PASS, "Entered  first name " + fName);

    }
    //this method will send text to last name field
    public void sendTextLastNameField(String lName) {
        Reporter.log("Enter user last name " + lName + " to Last Name field " + lastName.toString());
        sendTextToElement(lastName, lName);
        CustomListeners.test.log(Status.PASS, "Entered  last name " + lName);

    }
    //this method will send text to email field
    public void sendTextEmailField(String rEmail) {
        Reporter.log("Enter user email " + rEmail + " to Email field " + email.toString());
        sendTextToElement(email, rEmail + getAlphaNumericString(2) + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Entered email is " + rEmail);

    }
    //this method will send text to telephone field
    public void sendTexTelephoneField(String telep) {
        Reporter.log("Enter telephone number " + telep + " to Telephone Number field " + telephoneNo.toString());
        sendTextToElement(telephoneNo, telep);
        CustomListeners.test.log(Status.PASS, "Entered  Telephone Number is " + telep);

    }
    //this method will send text to password field
    public void sendTextPasswordField(String pass) {
        Reporter.log("Enter password " + pass + " to Password field " + password.toString());
        sendTextToElement(password, pass);
        CustomListeners.test.log(Status.PASS, "Entered  password is " + pass);

    }
    //this method will send text to confirm password field
    public void sendTextConfirmPasswordField(String cirPass) {
        Reporter.log("Enter password again " + cirPass + " to Confirm Password field " + confirmPassword.toString());
        sendTextToElement(confirmPassword, cirPass);
        CustomListeners.test.log(Status.PASS, "Entered  confirm Password is " + cirPass);

    }
    //this method will click on subscribe button box
    public void selectSubscribeButtons(String op) {
        Reporter.log("Select Subscribe Option" + password.toString());
        if (op.equalsIgnoreCase("Yes")) {
            clickOnElement(subscribeButtonYes);
        } else if (op.equalsIgnoreCase("No")) {
            clickOnElement(subscribeButtonNo);
        }
        CustomListeners.test.log(Status.PASS, "Selected Subscribe Option is " + op);
    }
    //this method will click on privacy button
    public void clickOnPrivacyButton() {
        Reporter.log("Clicking on continue Button in guest section " + privacyButton.toString());
        clickOnElement(privacyButton);
        CustomListeners.test.log(Status.PASS, "Clicking on Privacy Button in Registration section ");
    }
    //this method will click on continue button
    public void clickOnContinueButton() {
        Reporter.log("Clicking on continue Button in guest section " + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Clicking on Continue Button in Registration section  ");

    }
    //this method will get text
    public String getAccountCreatedMessage() {
        Reporter.log("The Account Created Text is " + accountCreatedMessage.toString());
        CustomListeners.test.log(Status.PASS, "The Account Created Text is" + accountCreatedMessage.getText());
        return getTextFromElement(accountCreatedMessage);
    }
    //this method will click on continue button
    public void clickOnContinueButtonAfterAccountCreation() {
        Reporter.log("Clicking on continue Button in guest section " + continueButtonAfterAccountCreation.toString());
        clickOnElement(continueButtonAfterAccountCreation);
        CustomListeners.test.log(Status.PASS, "Clicking on Continue Button After Registration is complete ");

    }

}
