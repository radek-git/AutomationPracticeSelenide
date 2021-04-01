package org.example.categories;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.example.model.PosterItem;
import org.example.model.QuickViewItem;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CategoryBasePage extends BasePage {

    public static final String MAIN_SECTION_CATEGORIES = "//div[@id='left_column']/div[@id='categories_block_left']/div/ul/li";
    public static final String MAIN_SECTION_CATEGORY_NAME = "//div[@id='left_column']/div[@id='categories_block_left']/div/ul/li/a";
    public static final String MAIN_WOMEN_SECTION_DIV = "//div[@id='left_column']/div[@id='categories_block_left']";
    public static final String SUBCATEGORIES_CATEGORIES = "//div[@id='subcategories']/ul/li";
    public static final String SUBCATEGORIES_DIV = "//div[@id='subcategories']";
    public static final String CENTER_COLUMN_DIV = "//div[@id='center_column']/h1";
    public static final String COUNTER_TEXT = "//div[@id='center_column']/h1/span[@class='heading-counter']";
    public static final String ITEM_CONTAINER = "//div[@class='product-container']";
    public static final String ITEM_CONTAINER_ON_INDEX = "(//div[@class='product-container'])[%d]";
    public static final String IMG_ON_INDEX = "(//div[@class='product-container']/div/div/a/img)[%d]";
    public static final String ITEM_NAME_ON_INDEX = "(//div[@class='product-container']/div[@class='right-block']/h5/a)[%d]";
    public static final String ITEM_PRICE_ON_INDEX = "(//div[@class='product-container']/div[@class='right-block']/div[@class='content_price']/span[@itemprop='price'])[%d]";
    public static final String QUICK_VIEW_BUTTON = "//div[@class='product-image-container']/a[@class='quick-view']";
    public static final String QUICK_VIEW_BUTTON_ON_INDEX = "(//div[@class='product-image-container']/a[@class='quick-view'])[%d]";
    public static final String ADD_TO_CART_BUTTON = "//div[@class='right-block']/div/a[contains(@class, 'ajax_add_to_cart_button')]";
    public static final String ADD_TO_CART_BUTTON_ON_INDEX = "(//div[@class='right-block']/div/a[contains(@class, 'ajax_add_to_cart_button')])[%d]";
    public static final String MORE_BUTTON = "//div[@class='right-block']/div/a[@title='View']";
    public static final String RELOADING_PAGE_PROGRESS = "//ul[contains(@class, 'product_list')]/p/img";
    public static final String PROGRESS_ICON = "//div[@id='fancybox-loading']";
    public static final String IFRAME = "//iframe";
    public static final String CART_DROPDOWN = "//div[@class='shopping_cart']/div[contains(@class, 'cart_block')]/div[@class='block_content']";
    public static final String CART_DROPDOWN_TOTAL_PRICE_SPAN = "//div[@class='shopping_cart']/div[contains(@class, 'cart_block')]/div[@class='block_content']/div/div/div/span[contains(@class, 'cart_block_total')]";
    public static final String CART_DROPDOWN_SHIPPING_COST_SPAN = "//div[@class='shopping_cart']/div[contains(@class, 'cart_block')]/div[@class='block_content']/div/div/div/span[contains(@class, 'cart_block_shipping_cost')]";
    public static final String CART_DROPDOWN_PRODUCT_PRICE_SPAN = "//div[@class='shopping_cart']/div[contains(@class, 'cart_block')]/div[@class='block_content']/div/dl/dt/div/span[@class='price']";
    public static final String CART_DROPDOWN_CHECKOUT_BUTTON = "//p[@class='cart-buttons']/a[@title='Check out']";
    public static final String CART_DROPDOWN_PRODUCTS ="//div[@class='cart_block_list']/dl/dt";
    public static final String CART_DROPDOWN_PRODUCT_REMOVE_BUTTON = "//div[@class='cart_block_list']/dl/dt/span[@class='remove_link']";
    public static final String CART_DROPDOWN_FIELD = "//div[@class='shopping_cart']/a/span[@class='ajax_cart_no_product']";
    public static final String CART_DROPDOWN_REMOVE_BUTTON_ON_INDEX = "(//div[@class='cart_block_list']/dl/dt/span[@class='remove_link']/a)[%d]";




    public int getNumberOfCategoriesInMainSection() {
        ElementsCollection selenideElements = $$x(MAIN_SECTION_CATEGORIES);
        return selenideElements.size();
    }

    public List<String> getNamesOfCategoriesInMainSection() {
        $x(MAIN_WOMEN_SECTION_DIV).shouldBe(Condition.visible, Duration.ofSeconds(5));
        List<String> categories = new ArrayList<>();

        ElementsCollection selenideElements = $$x(MAIN_SECTION_CATEGORY_NAME);
        for (SelenideElement selenideElement : selenideElements) {
            categories.add(selenideElement.getText());
        }
        return categories;
    }

    public int getNumberOfCategoriesInSubcategoriesSection() {
        waitForElement(SUBCATEGORIES_DIV, 3);
        return $$x(SUBCATEGORIES_CATEGORIES).size();
    }

    public int getNumberOfItemsOnCounter() {
        waitForElement(CENTER_COLUMN_DIV, 3);
        String itemsText = getTextFromElement(COUNTER_TEXT).replace("There are ", "").replace(" products.", "");
        return Integer.parseInt(itemsText);
    }

    public int getNumberOfDisplayedItems() {
        return $$x(ITEM_CONTAINER).size();
    }

    public List<PosterItem> getItems() {
        List<SelenideElement> elements = $$x(ITEM_CONTAINER);
        List<PosterItem> PosterItems = new ArrayList<>();

        for (int i = 1; i <= elements.size(); i++) {
            String imgLink = $x(String.format(IMG_ON_INDEX, i)).getAttribute("src");
            String name = $x(String.format(ITEM_NAME_ON_INDEX, i)).getText();
            BigDecimal price = new BigDecimal($x(String.format(ITEM_PRICE_ON_INDEX, i)).getText()
                    .replace(" ", "").replace("$", ""));

            PosterItems.add(new PosterItem(name, price, imgLink));
        }
        return PosterItems;
    }

    public CategoryWomanPage moveMouseToItemContainerOnIndex(int index) {
        moveMouseToElement(String.format(ITEM_CONTAINER_ON_INDEX, index));
        return new CategoryWomanPage();
    }

    public boolean isAddToCartButtonDisplayed() {
        return isElementVisible(ADD_TO_CART_BUTTON, 3);
    }

    public boolean isMoreButtonDisplayed() {
        return isElementVisible(MORE_BUTTON, 5);
    }

    public boolean isCategoryResultLoaded() {
        return !$x(RELOADING_PAGE_PROGRESS).shouldBe(Condition.visible, Duration.ofMillis(30000)).isDisplayed();
    }


    public void waitTillProgressScreenDisappears() {
        $x(PROGRESS_ICON).should(Condition.disappear, Duration.ofMillis(60000));
    }




}
