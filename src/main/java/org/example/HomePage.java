package org.example;

import org.example.categories.CategoryWomanPage;

import static com.codeborne.selenide.Selenide.open;

public class HomePage extends BasePage {

    public static final String URL_HOME_PAGE = "http://automationpractice.com/index.php";
    public static final String SIGN_IN_BUTTON = "//div[@class='header_user_info']/a[@title='Log in to your customer account']";
    public static final String WOMEN_BUTTON = "//ul[contains(@class, 'menu-content')]/li/a[@title='Women']";
    public static final String CONTACT_US_BUTTON = "//div[@id='contact-link']/a[@title='Contact Us']";




    public HomePage openMe() {
        open(URL_HOME_PAGE);
        return this;
    }


    public AuthenticationPage clickSignInButton() {
        clickWhenVisibleInMillis(SIGN_IN_BUTTON, 5000);
        return new AuthenticationPage();
    }

    public CategoryWomanPage clickWomenButton() {
        clickWhenVisibleInMillis(WOMEN_BUTTON, 5000);
        return new CategoryWomanPage();
    }

    public ContactPage clickContactUsButton() {
        clickWhenVisibleInMillis(CONTACT_US_BUTTON, 5000);
        return new ContactPage();
    }


}
