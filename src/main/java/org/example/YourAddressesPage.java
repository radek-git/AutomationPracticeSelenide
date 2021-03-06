package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class YourAddressesPage extends MyAccountPage {

    public static final String SAVE_BUTTON = "//button[@id='submitAddress']";
    public static final String ALERT_DANGER_MESSAGE = "//div[contains(@class, 'alert-danger')]";
    public static final String BACK_TO_YOUR_ADDRESSES_BUTTON = "//ul[contains(@class, 'footer_links')]/li/a[./span[contains(text(), 'Back to your addresses')]]";


    public YourAddressesPage clickSaveButton() {
        clickWhenVisibleInMillis(SAVE_BUTTON, 10000);
        return this;
    }


    public boolean isAlertDangerDisplayed() {
        return $x(ALERT_DANGER_MESSAGE).shouldBe(Condition.visible, Duration.ofMillis(15000)).isDisplayed();
    }

    public MyAddressesPage clickBackToYourAddressesButton() {
        clickWhenVisibleInMillis(BACK_TO_YOUR_ADDRESSES_BUTTON, 2000);
        return new MyAddressesPage();
    }

    public YourAddressesPage scrollToElement() {
        String xpath = "//button[@id='submitAddress']";
        SelenideElement element = $x(xpath);

        executeJavaScript("arguments[0].scrollIntoView()", element);
        return this;
    }






}
