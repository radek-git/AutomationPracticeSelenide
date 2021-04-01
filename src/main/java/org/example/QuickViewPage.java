package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.categories.CategoryBasePage;
import org.example.categories.CategoryWomanPage;
import org.example.model.QuickViewItem;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class QuickViewPage extends CategoryBasePage {

    public static final String QUICK_VIEW_CONTAINER = "//div[@class='primary_block row']";
    public static final String ITEM_NAME = "//body[@id='product']/div/div/div[contains(@class, 'pb-center-column')]/h1";
    public static final String SUBTITLE = "//div[contains(@class, 'primary_block')]/div[contains(@class, 'pb-center-column')]/p[@id='product_reference']/span";
    public static final String CONDITION = "//div[contains(@class, 'primary_block')]/div[contains(@class, 'pb-center-column')]/p[@id='product_condition']/span";
    public static final String DESCRIPTION = "//div[contains(@class, 'primary_block')]/div[contains(@class, 'pb-center-column')]/div[@id='short_description_block']/div/p";
    public static final String PRICE = "//div[@class='price']/p/span[@id='our_price_display']";
    public static final String SIZE_SELECT = "//select[@id='group_1']";
    public static final String SIZE_OPTIONS = "//select[@id='group_1']/option";
    public static final String SIZE_OPTION_ON_INDEX = "(//select[@id='group_1']/option)[%d]";
    public static final String COLOR_OPTIONS = "//fieldset[@class='attribute_fieldset']/div[@class='attribute_list']/ul[@id='color_to_pick_list']/li";
    public static final String COLOR_OPTION_ON_INDEX = "(//fieldset[@class='attribute_fieldset']/div[@class='attribute_list']/ul[@id='color_to_pick_list']/li/a)[%d]";
    public static final String PICTURE_URLS = "//div[@id='views_block']/div[@id='thumbs_list']/ul/li/a/img";
    public static final String PICTURE_URL_ON_INDEX = "(//div[@id='views_block']/div[@id='thumbs_list']/ul/li/a/img)[%d]";
    public static final String CLOSE_BUTTON = "//a[@title='Close']";
    public static final String WISHLIST_BUTTON = "//p[contains(@class, 'buttons_bottom_block')]/a[@id='wishlist_button']";
    public static final String THUMBNAIL_PICTURE_ON_INDEX = "(//div[@id='thumbs_list']/ul/li)[%d]";
    public static final String THUMBNAIL_URL_ON_INDEX = "(//div[@id='thumbs_list']/ul/li)[%d]/a/img";
    public static final String SELECTED_PICTURE = "//div[@id='image-block']/span/img";
    public static final String PLUS_BUTTON = "//p[@id='quantity_wanted_p']/a/span/i[@class='icon-plus']";
    public static final String ADD_TO_CART_BUTTON = "//div[@class='box-cart-bottom']/div/p[@id='add_to_cart']/button";
    public static final String CONFIRMATION_POPUP_DIV = "//div[@id='layer_cart']/div[@class='clearfix']";
    public static final String QUANTITY_OF_ITEMS_ON_CONFIRMATION_POPUP = "//div[@class='layer_cart_product_info']/div/span[@id='layer_cart_product_quantity']";
    public static final String TOTAL_PRICE_OF_ITEM_ON_CONFIRMATION_POPUP = "//div[@class='layer_cart_product_info']/div/span[@id='layer_cart_product_price']";
    public static final String TOTAL_SHIPPING_COST_ON_CONFIRMATION_POPUP = "//div[@class='layer_cart_row']/span[@class='ajax_cart_shipping_cost']";
    public static final String QUANTITY_INPUT = "//p[@id='quantity_wanted_p']/input[@id='quantity_wanted']";
    public static final String NULL_QUANTITY_NOTIFICATION = "//div[@class='fancybox-inner']/p";
    public static final String CLOSE_NULL_QUANTITY_NOTIFICATION = "//div[@class='fancybox-skin']/a[@title='Close']";






    public QuickViewItem getItemDetails() {
        waitTillProgressScreenDisappears();
        switchToIframe(IFRAME);
//        $x("//iframe[@id='fancybox-frame1615502575373']").shouldBe(Condition.visible, Duration.ofSeconds(10));
//        $x("//div[contains(@class, 'fancybox-overlay')]").shouldBe(Condition.disappear, Duration.ofSeconds(15));
//        $x("//p[@id='add_to_cart']/button").shouldBe(Condition.enabled, Duration.ofSeconds(10));

        List<String> availableSizes = new ArrayList<>();
        List<String> availableColors = new ArrayList<>();
        List<String> pictureUrls = new ArrayList<>();

        String name = getTextFromElement(ITEM_NAME);
        String subtitle = getTextFromElement(SUBTITLE);
        String condition = getTextFromElement(CONDITION);
        String description = getTextFromElement(DESCRIPTION);
        BigDecimal price = new BigDecimal(getTextFromElement(PRICE).replace(" ", "")
                .replace("$", ""));

        List<SelenideElement> urlElements = $$x(PICTURE_URLS);
        for (int i = 1; i <= urlElements.size(); i++) {
            pictureUrls.add($x(String.format(PICTURE_URL_ON_INDEX, i)).getAttribute("src"));
        }

        List<SelenideElement> sizeElements = $$x(SIZE_OPTIONS);
        for (int i = 1; i <= sizeElements.size(); i++) {
            availableSizes.add(getTextFromElement(String.format(SIZE_OPTION_ON_INDEX, i)));
        }

        List<SelenideElement> colorElements = $$x(COLOR_OPTIONS);
        for (int i = 1; i <= colorElements.size(); i++) {
            availableColors.add($x(String.format(COLOR_OPTION_ON_INDEX, i)).getAttribute("title"));
        }

        return new QuickViewItem(name, price, subtitle, condition, description,
                pictureUrls, availableSizes, availableColors);

    }

    public QuickViewPage hoverMouseOverPictureThumbnailOnIndex(int index) {
        waitTillProgressScreenDisappears();
        switchToIframe(IFRAME);
        moveMouseToElement(String.format(THUMBNAIL_PICTURE_ON_INDEX, index));
        return this;
    }

    public String getUrlOfThumbnailOnIndex(int index) {
        return $x(String.format(THUMBNAIL_URL_ON_INDEX, index)).getAttribute("src");
    }


    public CategoryWomanPage clickCloseButton() {
        switchTo().defaultContent();
        clickWhenVisibleInMillis(CLOSE_BUTTON, 6000);
        return new CategoryWomanPage();
    }


    public QuickViewPage clickPlusButtonNTimes(int timesToClick) {
        waitTillProgressScreenDisappears();
        switchToIframe(IFRAME);
        for (int i = 1; i <= timesToClick; i++) {
            clickWhenVisibleInMillis(PLUS_BUTTON, 5);
        }
        return this;
    }

    public QuickViewPage clickAddToCartButton() {
        clickWhenVisibleInMillis(ADD_TO_CART_BUTTON, 2000);
        return this;
    }

    public BigDecimal getNumbersOfItemsAddedToCart() {
        waitForElement(CONFIRMATION_POPUP_DIV, 5);
        return new BigDecimal(getTextFromElement(QUANTITY_OF_ITEMS_ON_CONFIRMATION_POPUP));
    }

    public BigDecimal getTotalPriceOfPurchasedItem() {
        waitForElement(CONFIRMATION_POPUP_DIV, 5);
        return new BigDecimal(getTextFromElement(TOTAL_PRICE_OF_ITEM_ON_CONFIRMATION_POPUP)
                .replace("$", "").replace(",", ""));
    }


    public QuickViewPage inputQuantity(long quantity) {
        waitTillProgressScreenDisappears();
        switchToIframe(IFRAME);
        $x(QUANTITY_INPUT).clear();
        inputTextInField(QUANTITY_INPUT, String.valueOf(quantity));
        return this;
    }


    public boolean isNullQuantityNotificationDisplayed() {
        return $x(NULL_QUANTITY_NOTIFICATION).shouldBe(Condition.visible, Duration.ofSeconds(5)).isDisplayed();
    }

    public CategoryWomanPage closeNullQuantityNotification() {
        clickWhenVisibleInMillis(CLOSE_NULL_QUANTITY_NOTIFICATION, 2000);
        return new CategoryWomanPage();
    }
}
