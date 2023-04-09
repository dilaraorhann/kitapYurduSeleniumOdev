package com.testinium.test;

import com.testinium.base.BaseTest;
import com.testinium.page.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @Before
    public void before() {
        loginPage = new LoginPage();
    }

    @Test
    public void loginStepsControlTest() {
        loginPage.loginSteps();
        Assert.assertEquals("İsim uyuşmuyor!!!", "Dilara Orhan", loginPage.getLoginName());
    }

    @After
    public void afterTearDown() {
        // Şimdilik boş
    }
}
