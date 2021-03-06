package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class YourAddressesPageTest extends BaseTest {

    private HomePage homePage;

    private YourAddressesPage yourAddressesPage;

    @BeforeTest
    public void before() {
        homePage = new HomePage();
        yourAddressesPage = new YourAddressesPage();
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;

        homePage.openMe()
                .clickSignInButton()
                .inputEmailAddress()
                .clickCreateAccountButton()
                .selectRandomTitle()
                .inputData()
                .clickRegisterButton()
                .clickMyAddress()
                .clickNewAddressButton();
    }


    @Test(priority = 5)
    public void shouldDisplayErrorMessageWhenEmptyFormIsSaved() {
        yourAddressesPage.clickSaveButton();

        assertTrue(yourAddressesPage.isAlertDangerDisplayed());
    }


}
