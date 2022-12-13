package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    //Declaring WebElement Variables
    @CacheLookup
    @FindBy(css = "i[class='fa fa-caret-down']")
    WebElement currencySelectionLink;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[1]")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show All Desktops')]")
    WebElement showAllDesktop;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[2]")
    WebElement laptopAndNotebooks;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show All Laptops & Notebooks')]")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//div[@class='btn-group open']/ul/li")
    List<WebElement> listOfCurrencies;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li//a")
    List<WebElement> listOfMyAccountOptions;


    //Method to select currency
    public void selectRequiredCurrency() {
        // Reporter.log("List of currencies " + listOfCurrencies.toString());
        clickOnElement(currencySelectionLink);
        List<WebElement> currencyList = listOfCurrencies;
        for (WebElement currency : currencyList) {
            if (currency.getText().equalsIgnoreCase("£ Pound Sterling")) {
                currency.click();
                break;
            }
        }
         CustomListeners.test.log(Status.PASS, "List of currencies ");

    }

    //Method to hover mouse on Desktops link
    public void hoverOverDesktopLink() {

        Reporter.log("Hover over Desktops Menu " + desktopLink.toString());
        mouseHoverToElement(desktopLink);
        CustomListeners.test.log(Status.PASS, "Hover over Desktops Menu");

    }

    //Method to hover mouse on Laptop and Notebooks link
    public void hoverOverLaptopsAndNotebooksLink() {
        Reporter.log("Hover over Laptops And NoteBooks Menu " + laptopAndNotebooks.toString());
        clickOnElement(laptopAndNotebooks);
        CustomListeners.test.log(Status.PASS, "Hover over Laptops And NoteBooks Menu");

    }

    //Method to click on Show All Desktops link
    public void clickOnShowAllDesktopsLink() {
        Reporter.log("Clicking on Show All Desktops Link " + showAllDesktop.toString());
        clickOnElement(showAllDesktop);
        CustomListeners.test.log(Status.PASS, "Clicking on Show All Desktops Link ");
    }


    //Method to click on Show All Laptop & Notebooks link
    public void clickOnShowAllLaptopAndNotebooksLink() {
        Reporter.log("Clicking on Show All Laptops And NoteBooks Link " + showAllLaptopsAndNotebooks.toString());
        clickOnElement(showAllLaptopsAndNotebooks);
        CustomListeners.test.log(Status.PASS, "Clicking on Show All Laptops And NoteBooks Link");

    }
        //this method will click on My Account link
    public void homepageMyAccountLink() {
        Reporter.log("Click on My Account Link " + myAccountLink.toString());
        clickOnElement(myAccountLink);
        CustomListeners.test.log(Status.PASS, "Click on My Account Link");

    }
    // This mehtod will select options from My Account
    public void selectMyAccountOptions(String options) {
        Reporter.log("Select My Account Options " + listOfMyAccountOptions.toString());

        List<WebElement> accountOptionList = listOfMyAccountOptions;
        for (WebElement accountOptions : accountOptionList) {
            if (accountOptions.getText().equalsIgnoreCase(options)) {
                accountOptions.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "My Account Option selected is " + options);

    }


}
