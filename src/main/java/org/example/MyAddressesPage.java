package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class MyAddressesPage extends MyAccountPage {

    public static final String USERNAME = "(//li/span[@class='address_name'])[1]";
    public static final String SURNAME = "(//li/span[@class='address_name'])[2]";
    public static final String COMPANY = "//li/span[@class='address_company']";
    public static final String PHONE_NO = "//li/span[@class='address_phone']";
    public static final String MOBILE_PHONE_NO = "//li/span[@class='address_phone_mobile']";
    public static final String DELETE_ADDRESS_BUTTON = "//div[contains(@class, 'address')]/ul/li[@class='address_update']/a[@title='Delete']";
    public static final String WARNING_MESSAGE = "//div[@id='center_column']/p[contains(@class, 'alert-warning')]";



    public String getFirstName() {
        return $x(USERNAME).shouldBe(Condition.visible, Duration.ofMillis(15000)).getText();
    }

    public String getSurname() {
        return $x(SURNAME).shouldBe(Condition.visible, Duration.ofMillis(15000)).getText();
    }

    public String getCompanyName() {
        return $x(COMPANY).shouldBe(Condition.visible, Duration.ofMillis(15000)).getText();
    }


    public String getPhoneNo() {
        return $x(PHONE_NO).shouldBe(Condition.visible, Duration.ofMillis(3000)).getText();
    }

    public String getMobilePhoneNo() {
        return $x(MOBILE_PHONE_NO).shouldBe(Condition.visible, Duration.ofMillis(3000)).getText();
    }

    public MyAddressesPage clickDeleteButtonAndConfirm() {
        clickWhenVisibleInMillis(DELETE_ADDRESS_BUTTON, 20000);
        switchTo().alert().accept();
        return this;
    }

    public MyAddressesPage clickDeleteAndDismiss() {
        clickWhenVisibleInMillis(DELETE_ADDRESS_BUTTON, 20000);
        Selenide.switchTo().alert().dismiss();
        return this;
    }

    public String getWarningMessageText() {
        return $x(WARNING_MESSAGE).shouldBe(Condition.visible, Duration.ofMillis(7000)).getText();
    }

    public boolean isFirstNameDisplayed() {
        return $x(USERNAME).isDisplayed();
    }

    public YourAddressesPage clickNewAddressButton() {
        clickWhenVisibleInMillis(ADD_NEW_ADDRESS_BUTTON, 1000);
        return new YourAddressesPage();
    }


}
