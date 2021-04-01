package org.example;

import org.example.categories.CategoryWomanPage;
import org.example.model.QuickViewItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class QuickViewPageTest extends BaseTest {


    private HomePage homePage;
    private CategoryWomanPage categoryWomanPage;
    private QuickViewPage quickViewPage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage();
        categoryWomanPage = new CategoryWomanPage();
        quickViewPage = new QuickViewPage();
    }


    @Test
    public void dupa() {
        QuickViewItem itemDetails = homePage.openMe()
                .clickWomenButton()
                .moveMouseToItemContainerOnIndex(1)
                .clickQuickViewButtonOnIndex(1)
                .getItemDetails();

        System.out.println(itemDetails.getPrice());
        System.out.println(itemDetails.getAvailableColors());
        System.out.println(itemDetails.getAvailableSizes());
        System.out.println(itemDetails.getPictureUrls());
    }


    @Test
    public void urlOfDisplayedPictureShouldBeTheSameAsUrlOfThumbnailOnIndex2() {
        String urlOfThumbnailOnIndex = homePage.openMe()
                .clickWomenButton()
                .clickQuickViewButtonOnIndex(2)
                .hoverMouseOverPictureThumbnailOnIndex(2)
                .getUrlOfThumbnailOnIndex(2);

        String urlOfDisplayedPicture = quickViewPage.getUrlOfThumbnailOnIndex(2);
        System.out.println(urlOfDisplayedPicture);
        System.out.println(urlOfThumbnailOnIndex);
        assertEquals(urlOfThumbnailOnIndex, urlOfDisplayedPicture);

    }


    @Test
    public void shouldOpenItemOnIndex4AndClick100TimesPlusButton() {
        int items = 100;
        BigDecimal numbersOfItemsAddedToCart = homePage.openMe()
                .clickWomenButton()
                .moveMouseToItemContainerOnIndex(4)
                .clickQuickViewButtonOnIndex(4)
                .clickPlusButtonNTimes(items)
                .clickAddToCartButton()
                .getNumbersOfItemsAddedToCart();

        BigDecimal totalPriceOfPurchasedItem = quickViewPage.getTotalPriceOfPurchasedItem();

        assertEquals(numbersOfItemsAddedToCart, new BigDecimal(String.valueOf(items)).add(new BigDecimal("1")));
        assertEquals(totalPriceOfPurchasedItem, new BigDecimal("5149.99"));
    }



    @Test
    public void shouldInputQuantity9999999999AndVerifyThatNumberOnConfirmationPopup() {
        long items = 9999999999l;
        BigDecimal numbersOfItemsAddedToCart = homePage.openMe()
                .clickWomenButton()
                .moveMouseToItemContainerOnIndex(2)
                .clickQuickViewButtonOnIndex(2)
                .inputQuantity(items)
                .clickAddToCartButton()
                .getNumbersOfItemsAddedToCart();

        BigDecimal totalPriceOfPurchasedItem = quickViewPage.getTotalPriceOfPurchasedItem();

//        assertEquals(numbersOfItemsAddedToCart, new BigDecimal(String.valueOf(items)));
        BigDecimal result = new BigDecimal("27.00").multiply(new BigDecimal(String.valueOf(items)));
        System.out.println(result);
        assertEquals(totalPriceOfPurchasedItem, new BigDecimal("27.00").multiply(new BigDecimal(String.valueOf(items))));
    }

    @Test
    public void shouldDisplayNullQuantityWhenOIsInputInQuantityField() {
        homePage.openMe()
                .clickWomenButton()
                .moveMouseToItemContainerOnIndex(2)
                .clickQuickViewButtonOnIndex(2)
                .inputQuantity(0)
                .clickAddToCartButton();

        assertTrue(quickViewPage.isNullQuantityNotificationDisplayed());
    }

}
