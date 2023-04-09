package com.testinium.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SelectHelper extends BaseMethod {

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public void selectByValue(By by, String value) {
        getSelect(by).selectByValue(value);
    }


}
