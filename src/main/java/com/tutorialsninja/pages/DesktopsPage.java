package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {
    //Declaring WebElement type variables

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement hpLp2065;


    //This will get Desktop text
    public String getDesktopPageText() {
        Reporter.log("The Desktop page Text  " + desktopText.toString());
        CustomListeners.test.log(Status.PASS, "The Desktop page Text is " + desktopText.getText());
        return getTextFromElement(desktopText);
    }

    //This method will select A to Z
    public void sortByAtoZ() {
        Reporter.log("Sort By A to Z " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Name (A - Z)");
        CustomListeners.test.log(Status.PASS, "Sorted By A to Z ");

    }

    //This method will select Z to A
    public void sortByZtoA() {
        Reporter.log("Sort By Z to A " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Name (Z - A)");
        CustomListeners.test.log(Status.PASS, "Sorted By Z to A ");

    }

    //This method verify the sort by type
    public ArrayList beforeSortTheProducts() {
        List<WebElement> products = listOfProducts;
        ArrayList<String> originalProductList = new ArrayList<>();
        for (WebElement list : products) {
            originalProductList.add(list.getText());
        }
        return originalProductList;
    }

    //This method verify the sort by type
    public ArrayList afterSortingTheProducts() {
        Collections.reverse(beforeSortTheProducts());
        System.out.println(beforeSortTheProducts());
        List<WebElement> products = listOfProducts;
        ArrayList<String> afterSortList = new ArrayList<>();
        for (WebElement newList : products) {
            afterSortList.add(newList.getText());
        }
        return afterSortList;
    }

    //This method will click on HP LP3065
    public void clickOnHpLPDesktop() {
        Reporter.log("Clicking on Product " + hpLp2065.toString());
        clickOnElement(hpLp2065);
        CustomListeners.test.log(Status.PASS, "Click on product ");

    }

}
