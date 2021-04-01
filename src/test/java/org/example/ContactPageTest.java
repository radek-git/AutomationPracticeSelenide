package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactPageTest extends BaseTest {

    private HomePage homePage;
    private ContactPage contactPage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage();
        contactPage = new ContactPage();
    }


    @Test
    public void shouldInputAllFieldsWithValidValuesAndVerifyIfDisplayedMessageIsCorrect() {
        homePage.openMe()
                .clickContactUsButton()
                .selectWebmasterOption()
                .inputEmailAddress("aaaaaaaa@aaaaa.au")
                .inputOrderReference()
                .inputMessage()
                .attachFile()
                .clickSendButton();

        assertEquals(contactPage.getTextFromConfirmationMessage(), "Your message has been successfully sent to our team.");
  }


    @Test
    public void shouldDisplayErrorMessageWhenAllFieldsAreEmptyAndSendButtonClicked() {
        homePage.openMe()
                .clickContactUsButton()
                .clickSendButton();

        assertEquals(contactPage.getTextFromErrorMessage(), "Invalid email address.");
    }

    @Test
    public void shouldDisplayErrorMessageWhenEmailIsInputAndAllFieldsAreEmpty() {
        homePage.openMe()
                .clickContactUsButton()
                .inputEmailAddress("gwidon@ryba.pl")
                .clickSendButton();

        assertEquals(contactPage.getTextFromErrorMessage(), "The message cannot be blank.");
    }

}
