package com.lemon.testcases;

import com.lemon.commons.BaseTest;
import com.lemon.pageobject.*;
import com.lemon.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;


public class InvestTest extends BaseTest {
    String loanTitle;

    @BeforeMethod
    public void setUp(){
        getWebDriver(Constants.WEBDRIVER);
        getMaxWindow();
        //后台加标
        createBidData();
        //前台登录
        getUrl(Constants.LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilephone(Constants.LOGIN_PHONE);
        loginPage.typePassword(Constants.PWD);
        loginPage.clickLogin();

    }
    public void createBidData() {
        getUrl(Constants.BACKSTAGE_URL);
        //登录后台
        BackStageLoginPage backStageLoginPage = new BackStageLoginPage(driver);
        backStageLoginPage.typeUsername(Constants.BK_USER);
        backStageLoginPage.typePassword(Constants.BK_PWD);
        backStageLoginPage.typeVerifyCode(Constants.VERIFYCODE);
        backStageLoginPage.clickLogin();
        //创建投标项目
        BackStagePage backStagePage = new BackStagePage(driver);
        backStagePage.clickLendManage();
        backStagePage.clickAddBid();
        backStagePage.typeLenderPhone(Constants.LENDER_PHONE);
        long timeVar = System.currentTimeMillis();
        loanTitle = Constants.BIDNAME+timeVar;
        backStagePage.typeLendTitle(loanTitle);
        backStagePage.typeLoadRate("10");
        backStagePage.typeloadTerm("3");
        backStagePage.typeAmount("100000");
        backStagePage.typeBiddingDays("10");
        backStagePage.clickRiskManageTab();
        backStagePage.typeEvaluAmount("200000");
        backStagePage.clickProjEnterTab();
        backStagePage.typeNavitePlace("江苏");
        backStagePage.typeProfession("学生");
        backStagePage.typeAge("20");
        backStagePage.clickSubmit();
        //审核项目
        for(int i=0;i<3;i++) {
            backStagePage.chooseLastBid();
            backStagePage.clickAudit();
            backStagePage.clickPassAudit();
        }
    }

    @Test
    public void investSuccess(){
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickBid();
        InvestPage investPage = new InvestPage(driver);
        investPage.clickBidDetail(loanTitle);
        //获取投标前用户余额与剩余标的金额
        BigDecimal beforeuserLeaveAmount = new BigDecimal(investPage.getUserAmount());
        BigDecimal beforeBidLeaveAmount = new BigDecimal(investPage.getBidLeavAmount());
        investPage.typeAmount("1000");
        investPage.clickBid();
        //断言投标成功弹框
        Assert.assertTrue(investPage.bidSuccessMsg());
        browserFresh();
        BigDecimal afteruserLeaveAmount = new BigDecimal(investPage.getUserAmount());
        BigDecimal afterbidLeaveAmount = new BigDecimal(investPage.getBidLeavAmount());
        BigDecimal actualUserAmount = beforeuserLeaveAmount.subtract(afteruserLeaveAmount);
        BigDecimal actualBidAmount = beforeBidLeaveAmount.subtract(afterbidLeaveAmount);
        System.out.println("user"+actualUserAmount);
        System.out.println("bid"+actualBidAmount);
        Assert.assertTrue(actualUserAmount.compareTo(BigDecimal.valueOf(1000))==0);
        Assert.assertTrue(actualBidAmount.compareTo(BigDecimal.valueOf(0.1))==0);

    }

    @AfterMethod
    public void tearDown(){
        browserQuit();
    }
}
