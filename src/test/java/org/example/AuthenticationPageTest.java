package org.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.AuthenticationPage.CREATE_ACCOUNT_EMAIL;
import static org.testng.Assert.assertEquals;

public class AuthenticationPageTest extends BaseTest {

    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private final String correctEmail = "Otis.Thompson@gmail.con";
    private final String correctPassword = "dupa1234";
    private final String wrongEmail = "Otis.Thomson@gmail.con";
    private final String wrongPassword = "costam1234";

    @BeforeMethod
    public void before() {
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
    }


    @Test
    public void shouldNotLoginWhenEmailAndPasswordAreEmpty() {
        homePage.openMe()
                .clickSignInButton()
                .inputEmail("")
                .inputPassword("")
                .clickSignInButton();

        assertEquals(authenticationPage.getTextFromErrorMessage(), "An email address required.");
    }

    @Test
    public void shouldNotLoginUserWhenEmailIsValidAndPasswordIsInvalid() {
        homePage.openMe()
                .clickSignInButton()
                .inputEmail(correctEmail)
                .inputPassword(wrongPassword)
                .clickSignInButton();

        assertEquals(authenticationPage.getTextFromErrorMessage(), "Authentication failed.");
    }


    @Test
    public void shouldNotLoginWhenEmailIsInvalidAndPasswordIsInvalid() {
        homePage.openMe()
                .clickSignInButton()
                .inputEmail(wrongEmail)
                .inputPassword(correctPassword)
                .clickSignInButton();

        assertEquals(authenticationPage.getTextFromErrorMessage(), "Authentication failed.");
    }

    @Test
    public void shouldNotLoginWhenEmailIsEmptyAndPasswordIsCorrect() {
        homePage.openMe()
                .clickSignInButton()
                .inputEmail("")
                .inputPassword(correctPassword)
                .clickSignInButton();

        assertEquals(authenticationPage.getTextFromErrorMessage(), "An email address required.");
    }


    @Test
    public void shouldNotLoginWhenEmailIsValidAndPasswordIsEmpty() {
        homePage.openMe()
                .clickSignInButton()
                .inputEmail(correctEmail)
                .inputPassword("")
                .clickSignInButton();

        assertEquals(authenticationPage.getTextFromErrorMessage(), "Password is required.");
    }


    @Test
    public void shouldDisplayErrorMessageWhenAccountIsCreatedWithoutEmailAddress() {
        homePage.openMe()
                .clickSignInButton()
                .inputEmailAddressForNewUser("")
                .clickCreateAccountButton();

        assertEquals(authenticationPage.getErrorMessageWhenAccountIsCreatedWithoutEmailAddress(), "Invalid email address.");
    }




}
