package org.example;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.screenshot;
import static org.example.BasePage.*;
import static org.example.ScreenshotUtils.capture;
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

        homePage = homePage.openMe();
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_Home_Page");
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_Authentication_Page_Empty");
        authenticationPage = authenticationPage.inputEmailAddress();
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_Authentication_Page_Email_Filled");
        CreateAccountPage createAccountPage = authenticationPage.clickCreateAccountButton();
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_Page_Empty");
        createAccountPage = createAccountPage.selectRandomTitle(); //zmien na konkretny
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_Page_Title_Selected");
        createAccountPage = createAccountPage.inputData();
        createAccountPage.scrollToTop();
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_Page_Data_Filled_1");
        createAccountPage.scrollToNextPage();
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_Page_Data_Filled_2");
        createAccountPage.scrollToNextPage();
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_Page_Data_Filled_3");

        myAccountPage = createAccountPage.clickRegisterButton();
        capture(WebDriverRunner.getWebDriver(), "05_Create_Account_My_Account_Page");
        String username = myAccountPage.getUsername();

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
