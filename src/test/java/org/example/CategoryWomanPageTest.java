package org.example;

import org.example.categories.CategoryWomanPage;
import org.example.model.PosterItem;
import org.example.model.QuickViewItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.testng.Assert.*;

public class CategoryWomanPageTest extends BaseTest {


    private HomePage homePage;
    private CategoryWomanPage categoryWomanPage;


    @BeforeMethod
    public void before() {
        homePage = new HomePage();
        categoryWomanPage = new CategoryWomanPage();
    }

    @Test
    public void shouldOpenCategoryWoman() {
        homePage.openMe().clickWomenButton();
        assertEquals(categoryWomanPage.getPageTitle(), "WOMEN");
    }

    @Test
    public void isNumberOfCategoriesInWomenSectionEqual2() {
        int numberOfCategoriesInWomenSection =
                homePage.openMe()
                        .clickWomenButton()
                        .getNumberOfCategoriesInMainSection();

        assertEquals(numberOfCategoriesInWomenSection, 2);
    }

    @Test
    public void shouldVerifyCategoryNamesInWomenSection() {
        List<String> namesOfCategoriesInWomenSection = homePage.openMe().clickWomenButton()
                .getNamesOfCategoriesInMainSection();

        assertEquals(namesOfCategoriesInWomenSection.get(0), "Tops");
        assertEquals(namesOfCategoriesInWomenSection.get(1), "Dresses");
    }

    @Test
    public void numberOfCategoriesInSubcategoriesSectionShouldBe2() {
        int numberOfCategoriesInSubcategoriesSection = homePage.openMe()
                .clickWomenButton()
                .getNumberOfCategoriesInSubcategoriesSection();

        assertEquals(numberOfCategoriesInSubcategoriesSection, 2);
    }

    @Test
    public void numberOfItemsOnCounterShouldBe7() {
        int numberOfItemsOnCounter = homePage.openMe()
                .clickWomenButton()
                .getNumberOfItemsOnCounter();

        assertEquals(numberOfItemsOnCounter, 7);
    }

    @Test
    public void numberOfDisplayedItemsShouldBe7() {
        int numberOfDisplayedItems = homePage.openMe()
                .clickWomenButton()
                .getNumberOfDisplayedItems();

        assertEquals(numberOfDisplayedItems, 7);
    }


    @Test
    public void itemsShouldHaveGivenPrices() {
        List<PosterItem> PosterItems = homePage.openMe()
                .clickWomenButton()
                .getItems();

        assertEquals(PosterItems.get(0).getPrice(), new BigDecimal("16.51"));
        assertEquals(PosterItems.get(1).getPrice(), new BigDecimal("27.00"));
        assertEquals(PosterItems.get(2).getPrice(), new BigDecimal("26.00"));
        assertEquals(PosterItems.get(3).getPrice(), new BigDecimal("50.99"));
        assertEquals(PosterItems.get(4).getPrice(), new BigDecimal("28.98"));
        assertEquals(PosterItems.get(5).getPrice(), new BigDecimal("30.50"));
        assertEquals(PosterItems.get(6).getPrice(), new BigDecimal("16.40"));
    }

    @Test
    public void whenMouseIsMovedToItemContainerThenAddToCartButtonAndMoreButtonShouldBeDisplayed() {
        boolean addToCartButtonDisplayed = homePage.openMe()
                .clickWomenButton()
                .moveMouseToItemContainerOnIndex(1)
                .isAddToCartButtonDisplayed();

        assertTrue(addToCartButtonDisplayed);

        boolean moreButtonDisplayed = categoryWomanPage.isMoreButtonDisplayed();

        assertTrue(moreButtonDisplayed);
    }

    @Test
    public void shouldGetDetailsOfAllDisplayedItems() {
        List<QuickViewItem> detailedInfoAboutEachDisplayedItem = homePage.openMe()
                .clickWomenButton()
                .getDetailedInfoAboutEachDisplayedItem();

        System.out.println(detailedInfoAboutEachDisplayedItem);
        System.out.println(detailedInfoAboutEachDisplayedItem.size());

        assertEquals(detailedInfoAboutEachDisplayedItem.get(0).getName(), "Faded Short Sleeve T-shirts");
        assertEquals(detailedInfoAboutEachDisplayedItem.get(1).getSubtitle(), "demo_2");
        assertEquals(detailedInfoAboutEachDisplayedItem.get(2).getCondition(), "New");
        assertEquals(detailedInfoAboutEachDisplayedItem.get(3).getDescription(), "Printed evening dress with straight sleeves with black thin waist belt and ruffled linings.");
        assertEquals(detailedInfoAboutEachDisplayedItem.get(4).getPrice(), new BigDecimal("28.98"));
        assertEquals(detailedInfoAboutEachDisplayedItem.get(2).getAvailableColors().get(0), "Orange");
    }


    @Test
    public void shouldAdd1ItemOnIndex6AndTotalPriceInCartShouldBe32_50() {
        BigDecimal totalPriceFromCartDropdown = homePage.openMe()
                .clickWomenButton()
                .moveMouseToItemContainerOnIndex(6)
                .clickAddToCartButtonOnIndexForNTimes(6, 1)
                .clickContinueShoppingButton()
                .moveMouseToCartField()
                .getTotalPriceFromCartDropdown();

        System.out.println(totalPriceFromCartDropdown);
    }

    @Test
    public void shouldAddItemOnIndex3ToCartAndVerifyThatPriceInCartIs26() {
        BigDecimal productPriceFromCartDropdown = homePage.openMe()
                .clickWomenButton()
                .moveMouseToItemContainerOnIndex(3)
                .clickAddToCartButtonOnIndexForNTimes(3, 1)
                .clickContinueShoppingButton()
                .moveMouseToCartField()
                .getProductPriceFromCartDropdown();

        System.out.println(productPriceFromCartDropdown);
    }


    @Test
    public void shouldAdd2ProductsAndRemoveThemFromCart() {
        homePage.openMe()
                .clickWomenButton()
                .moveMouseToItemContainerOnIndex(1)
                .clickAddToCartButtonOnIndexForNTimes(1,1)
                .clickContinueShoppingButton()
                .moveMouseToItemContainerOnIndex(3)
                .clickAddToCartButtonOnIndexForNTimes(3,1)
                .clickContinueShoppingButton()
                .moveMouseToCartField()
                .removeAllProductsFromCart();

        assertEquals(categoryWomanPage.getTextFromCartField(), "(empty)");
    }



}
