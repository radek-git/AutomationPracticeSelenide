package org.example;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ContactPage extends BasePage {

    public static final String SUBJECT_HEADING_SELECT = "//select[@id='id_contact']";
    public static final String SUBJECT_HEADING_CUSTOMER_SERVICE_OPTION = "//select[@id='id_contact']/option[text()='Customer service']";
    public static final String SUBJECT_HEADING_WEBMASTER_OPTION = "//select[@id='id_contact']/option[text()='Webmaster']";
    public static final String EMAIL_INPUT = "//input[@id='email']";
    public static final String ORDER_REFERENCE_INPUT = "//input[@id='id_order']";
    public static final String ATTACH_FILE_INPUT = "//div[@id='uniform-fileUpload']/input[@id='fileUpload']";
    public static final String MESSAGE_INPUT = "//textarea[@id='message']";
    public static final String SEND_BUTTON = "//button[@id='submitMessage']";
    public static final String DESCRIPTION_TEXT_FOR_CUSTOMER_SERVICE = "//p[@id='desc_contact2']";
    public static final String DESCRIPTION_TEXT_FOR_WEBMASTER = "//p[@id='desc_contact1']";
    public static final String SELECTED_VALUE_IN_SUBJECT_HEADING = "//div[@id='uniform-id_contact']/span";
    public static final String CONFIRMATION_MESSAGE = "//div[@id='center_column']/p";
    public static final String ERROR_MESSAGE = "//div[contains(@class, 'alert-danger')]/ol/li";



    public ContactPage attachFile() {
        $x(ATTACH_FILE_INPUT).sendKeys("C:\\Users\\Radek\\Downloads\\plytki-na-schody-drewnopodobne-stopnica-crema-gorzow-wielkopolski-519082249.jpg");
        return this;
    }

    public String getValueInSubjectHeading() {
        return getTextFromElement(SELECTED_VALUE_IN_SUBJECT_HEADING);
    }

    public ContactPage selectCustomerServiceOption() {
        clickWhenVisibleInMillis(SUBJECT_HEADING_CUSTOMER_SERVICE_OPTION, 5000);
        return this;
    }

    public ContactPage selectWebmasterOption() {
        clickWhenVisibleInMillis(SUBJECT_HEADING_WEBMASTER_OPTION, 5000);
        return this;
    }

    public ContactPage inputEmailAddress(String email) {
        inputTextInField(EMAIL_INPUT, email);
        return this;
    }

    public ContactPage inputOrderReference() {
        inputTextInField(ORDER_REFERENCE_INPUT, faker.numerify("#########"));
        return this;
    }


   public String getDescriptionForSelectedSubjectHeading() {
       if (getValueInSubjectHeading().equals("Customer service")) {
           return getTextFromElement(DESCRIPTION_TEXT_FOR_CUSTOMER_SERVICE);
       } else if (getValueInSubjectHeading().equals("Webmaster")) {
           return getTextFromElement(DESCRIPTION_TEXT_FOR_WEBMASTER);
       }
       return null;
   }

   public ContactPage inputMessage() {
       inputTextInField(MESSAGE_INPUT, faker.chuckNorris().fact());
       return this;
   }


   public void clickSendButton() {
       clickWhenVisibleInMillis(SEND_BUTTON, 2000);
   }

   public String getTextFromConfirmationMessage() {
       return getTextFromElement(CONFIRMATION_MESSAGE);
   }

   public String getTextFromErrorMessage() {
       return getTextFromElement(ERROR_MESSAGE);
   }
}
