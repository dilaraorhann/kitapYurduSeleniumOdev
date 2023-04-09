package com.testinium.page;

import com.testinium.methods.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage {
    BaseMethod baseMethod = new BaseMethod();

    public void productScrollWithIndex(int order) {
        List<WebElement> productList = baseMethod.findElements(By.cssSelector("#product-table div.product-cr"));
        baseMethod.scrollWithJavaScript(productList.get(order + 1));
    }

    public void productAddFavouriteAndControl() {
        List<WebElement> productList = baseMethod.findElements(By.cssSelector("#product-table div.product-cr a.add-to-favorites"));
        int count = 0;
        for (WebElement favElement : productList) {
            baseMethod.scrollWithJavaScript(favElement);
            baseMethod.waitSeconds(1);
            //System.out.println("Element: " + favElement.findElement(By.tagName("a")));
            baseMethod.forceClick(favElement);
            //favElement.click();
            count += 1;
            baseMethod.waitSeconds(1);
            if (count == 4) {
                break;
            }
        }
    }

    public void randomProductAddBasket() {
        List<WebElement> productList = baseMethod.findElements(By.cssSelector("div.product-cr a.add-to-cart"));
        Random random = new Random();
        baseMethod.forceClick(productList.get(random.nextInt(productList.size() - 1)));
    }
}
