package org.example;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.BasePage.*;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CreateAccountPageTest extends BaseTest {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;


    @BeforeTest
    public void before() {
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        myAddressesPage = new MyAddressesPage();
    }


    @Test(priority = 0)
    public void shouldCompletePersonalInformation() {
        String username = homePage.openMe()
                .clickSignInButton()
                .inputEmailAddress()
                .clickCreateAccountButton()
                .selectRandomTitle()
                .inputData()
                .clickRegisterButton()
                .getUsername();

        assertEquals(username, firstName+" "+ lastName);
    }

    @Test(priority = 1)
    public void readMyAddress() {
        myAccountPage.clickMyAddress();

        assertEquals(myAddressesPage.getFirstName(), firstName);
        assertEquals(myAddressesPage.getSurname(), lastName);
        assertEquals(myAddressesPage.getCompanyName(), companyName);
        assertEquals(myAddressesPage.getPhoneNo(), phoneNo);
        assertEquals(myAddressesPage.getMobilePhoneNo(), cellPhoneNo);
    }

    @Test(priority = 2)
    public void shouldDismissDeleteAddress() {
        myAddressesPage.clickDeleteAndDismiss();

        assertTrue(myAddressesPage.isFirstNameDisplayed());
    }

    @Test(priority = 3)
    public void shouldDeleteAddress() {

        String warningMessage = myAddressesPage.clickDeleteButtonAndConfirm()
                .getWarningMessageText();

        assertEquals(warningMessage, "No addresses are available. Add a new address");
    }


}
