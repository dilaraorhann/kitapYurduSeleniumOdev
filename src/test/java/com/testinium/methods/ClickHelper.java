package com.testinium.methods;

import com.testinium.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ClickHelper extends BaseMethod {

    public void clickElement(By by) {
        // Var olmasını bekledim.
        waitUntilElementPresence(by);
        // Gerekliyse scroll yaptım.
        scrollWithJavaScript(by);
        // Görünür olmasını bekledim.
        waitUntilElementVisible(by);
        // Son olarak tıklama işlemi
        findElement(by).click();
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(BaseTest.getDriver());
        actions.moveToElement(findElement(by)).build().perform();
    }
}
