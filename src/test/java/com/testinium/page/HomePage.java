package com.testinium.page;

import com.testinium.methods.BaseMethod;
import com.testinium.methods.ClickHelper;
import com.testinium.methods.SelectHelper;
import com.testinium.methods.SendKeysHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage {
    SendKeysHelper sendKeysHelper = new SendKeysHelper();
    BaseMethod baseMethod = new BaseMethod();

    ClickHelper clickHelper = new ClickHelper();

    SelectHelper selectHelper = new SelectHelper();

    public void searchProduct(String productName) {
        returnHomePage();
        sendKeysHelper.sendKeys(By.id("search-input"), productName);
        sendKeysHelper.sendKeys(By.id("search-input"), Keys.ENTER);
    }

    public void returnHomePage() {
        baseMethod.navigateTo("https://www.kitapyurdu.com/");
    }

    public void openFavPage() {
        clickHelper.hoverElement(By.cssSelector("div.menu.top.my-list"));
        clickHelper.clickElement(By.xpath("//a[text()='Favorilerim']"));
    }

    public void openPointsPageAndTurkClassics(String sortBy) {
        clickHelper.clickElement(By.cssSelector("div a.common-sprite[href='puan-katalogu']"));
        clickHelper.clickElement(By.cssSelector("img[title='Puan Kataloğundaki Türk Klasikleri']"));
        selectHelper.selectByText(By.cssSelector(".product-filter-header div.sort select"), sortBy);
    }

    public void openAllBooksMenuClickHobi() {
        clickHelper.hoverElement(By.xpath("//li/span[text()='Tüm Kitaplar']"));
        clickHelper.clickElement(By.cssSelector("a[href='kategori/kitap-hobi/1_212.html']"));
    }

    public String getFavoriteSize() {
        return baseMethod.getText(By.cssSelector("span.favorite-tag.active span"));
    }

    public void openCart() {
        clickHelper.clickElement(By.id("cart-items"));
        clickHelper.clickElement(By.id("js-cart"));
    }
}
