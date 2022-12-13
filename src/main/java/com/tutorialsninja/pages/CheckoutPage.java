package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {

    //Declaring WebElement type variables
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkoutText;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group']/div[1]/div[2]/div/div/div[1]/div[2]/label/input")
    WebElement guestCheckBox;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephone;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcode;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;
    @CacheLookup
    @FindBy(css = "#button-guest")
    WebElement guestContinueButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group']/div[3]/div[2]/div[1]/p[2]/textarea[1]")
    WebElement commentField;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement termAndConditionsCheckBox;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonInCommentSection;
    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group']/div[3]/div[2]/div/div[1]")
    WebElement paymentErrorMessage;

    //This method will get check out text
    public String getCheckOutPageText() {
        Reporter.log("The Checkout Text is " + checkoutText.toString());
       CustomListeners.test.log(Status.PASS, "The checkout Text is " + checkoutText.getText());
        return getTextFromElement(checkoutText);
    }
    //This method will get New Customer text
    public String getNewCustomerText() {
        Reporter.log("The New Customer Text is " + newCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "The New Customer Text is " + newCustomerText.getText());
        return getTextFromElement(newCustomerText);
    }
    //This method click on Guest checkout button
    public void clickOnGuestCheckout() {
        Reporter.log("Click on guest checkout  Button " + guestCheckBox.toString());
        clickOnElement(guestCheckBox);
        CustomListeners.test.log(Status.PASS, "Click on guest checkout Button");

    }
    //This method will click on continue button
    public void clickOnContinueButton() {
        Reporter.log("Clicking on continue Button " + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue Button");

    }
    //This method will send text to first name field
    public void sendTextToFirstNameField(String fName) {
        Reporter.log("Enter user first name " + fName + " to firstname field " + firstName.toString());
        sendTextToElement(firstName, fName + getAlphaNumericString(2));
        CustomListeners.test.log(Status.PASS, "Entered  first name " + fName);

    }
    //This method will send text to last name field
    public void sendTextToLastNameField(String lname) {
        Reporter.log("Enter user last name " + lname + " to lastname field " + lastName.toString());
        sendTextToElement(lastName, lname + getAlphaNumericString(2));
        CustomListeners.test.log(Status.PASS, "Entered last name " + lname);

    }
    //This method will send text to email field
    public void sendTextToEmailField(String uEmail) {
        Reporter.log("Enter user email " + uEmail + " to email field " + email.toString());
        sendTextToElement(email, uEmail + getAlphaNumericString(2) + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Entered user email " + uEmail);

    }
    //This method will send text to telephone number field
    public void sendTextToTelephoneField(String tele) {
        Reporter.log("Enter telephone number " + tele + " to Telephone Number field " + telephone.toString());
        sendTextToElement(telephone, tele);
        CustomListeners.test.log(Status.PASS, "Entered telephone number " + tele);

    }
    //This method will send text to address field
    public void sendTextToAddressField(String add) {
        Reporter.log("Enter Address " + add + " to Address field " + address.toString());
        sendTextToElement(address, add);
        CustomListeners.test.log(Status.PASS, "Entered Address " + add);

    }
    //This method will send text to city name field
    public void sendTextToCityField(String uCty) {
        Reporter.log("Enter city name " + uCty + " to City name field " + city.toString());
        sendTextToElement(city, uCty);
        CustomListeners.test.log(Status.PASS, "Entered city name " + uCty);

    }
    //This method will send text to postcode field
    public void sendTextToPostCOdeField(String pCode) {
        Reporter.log("Enter postcode " + pCode + " to username field " + postcode.toString());
        sendTextToElement(postcode, pCode + getAlphaNumericString(1));
        CustomListeners.test.log(Status.PASS, "Entered postcode " + pCode);

    }
    //This method will select text country field
    public void selectCountry(String uCountry) {
        Reporter.log("Select country " + uCountry + " to Country field " + country.toString());
        selectByVisibleTextFromDropDown(country, uCountry);
        CustomListeners.test.log(Status.PASS, "Selected country " + uCountry);

    }
    //This method will select text region field
    public void selectRegion(String uRegion) {
        Reporter.log("Select region " + uRegion + " to Region field " + region.toString());
        selectByVisibleTextFromDropDown(region, uRegion);
        CustomListeners.test.log(Status.PASS, "Selected region " + uRegion);

    }
    //This method will click on continue button
    public void clickOnGuestContinueButton() {
        Reporter.log("Clicking on continue Button in guest section " + guestContinueButton.toString());
        clickOnElement(guestContinueButton);
        CustomListeners.test.log(Status.PASS, "Clicking on continue Button in guest section ");

    }
    //This method will send text to add comment box
    public void sendTextToAddCommentBox(String comment) {
        Reporter.log("Enter comments " + comment + " to Comment field " + commentField.toString());
        sendTextToElement(commentField, comment);
        CustomListeners.test.log(Status.PASS, "Entered comments " + comment);

    }
    //This method will click on term and condition box
    public void clickOnTermAndConditionsCheckBox() {

        Reporter.log("Clicking on term and conditions box " + termAndConditionsCheckBox.toString());
        clickOnElement(termAndConditionsCheckBox);
        CustomListeners.test.log(Status.PASS, "Clicking on term and conditions box ");

    }
    //This method will click on continue button
    public void clickOnContinueButtonInCommentSection() {

        Reporter.log("Clicking on continue Button in comment section " + continueButtonInCommentSection.toString());
        clickOnElement(continueButtonInCommentSection);
        CustomListeners.test.log(Status.PASS, "Clicking on continue Button in comment section ");

    }
    //This method will get text from error message
    public String getPaymentErrorMessage() {
        Reporter.log("The payment error message is " + paymentErrorMessage.toString());
        CustomListeners.test.log(Status.PASS, "The payment error message is " + paymentErrorMessage.getText());
        return getTextFromElement(paymentErrorMessage);
    }

}
