package org.example;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class AuthenticationPage extends BasePage{


    public static final String CREATE_ACCOUNT_EMAIL = "//input[@id='email_create']";
    public static final String CREATE_ACCOUNT_BUTTON = "//button[@id='SubmitCreate']";


    public AuthenticationPage inputEmailAddress() {
        $x(CREATE_ACCOUNT_EMAIL).shouldBe(Condition.visible, Duration.ofMillis(10000));
        inputTextInField(CREATE_ACCOUNT_EMAIL, emailAddress);
        return new AuthenticationPage();
    }

    public CreateAccountPage clickCreateAccountButton() {
        clickWhenVisibleInMillis(CREATE_ACCOUNT_BUTTON, 1000);
        return new CreateAccountPage();
    }
}
