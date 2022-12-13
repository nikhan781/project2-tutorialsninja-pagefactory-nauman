package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class TopMenuPage extends Utility {
    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul//li//a")
    List<WebElement> topMenu;


    //This Method will select Options from Top Menu
    public void selectMenu(String menu) {
        Reporter.log("The Top Menu Options are  " + topMenu.toString());

        List<WebElement> menuList = topMenu;
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(menu)) {
                    list.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = topMenu;
        }
        CustomListeners.test.log(Status.PASS, "The selected option is " + menu.toString());

    }
    //This Method will hover pointer on Top Menu elements
    public void hoverOverMainMenuBar(String mainMenu) {
        Reporter.log("The Top Menu Options are " + topMenu.toString());
        Actions actions = new Actions(driver);
        List<WebElement> menuList = topMenu;
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(mainMenu)) {
                    actions.moveToElement(list).build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = topMenu;
        }
        CustomListeners.test.log(Status.PASS, "The selected option is " + mainMenu.toString());
    }
}
