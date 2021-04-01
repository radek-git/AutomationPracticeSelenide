package org.example;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class AuthenticationPage extends BasePage{


    public static final String CREATE_ACCOUNT_EMAIL = "//input[@id='email_create']";
    public static final String CREATE_ACCOUNT_BUTTON = "//button[@id='SubmitCreate']";
    public static final String REGISTERED_EMAIL_ADDRESS = "//input[@id='email']";
    public static final String REGISTERED_LOGIN_PASSWORD = "//input[@id='passwd']";
    public static final String SIGN_IN_BUTTON = "//button[@id='SubmitLogin']";
    public static final String ERROR_MESSAGE_CONTENT = "//div[contains(@class, 'alert-danger')]/ol/li";
    public static final String CREATE_ACCOUNT_ERROR_MESSAGE = "//div[@id='create_account_error']/ol/li";


    public AuthenticationPage inputEmailAddressForNewUser() {
        $x(CREATE_ACCOUNT_EMAIL).shouldBe(Condition.visible, Duration.ofMillis(10000));
        inputTextInField(CREATE_ACCOUNT_EMAIL, emailAddress);
        System.out.println(emailAddress);
        return this;
    }

    public AuthenticationPage inputEmailAddressForNewUser(String email) {
        $x(CREATE_ACCOUNT_EMAIL).shouldBe(Condition.visible, Duration.ofMillis(10000));
        inputTextInField(CREATE_ACCOUNT_EMAIL, email);
        System.out.println(emailAddress);
        return this;
    }

    public CreateAccountPage clickCreateAccountButton() {
        clickWhenVisibleInMillis(CREATE_ACCOUNT_BUTTON, 1000);
        return new CreateAccountPage();
    }

    public AuthenticationPage inputEmail(String email) {
        inputTextInField(REGISTERED_EMAIL_ADDRESS, email);
        return this;
    }

    public AuthenticationPage inputPassword(String password) {
        inputTextInField(REGISTERED_LOGIN_PASSWORD, password);
        return this;
    }


    public MyAccountPage clickSignInButton() {
        clickWhenVisibleInMillis(SIGN_IN_BUTTON, 2000);
        return new MyAccountPage();
    }

    public String getTextFromErrorMessage() {
        return getTextFromElement(ERROR_MESSAGE_CONTENT);
    }

    public String getErrorMessageWhenAccountIsCreatedWithoutEmailAddress() {
        return getTextFromElement(CREATE_ACCOUNT_ERROR_MESSAGE);
    }



}
