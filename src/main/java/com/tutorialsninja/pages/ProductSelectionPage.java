package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductSelectionPage extends Utility {

    //Declaring WebElement type variables
    @CacheLookup
    @FindBy(xpath = "(//div[@class='col-sm-4'])[2]/h1")
    WebElement productName;
    @CacheLookup
    @FindBy(css = "i[class='fa fa-calendar']")
    WebElement calendarButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[2]")
    WebElement monthAndYearInCalendar;

    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[3]")
    WebElement nextMonthAndYearButtonInCalendar;

    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']//div//table//td")
    List<WebElement> datesInCalendar;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement selectQuantity;
    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLinkInSuccessMessage;


    //This method will get the product name
    public String getSelectedProductName() {
        Reporter.log("The Product Name is " + productName.toString());
        CustomListeners.test.log(Status.PASS, "The Product Name is " + productName.getText());
        return getTextFromElement(productName);
    }


    //This method will select date and yea
    public void selectDateAndYearOnCalendar(String month, String year) {
       Reporter.log("Clicking on Calender Button " + calendarButton.toString());
        clickOnElement(calendarButton);
        while (true) {
            String monthYear = getTextFromElement(monthAndYearInCalendar);
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextMonthAndYearButtonInCalendar);
            }

        }
       CustomListeners.test.log(Status.PASS, "Click on Calender Button");

    }

    //This method will select the date
    public void selectDateOnCalendar(String date) {
      //  Reporter.log("Select Date " + datesInCalendar.toString());
        List<WebElement> allDates = datesInCalendar;
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;

            }
        }
    CustomListeners.test.log(Status.PASS, "Selected Date is " + date);

    }


    //This method will send text to qty box
    public void enterQuantityRequired(String quantity) {
        Reporter.log("Clear text " + selectQuantity.toString());
        clearTextFromField(selectQuantity);
        Reporter.log("Send quantity " + quantity + " to firstname field " + selectQuantity.toString());
        sendTextToElement(selectQuantity, quantity);
        CustomListeners.test.log(Status.PASS, "Quantity is " + quantity);
    }

    //This method will click on Add to Cart button
    public void clickAddToCartButton() {
        Reporter.log("Clicking on Add To Cart Button " + addToCartButton.toString());
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS, "Click on Add To Cart Button");

    }

    //This method will get the “Success: You have added HP LP3065 to your shopping cart!” message after clicking on Add To Cart
    public String getSuccessMessageAfterClickingAddToCartButton() {
        Reporter.log("The Success Message is " + successMessage.toString());
        CustomListeners.test.log(Status.PASS, "The Success Message is " + successMessage.getText());
        return getTextFromElement(successMessage);
    }


    //This method will click on Shopping Cart link in success message
    public void clickShoppingCartButtonInMessage() {
        Reporter.log("Clicking on Shopping Cart Button " + shoppingCartLinkInSuccessMessage.toString());
        clickOnElement(shoppingCartLinkInSuccessMessage);
        CustomListeners.test.log(Status.PASS, "Clicking on Shopping Cart Button");
    }

}

