package com.testinium.test;

import com.testinium.base.BaseTest;
import com.testinium.page.CartPage;
import com.testinium.page.HomePage;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ProductPageTest extends BaseTest {

    ProductPage productPage;
    HomePage homePage;

    LoginPage loginPage;

    CartPage cartPage;

    @Before
    public void before() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        homePage = new HomePage();
        cartPage = new CartPage();
    }

    @Test
    public void productSearchAndFavourite() throws InterruptedException {
        loginPage.loginSteps();
        homePage.searchProduct("Oyuncak");
        productPage.productScrollWithIndex(7);
        TimeUnit.SECONDS.sleep(5);
        productPage.productAddFavouriteAndControl();
        homePage.returnHomePage();
        homePage.openFavPage();
        TimeUnit.SECONDS.sleep(5);
        Assert.assertEquals("Kitap favori sayısı yetersiz!!", "4", homePage.getFavoriteSize());
        homePage.returnHomePage();
        homePage.openAllBooksMenuClickHobi();
        homePage.openPointsPageAndTurkClassics("Yüksek Oylama");
        productPage.randomProductAddBasket();
        homePage.openFavPage();
        homePage.openCart();
        cartPage.cartQuantityUpdate("2");
        cartPage.buyProduct();
        cartPage.setNewAddressAndContinue();
        cartPage.setDebitCard();
        Assert.assertEquals("Kart numarası hatası alınmadı!!!", "Kart numarası geçersiz. Kontrol ediniz!", cartPage.getErrorMessage());
    }
}
