package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
                .inputEmailAddress()
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
