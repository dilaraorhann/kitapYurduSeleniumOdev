package com.testinium.page;

import com.testinium.methods.ClickHelper;
import com.testinium.methods.SelectHelper;
import com.testinium.methods.SendKeysHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CartPage {
    SendKeysHelper sendKeysHelper = new SendKeysHelper();
    ClickHelper clickHelper = new ClickHelper();

    SelectHelper selectHelper = new SelectHelper();

    public void cartQuantityUpdate(String quantity) {
        sendKeysHelper.sendKeysWithClear(By.name("quantity"), quantity);
        sendKeysHelper.sendKeys(By.name("quantity"), Keys.ENTER);
    }

    public void buyProduct() {
        clickHelper.waitSeconds(5);
        clickHelper.clickElement(By.linkText("Satın Al"));
    }

    public void setNewAddressAndContinue() {
        clickHelper.clickElement(By.cssSelector("a[href='#tab-shipping-new-adress']"));
        sendKeysHelper.sendKeys(By.id("address-firstname-companyname"), "TEST");
        sendKeysHelper.sendKeys(By.id("address-lastname-title"), "TEST");
        selectHelper.selectByText(By.id("address-zone-id"), "İstanbul");
        selectHelper.selectByText(By.id("address-county-id"), "ÜMRANİYE");
        sendKeysHelper.sendKeys(By.id("district"), "ADEM YAVUZ MAH");
        clickHelper.clickElement(By.id("districtautocomplete-list div"));
        sendKeysHelper.sendKeys(By.id("address-address-text"), "TEST TEST TEST ADDRESS");
        sendKeysHelper.sendKeys(By.id("address-mobile-telephone"), "5555555555");
        clickHelper.clickElement(By.id("button-checkout-continue"));
        clickHelper.clickElement(By.id("button-checkout-continue"));
    }

    public void setDebitCard() {
        sendKeysHelper.sendKeys(By.id("credit-card-owner"), "TEST TEST");
        sendKeysHelper.sendKeys(By.id("credit_card_number_1"), "4556");
        sendKeysHelper.sendKeys(By.id("credit_card_number_2"), "5400");
        sendKeysHelper.sendKeys(By.id("credit_card_number_3"), "6070");
        sendKeysHelper.sendKeys(By.id("credit_card_number_4"), "3020");
        selectHelper.selectByText(By.id("credit-card-expire-date-month"), "05");
        selectHelper.selectByText(By.id("credit-card-expire-date-year"), "2026");
        sendKeysHelper.sendKeys(By.id("credit-card-security-code"), "000");
        clickHelper.clickElement(By.id("button-checkout-continue"));
    }

    public String getErrorMessage() {
        return sendKeysHelper.getText(By.cssSelector("span.error"));
    }
}
