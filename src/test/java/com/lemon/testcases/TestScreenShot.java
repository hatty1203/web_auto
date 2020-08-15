package com.lemon.testcases;

import com.lemon.commons.BaseTest;
import com.lemon.utils.ScreenShotUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestScreenShot extends BaseTest {
    @BeforeTest
    public void setUp(){
        getWebDriver("Chrome");
        getMaxWindow();
        getUrl("https://wwww.baidu.com");
    }

    @Test
    public void testScreenShot(){
        try {
            ScreenShotUtils.screenShotFile(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown(){
        browserQuit();
    }
}
