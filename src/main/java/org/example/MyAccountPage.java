package org.example;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage extends BasePage {

    public static final String LOGGED_USER = "//div[@class='header_user_info']/a/span";
    public static final String MY_ACCOUNT_BUTTON = "//ul[@class='myaccount-link-list']/li/a[@title='Addresses']";
    public static final String ADD_NEW_ADDRESS_BUTTON = "//div[contains(@class, 'main-page-indent')]/a[@title='Add an address']";



    public MyAddressesPage clickMyAddress() {
        clickWhenVisibleInMillis(MY_ACCOUNT_BUTTON, 5000);
        return new MyAddressesPage();
    }

    public String getUsername() {
        return $x(LOGGED_USER).shouldBe(Condition.visible, Duration.ofMillis(1000)).getText();
    }



}
