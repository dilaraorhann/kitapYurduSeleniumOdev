package com.testinium.methods;

import org.openqa.selenium.By;

public class SendKeysHelper extends BaseMethod {

    public void sendKeys(By by, CharSequence text, boolean... submit) {
        // Var olmasını bekledim.
        waitUntilElementPresence(by);
        // Gerekliyse scroll yaptım.
        scrollWithJavaScript(by);
        // Görünür olmasını bekledim.
        waitUntilElementVisible(by);
        // Son olarak tıklama işlemi
        findElement(by).sendKeys(text);
        if (submit.length > 0 && submit[0]) {
            findElement(by).submit();
        }
    }

    public void sendKeysWithClear(By by, CharSequence text, boolean... submit) {
        // Var olmasını bekledim.
        waitUntilElementPresence(by);
        // Gerekliyse scroll yaptım.
        scrollWithJavaScript(by);
        // Görünür olmasını bekledim.
        waitUntilElementVisible(by);
        // Temizlenir
        findElement(by).clear();
        // Son olarak tıklama işlemi
        findElement(by).sendKeys(text);
        if (submit.length > 0 && submit[0]) {
            findElement(by).submit();
        }
    }
}
