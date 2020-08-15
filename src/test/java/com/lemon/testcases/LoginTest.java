package com.lemon.testcases;

import com.lemon.commons.BaseTest;
import com.lemon.listener.TestngRetry;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        getWebDriver(Constants.WEBDRIVER);
        getUrl(Constants.LOGIN_URL);
        getMaxWindow();
    }

    @Test(enabled = false)
    public void testLoginSuccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilephone(Constants.LOGIN_PHONE);
        loginPage.typePassword(Constants.PWD);
        loginPage.clickLogin();

        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,"http://120.78.128.25:8765/Index/index");
        IndexPage indexPage = new IndexPage(driver);
        Assert.assertTrue(indexPage.isNicknameVisible());

    }

    @Test(dataProvider = "getDatas001")
    public void testLoginFailed_001(String phone, String password, String errmesg){
        //输入未注册的手机号和密码，登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilephone(phone);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getCenterMsg(),errmesg);
    }

    @Test(enabled = false,dataProvider = "getDatas002")
    public void testLoginFailed_002(String phone, String pwd, String errmsg) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilephone(phone);
        loginPage.typePassword(pwd);
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getErrorMsg(),errmsg);
    }

    @DataProvider
    public Object[][] getDatas001(){
        Object[][] datas = {
                {Constants.LOGIN_PHONE,"123","!!!帐号或密码错误!"},
                {Constants.UNAUTHORIZED_PHONE, Constants.PWD,"此账号没有经过授权，请联系管理员!"}
        };
        return datas;
    }

    @DataProvider
    public Object[][] getDatas002(){
        Object[][] datas = {
                {Constants.LOGIN_PHONE,"","请输入密码"},
                {"",Constants.PWD,"请输入手机号"},
                {"1585901925", "123456", "请输入正确的手机号"},
                {"158590192534", "123456", "请输入正确的手机号"},
                {"1585901925%", "123456", "请输入正确的手机号"}
        };
        return datas;
    }


    @AfterMethod
    public void tearDown(){
        browserQuit();
    }


}

