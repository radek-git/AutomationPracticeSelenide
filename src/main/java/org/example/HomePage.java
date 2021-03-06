package org.example;

import static com.codeborne.selenide.Selenide.open;

public class HomePage extends BasePage{

    public static final String URL_HOME_PAGE = "http://automationpractice.com/index.php";
    public static final String SIGN_IN_BUTTON = "//div[@class='header_user_info']/a[@title='Log in to your customer account']";


    public HomePage openMe() {
        open(URL_HOME_PAGE);
        return new HomePage();
    }


    public AuthenticationPage clickSignInButton() {
        clickWhenVisibleInMillis(SIGN_IN_BUTTON, 5000);
        return new AuthenticationPage();
    }
}
