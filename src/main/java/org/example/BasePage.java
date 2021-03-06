package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.github.javafaker.Faker;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.*;

public abstract class BasePage {

    static Faker faker = new Faker();

    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String companyName = faker.company().name();
    static String address1 = faker.address().fullAddress();
    static String address2 = faker.address().secondaryAddress();
    static String city = faker.address().cityName();
    static String zipCode = faker.numerify("#####");
    static String phoneNo = faker.numerify("###-###-####");
    static String cellPhoneNo = faker.phoneNumber().cellPhone();



    String emailAddress = firstName + "." + lastName + "@gmail.con";
    String password = "dupa1234";

    public void clickWhenVisibleInMillis(String xpath, long millis) {
        $x(xpath).shouldBe(Condition.visible, Duration.ofMillis(millis)).click();
    }

    public void inputTextInField(String xpath, String text) {
        $x(xpath).shouldBe(Condition.visible, Duration.ofMillis(5000)).sendKeys(text);
    }

    public void clickAndSelectRandomOption(String inputXpath, String optionXpath, String optionXpathOnIndex) {
        $x(inputXpath).click();
        ElementsCollection selenideElements = $$x(optionXpath);
        System.out.println(selenideElements.size());
        int rnd = ThreadLocalRandom.current().nextInt(2, selenideElements.size());
        $x(String.format(optionXpathOnIndex, rnd)).click();
    }







}
