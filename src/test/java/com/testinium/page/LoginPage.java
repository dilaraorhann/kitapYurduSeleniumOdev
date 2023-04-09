package com.testinium.page;

import com.testinium.methods.ClickHelper;
import com.testinium.methods.SendKeysHelper;
import org.openqa.selenium.By;

public class LoginPage {
    ClickHelper clickHelper = new ClickHelper();
    SendKeysHelper sendKeysHelper = new SendKeysHelper();

    public void loginSteps() {
        clickHelper.clickElement(By.xpath("//div[@class='menu-top-button login']"));
        clickHelper.clickElement(By.id("js-popup-accept-button"));
        sendKeysHelper.sendKeys(By.id("login-email"), "diorhan17@gmail.com");
        sendKeysHelper.sendKeys(By.id("login-password"), "*Ktp1907.17");
        clickHelper.clickElement(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        clickHelper.waitSeconds(2);
    }

    public String getLoginName() {
        // Login olunan kişinin ismini getirir.
        return sendKeysHelper.getText(By.cssSelector("a.common-sprite b"));
    }
}
