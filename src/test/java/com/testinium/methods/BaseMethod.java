package com.testinium.methods;

import com.testinium.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseMethod {

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BaseTest.getDriver();

    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(BaseTest.getDriver(), 30, 1);
    }

    public WebElement waitUntilElementPresence(By by) {
        return getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitUntilElementVisible(By by) {
        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void scrollWithJavaScript(By by) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded();", findElement(by));
    }

    public void scrollWithJavaScript(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void forceClick(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public WebElement findElement(By by) {
        return getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return getWebDriverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitSeconds(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateTo(String url) {
        BaseTest.getDriver().navigate().to(url);
    }
}
