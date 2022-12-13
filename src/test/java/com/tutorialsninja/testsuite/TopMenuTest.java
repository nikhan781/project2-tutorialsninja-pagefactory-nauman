package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {

    HomePage homePage;
    TopMenuPage topMenuPage;

    DesktopsPage desktopsPage;

    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void classObjects() {
        homePage = new HomePage();
        topMenuPage = new TopMenuPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        desktopsPage = new DesktopsPage();
        componentsPage = new ComponentsPage();
    }


    //Test 1
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        topMenuPage.hoverOverMainMenuBar("Desktops");
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        topMenuPage.selectMenu("Show All Desktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals(desktopsPage.getDesktopPageText(), "Desktops", "Desktops text is not displayed");

    }

    //Test2
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        topMenuPage.hoverOverMainMenuBar("Laptops & Notebooks");
        //homePage.hoverOverLaptopsAndNotebooksLink();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        topMenuPage.selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(laptopsAndNotebooksPage.getLaptopsAndNotebookText(), "Laptops & Notebooks", "Text is not displayed");
    }

    //Test 3
    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        topMenuPage.hoverOverMainMenuBar("Components");
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        topMenuPage.selectMenu("Show All Components");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals(componentsPage.getComponentsPageText(), "Components", "Text no displayed");

    }

}
