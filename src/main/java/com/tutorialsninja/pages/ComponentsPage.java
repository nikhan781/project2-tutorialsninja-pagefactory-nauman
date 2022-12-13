package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComponentsPage extends Utility {
    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;

    //This method will text from component page
    public String getComponentsPageText() {
        Reporter.log("The Components page text is " + componentsText.toString());
        CustomListeners.test.log(Status.PASS, "The Components page text is " + componentsText.getText());
        return getTextFromElement(componentsText);
    }
}
