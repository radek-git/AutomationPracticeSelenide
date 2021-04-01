package org.example.categories;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.QuickViewPage;
import org.example.ShoppingCartPage;
import org.example.model.QuickViewItem;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CategoryWomanPage extends CategoryBasePage {

    private QuickViewPage quickViewPage = new QuickViewPage();

    public static final String CATEGORY_TOPS = "//div[@id='layered_block_left']/div/form/div/div/ul[@id='ul_layered_category_0']/li[./div[@id='uniform-layered_category_4'] ]";
    public static final String CATEGORY_DRESSES = "//div[@id='layered_block_left']/div/form/div/div/ul[@id='ul_layered_category_0']/li[./div[@id='uniform-layered_category_8'] ]";
    public static final String LOADING_PROGRESS = "//ul[contains(@class, 'product_list')]/p/img";
    public static final String SORT_BY_SELECT = "//div[contains(@class, 'sortPagiBar clearfix')]/form/div/div/select";
    public static final String SORT_BY_OPTION = "//div[contains(@class, 'sortPagiBar clearfix')]/form/div/div/select/option";
    public static final String SORT_BY_OPTION_CONTAINING_TEXT = "//div[contains(@class, 'sortPagiBar clearfix')]/form/div/div/select/option[text()='%s']";
    public static final String CATEGORY_WOMEN_TOPS_BUTTON = "//div[@class='block_content']/ul/li/a[contains(text(), 'Tops')]";
    public static final String CATEGORY_WOMEN_DRESSES_BUTTON = "//div[@class='block_content']/ul/li/a[contains(text(), 'Dresses')]";
    public static final String ITEM_DISPLAYED_ON_INDEX = "(//div[@id='center_column']/ul/li)[%d]";
    public static final String DISPLAYED_ITEMS = "//div[@id='center_column']/ul/li";
    public static final String PROCEED_TO_CHECKOUT_BUTTON = "//a[@title='Proceed to checkout']";
    public static final String CONTINUE_SHOPPING_BUTTON = "//div[@class='button-container']/span[@title='Continue shopping']";
    public static final String CART_DIV = "//div[@class='shopping_cart']/a";








    public CategoryWomanPage clickCategoryTopsButton() {
        clickWhenVisibleInMillis(CATEGORY_TOPS, 5000);
        return this;
    }


    public CategoryWomanPage clickCategoryDressesButton() {
        clickWhenVisibleInMillis(CATEGORY_DRESSES, 5000);
        return this;
    }



    public QuickViewPage clickQuickViewButtonOnIndex(int index) {
//        moveMouseToElement(ITEM_CONTAINER);
        $x(String.format(QUICK_VIEW_BUTTON_ON_INDEX, index)).shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
//        clickWhenVisibleInMillis(QUICK_VIEW_BUTTON, 3000);
        return new QuickViewPage();
    }

    public int getNumberOfDisplayedItems() {
        return $$x(DISPLAYED_ITEMS).size();
    }



    public List<QuickViewItem> getDetailedInfoAboutEachDisplayedItem() {
        List<QuickViewItem> detailedItems = new ArrayList<>();

        for (int i = 1; i <= getNumberOfDisplayedItems(); i++) {
            moveMouseToItemContainerOnIndex(i);
            clickQuickViewButtonOnIndex(i);
            detailedItems.add(quickViewPage.getItemDetails());
            quickViewPage.clickCloseButton();

        }
        return detailedItems;
    }


    public CategoryWomanPage clickAddToCartButtonOnIndexForNTimes(int index, int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            clickWhenVisibleInMillis(String.format(ADD_TO_CART_BUTTON_ON_INDEX, index), 10000);
        }
        return this;
    }

    public ShoppingCartPage clickProceedToCheckoutButton() {
        clickWhenVisibleInMillis(PROCEED_TO_CHECKOUT_BUTTON, 5000);
        return new ShoppingCartPage();
    }

    public CategoryWomanPage clickContinueShoppingButton() {
        $x("//div[@class='clearfix']/div[contains(@class, 'ayer_cart_cart')]")
                .shouldBe(Condition.visible, Duration.ofSeconds(5));
        clickWhenVisibleInMillis(CONTINUE_SHOPPING_BUTTON, 10000);
        return this;
    }


    public CategoryWomanPage moveMouseToCartField() {
        moveMouseToElement(CART_DIV);
        return this;
    }

    public BigDecimal getTotalPriceFromCartDropdown() {
        return new BigDecimal(getTextFromElement(CART_DROPDOWN_TOTAL_PRICE_SPAN).replace("$", "")
        .replace(" ", ""));
    }

    public BigDecimal getProductPriceFromCartDropdown() {
        return new BigDecimal(getTextFromElement(CART_DROPDOWN_PRODUCT_PRICE_SPAN).replace("$", "")
                .replace(" ", ""));
    }


//    public void removeAllProductsInCartDropdown() {
//        boolean isCloseButtonDisplayed;
//
//        do {
//            isCloseButtonDisplayed = $x(CART_DROPDOWN_PRODUCT_REMOVE_BUTTON).shouldBe(Condition.visible, Duration.ofSeconds(10)).exists();
//            if (isCloseButtonDisplayed) {
//                clickWhenVisibleInMillis(CART_DROPDOWN_PRODUCT_REMOVE_BUTTON, 15000);
//            }
//        } while (isCloseButtonDisplayed);
//    }

    public String getTextFromCartField() {
        return getTextFromElement(CART_DROPDOWN_FIELD);
    }


    public void removeAllProductsFromCart() {
        List<SelenideElement> elements = $$x(CART_DROPDOWN_PRODUCTS);
        for (int i = 1; i <=elements.size(); i++) {
            clickWhenVisibleInMillis(String.format(CART_DROPDOWN_REMOVE_BUTTON_ON_INDEX, i), 15000);
        }
    }

}
