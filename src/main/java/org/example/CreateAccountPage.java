package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountPage extends BasePage {

    public static final String TITLE_ON_INDEX = "(//div[@class='clearfix']/div[@class='radio-inline'])[%d]";
    public static final String FIRST_NAME_INPUT = "//input[@id='customer_firstname']";
    public static final String LAST_NAME_INPUT = "//input[@id='customer_lastname']";
    public static final String EMAIL_INPUT = "//input[@id='email']";
    public static final String PASSWORD_INPUT = "//input[@id='passwd']";
    public static final String DOB_DAY_SELECT = "//select[@id='days']";
    public static final String DOB_DAY_OPTION = "//select[@id='days']/option";
    public static final String DOB_DAY_OPTION_ON_INDEX = "(//select[@id='days']/option)[%d]";
    public static final String DOB_MONTH_SELECT = "//select[@id='months']";
    public static final String DOB_MONTH_OPTION = "//select[@id='months']/option";
    public static final String DOB_MONTH_OPTION_ON_INDEX = "(//select[@id='months']/option)[%d]";
    public static final String DOB_YEAR_SELECT = "//select[@id='years']";
    public static final String DOB_YEAR_OPTION = "//select[@id='years']/option";
    public static final String DOB_YEAR_OPTION_ON_INDEX = "(//select[@id='years']/option)[%d]";
    public static final String ADDRESS_FIRST_NAME_INPUT = "//input[@id='firstname']";
    public static final String ADDRESS_LAST_NAME_INPUT = "//input[@id='lastname']";
    public static final String COMPANY_INPUT = "//input[@id='company']";
    public static final String ADDRESS1_INPUT = "//input[@id='address1']";
    public static final String ADDRESS2_INPUT = "//input[@id='address2']";
    public static final String CITY_INPUT = "//input[@id='city']";
    public static final String STATE_SELECT = "//select[@id='id_state']";
    public static final String STATE_OPTION = "//select[@id='id_state']/option";
    public static final String STATE_OPTION_ON_INDEX = "(//select[@id='id_state']/option)[%d]";
    public static final String POSTAL_CODE_INPUT = "//input[@id='postcode']";
    public static final String COUNTRY_SELECT = "//select[@id='id_country']";
    public static final String ADDITIONAL_INFO_INPUT = "//textarea[@id='other']";
    public static final String PHONE_INPUT = "//input[@id='phone']";
    public static final String MOBILE_PHONE_INPUT = "//input[@id='phone_mobile']";
    public static final String ASSIGN_ADDRESS_INPUT = "//input[@id='alias']";
    public static final String REGISTER_BUTTON = "//button[@id='submitAccount']";
    public static final String ACCOUNT_CREATION_FORM_DIV = "//form[@id='account-creation_form']";
    public static final String NEWSLETTER_CHECKBOX = "//div[@id='uniform-newsletter']/span/input";
    public static final String SPECIAL_OFFERS_CHECKBOX = "//div[@id='uniform-optin']/span/input";



    public CreateAccountPage selectRandomTitle() {
        int rnd = ThreadLocalRandom.current().nextInt(1, 3);
        $x(String.format(TITLE_ON_INDEX, rnd)).shouldBe(Condition.visible, Duration.ofMillis(3000)).click();
        return new CreateAccountPage();
    }


    public CreateAccountPage clickRandomDay() {
        clickAndSelectRandomOption(DOB_DAY_OPTION, DOB_DAY_OPTION, DOB_DAY_OPTION_ON_INDEX);
        return new CreateAccountPage();
    }


    public CreateAccountPage clickRandomMonth() {
        clickAndSelectRandomOption(DOB_MONTH_SELECT, DOB_MONTH_OPTION, DOB_MONTH_OPTION_ON_INDEX);
        return new CreateAccountPage();
    }

    public CreateAccountPage clickRandomYear() {
        clickAndSelectRandomOption(DOB_YEAR_SELECT, DOB_YEAR_OPTION, DOB_YEAR_OPTION_ON_INDEX);
        return new CreateAccountPage();
    }


    public MyAccountPage clickRegisterButton() {
        clickWhenVisibleInMillis(REGISTER_BUTTON, 1000);
        return new MyAccountPage();
    }

    public CreateAccountPage inputData() {
        $x(ACCOUNT_CREATION_FORM_DIV).shouldBe(Condition.visible, Duration.ofMillis(10000));
        inputTextInField(FIRST_NAME_INPUT, firstName);
        inputTextInField(LAST_NAME_INPUT, lastName);
        inputTextInField(PASSWORD_INPUT, password);
        clickRandomDay();
        clickRandomMonth();
        clickRandomYear();
        $x(NEWSLETTER_CHECKBOX).click();
        $x(SPECIAL_OFFERS_CHECKBOX).click();
        inputTextInField(COMPANY_INPUT, companyName);
        inputTextInField(ADDRESS1_INPUT, address1);
        inputTextInField(ADDRESS2_INPUT, address2);
        inputTextInField(CITY_INPUT, city);
        clickAndSelectRandomOption(STATE_SELECT, STATE_OPTION, STATE_OPTION_ON_INDEX);
        inputTextInField(POSTAL_CODE_INPUT, zipCode);
        inputTextInField(ADDITIONAL_INFO_INPUT, faker.chuckNorris().fact());
        inputTextInField(PHONE_INPUT, phoneNo);
        inputTextInField(MOBILE_PHONE_INPUT, cellPhoneNo);
        inputTextInField(ASSIGN_ADDRESS_INPUT, faker.name().bloodGroup());

        return this;
    }


    public CreateAccountPage scrollToTop() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String xpath = "//html";
        SelenideElement element = $x(xpath);

        executeJavaScript("arguments[0].scrollTo(0,0);", element);
        return this;
    }

    public CreateAccountPage scrollToNextPage() {
        SelenideElement html = $("html");
        int height = html.getSize().height;
        executeJavaScript("arguments[0].scrollIntoView += arguments[1]", html, height);
        return this;
    }


}
