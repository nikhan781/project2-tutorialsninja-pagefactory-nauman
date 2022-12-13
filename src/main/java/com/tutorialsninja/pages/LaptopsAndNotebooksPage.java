package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    //Declaring WebElement type variables
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortBy;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div[4]//div/child::h4/a")
    List<WebElement> allProductsOnPage;


    //This method will get Page name text
    public String getLaptopsAndNotebookText() {
        Reporter.log("The The Laptops And Desktops Text " + laptopsAndNotebooksText.toString());
        CustomListeners.test.log(Status.PASS, "The Laptops And Desktops Text is " + laptopsAndNotebooksText.getText());
        return getTextFromElement(laptopsAndNotebooksText);
    }
    //This method will sort list by price high to low
    public void sortByPriceHigToLow() {
        Reporter.log("The products are sorted BY High to Low prices " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Price (High > Low)");
        CustomListeners.test.log(Status.PASS, "The products are sorted BY High to Low prices ");
    }
    //This method will verify list by price
    public List<Double> beforeSortTheProductsByPrice() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductPrice = new ArrayList<>();
        for (WebElement list : products) {
            String arr[] = list.getText().split("Ex Tax:");
            originalProductPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductPrice;
    }
    //This method will verify list by price
    public ArrayList<Double> afterSortingTheProductsByPrice() {
        Collections.sort(beforeSortTheProductsByPrice(), Collections.reverseOrder());
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement newPriceList : products) {
            String[] arr = newPriceList.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return afterSortByPrice;
    }

    //This Method will click on a product
    public void selectAProduct(String mainMenu) {
        Reporter.log("The products are " + allProductsOnPage.toString());

        List<WebElement> allProducts = allProductsOnPage;
        try {
            for (WebElement products : allProducts) {
                if (products.getText().equalsIgnoreCase(mainMenu)) {
                    products.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            allProducts = allProductsOnPage;
        }
        CustomListeners.test.log(Status.PASS, "The selected product is " + mainMenu);

    }


}
