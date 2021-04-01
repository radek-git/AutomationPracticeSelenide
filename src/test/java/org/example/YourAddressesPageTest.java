package org.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class YourAddressesPageTest extends BaseTest {

    private HomePage homePage;
    private YourAddressesPage yourAddressesPage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage();
        yourAddressesPage = new YourAddressesPage();

        homePage.openMe()
                .clickSignInButton()
                .inputEmailAddressForNewUser()
                .clickCreateAccountButton()
                .selectRandomTitle()
                .inputData()
                .clickRegisterButton()
                .clickMyAddress()
                .clickNewAddressButton();
    }

    @Test(priority = 0)
    public void shouldDisplayErrorMessageWhenEmptyFormIsSaved() {
        yourAddressesPage.scrollToElement().clickSaveButton();

        assertTrue(yourAddressesPage.isAlertDangerDisplayed());
    }


}
