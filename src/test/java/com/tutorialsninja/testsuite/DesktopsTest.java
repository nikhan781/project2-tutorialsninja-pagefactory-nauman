package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {

    //Declaring two classes Objects
    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductSelectionPage productSelectionPage;
    ShoppingCartPage shoppingCartPage;

    // This method contains objects of Pages
    @BeforeMethod(alwaysRun = true)
    public void classObjects() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productSelectionPage = new ProductSelectionPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsAreArrangedInAlphabeticalOrder() {
        //2.1 Hover over Desktop Link
        homePage.hoverOverDesktopLink();
        //2.2 Click on Show all Desktops link
        homePage.clickOnShowAllDesktopsLink();
        //2.3 Sort by Z to A and Verify
        desktopsPage.sortByZtoA();
        Assert.assertEquals(desktopsPage.beforeSortTheProducts(), desktopsPage.afterSortingTheProducts());
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAreAddedToShoppingCartSuccessFully() throws InterruptedException {
        // select Currency
        homePage.selectRequiredCurrency();
        //2.1 Hover over Desktop Link
        homePage.hoverOverDesktopLink();
        //2.2 Click on Show all Desktops link
        homePage.clickOnShowAllDesktopsLink();
        //2.3 Sort by A to Z and Verify
        desktopsPage.sortByAtoZ();
        Assert.assertEquals(desktopsPage.beforeSortTheProducts(), desktopsPage.afterSortingTheProducts());
        //2.4CLick on Product
        desktopsPage.clickOnHpLPDesktop();
        //2.5 Verify the product name
        Assert.assertEquals(productSelectionPage.getSelectedProductName(), "HP LP3065", "Product is not displayed on Page");
        //2.6 select delivery date
        productSelectionPage.selectDateAndYearOnCalendar("November", "2022");
        productSelectionPage.selectDateOnCalendar("30");
        //2.7 select quantity
        productSelectionPage.enterQuantityRequired("1");
        //2.8 click on add to cart button
        Thread.sleep(1000);
        productSelectionPage.clickAddToCartButton();
        Thread.sleep(1000);
        //2.9 Verify
        Assert.assertTrue(productSelectionPage.getSuccessMessageAfterClickingAddToCartButton().contains("Success: You have added HP LP3065 to your shopping cart!"), "Success: You have added HP LP3065 to your shopping cart!");
        //2.10 Click on shopping cart button
        productSelectionPage.clickShoppingCartButtonInMessage();
        //2.11 Verify
        Assert.assertEquals(shoppingCartPage.getShoppingCartTextOnSHoppingCartPage(), "Shopping Cart  (1.00kg)", "Shopping cart message didn't displayed");
        //2.12 Verify Product name
        Assert.assertEquals(shoppingCartPage.getProductNameInCart(), "HP LP3065", "Product name is wrong");
        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertEquals(shoppingCartPage.getDeliveryDateInCart(), "Delivery Date: 2022-11-30", "Delivery date is wrong");
        //2.14 Verify model
        Assert.assertEquals(shoppingCartPage.getModelNameInCart(), "Product 21", "Product model is wrong");
        //2.15 verify total price
        Assert.assertEquals(shoppingCartPage.getTotalPriceOfProducts(), "£74.73", "Total price is wrong");

    }

}
