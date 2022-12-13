package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    //Declaring WebElement type variables
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[3]")
    WebElement modelName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;
    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[4]/div/input")
    WebElement quantityField;
    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[4]/div/span/button[1]")
    WebElement updateQty;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement cartUpdateMessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkOutButton;


    //This method will get shopping cart text
    public String getShoppingCartTextOnSHoppingCartPage() {
        Reporter.log("The Shopping Cart Text is " + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "The Shopping Cart Text is " + shoppingCartText.getText());
        return getTextFromElement(shoppingCartText);
    }

    //This method will get product Name
    public String getProductNameInCart() {
        Reporter.log("The Product in Cart is " + productName.toString());
        CustomListeners.test.log(Status.PASS, "The Product in Cart is " + productName.getText());
        return getTextFromElement(productName);
    }

    //This method will get delivery date
    public String getDeliveryDateInCart() {
        Reporter.log("The Delivery Date is " + deliveryDate.toString());
        CustomListeners.test.log(Status.PASS, "The Delivery Date is  " + deliveryDate.getText());
        return getTextFromElement(deliveryDate);
    }

    //This method will get model Name
    public String getModelNameInCart() {
        Reporter.log("The Model Name is " + modelName.toString());
        CustomListeners.test.log(Status.PASS, "The Model Name is " + modelName.getText());
        return getTextFromElement(modelName);
    }

    //This method will get total
    public String getTotalPriceOfProducts() {
        Reporter.log("The New Total Price is " + totalPrice.toString());
        CustomListeners.test.log(Status.PASS, "The New Total Price is" + totalPrice.getText());
        return getTextFromElement(totalPrice);
    }

    //This method will clear and update the quantity as per user requirement
    public void updateQuantity(String qty) {
        Reporter.log("The Quantity is " + quantityField.toString());
        clearTextFromField(quantityField);
        sendTextToElement(quantityField, qty);
        clickOnElement(updateQty);
        CustomListeners.test.log(Status.PASS, "The Quantity is " + qty);

    }

    public String getShoppingCartUpdatedMessage() {
        Reporter.log("The Shopping Cart Updated Text is " + cartUpdateMessage.toString());
        CustomListeners.test.log(Status.PASS, "The Shopping Cart Updated Text is " + cartUpdateMessage.getText());
        return getTextFromElement(cartUpdateMessage);
    }

    public void clickOnCheckOutButton() {
        Reporter.log("Click on guest checkout  Button " + checkOutButton.toString());
        clickOnElement(checkOutButton);
        CustomListeners.test.log(Status.PASS, "Click on guest checkout Button");
    }


}
