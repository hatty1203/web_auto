package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import com.lemon.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BackStagePage extends BasePage {

    public BackStagePage(WebDriver webDriver){
        super(webDriver);
    }

    private By lendManage = By.xpath("//span[text()='借款管理']");
    private By addBid = By.xpath("//span[text()='加标']");
    private By iframe = By.id("mainFrame");
    private By lender = By.xpath("//input[@placeholder='输入手机号码进行查找']");
    private By lendTitle = By.xpath("//td[text()='贷款标题:']/following-sibling::td/input");
    private By loadRate = By.xpath("//input[@name='LoanRate']");
    private By loadTerm = By.xpath("//input[@name='LoanTerm']");
    private By amount = By.xpath("//input[@name='Amount']");
    private By biddingDays = By.xpath("//input[@name='BiddingDays']");
    private By riskManageTab = By.xpath("//span[text()='风控评测']");
    private By evaluAmount = By.xpath("//input[@name='EvaluAmount']");
    private By projEnterTab = By.xpath("//span[text()='项目录入']");
    private By navitePlace = By.xpath("//input[@name='Native']");
    private By profession = By.xpath("//input[@name='Profession']");
    private By ageInput = By.xpath("//input[@name='Age']");
    private By submitButton = By.xpath("//span[text()='提交']");
    private By lastBid = By.id("datagrid-row-r1-2-0");
    private By auditButton = By.xpath("//span[text()='审核']");
    private By passAudit = By.xpath("//span[text()='审核通过']");
    private By regretLiquidated = By.xpath("//input[@name='RegretLiquidated']");
    private By autoInvestRate = By.xpath("//input[@name='AutoInvestRate']");

    public void clickLendManage(){
        click(lendManage);
    }

    public void clickAddBid(){
        switchIframe(iframe);
        click(addBid);
    }

    public void switchiframe(){
        switchIframe(iframe);
    }
    public void typeLenderPhone(String phone){
        type(lender, phone);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeKey(lender, Keys.ARROW_DOWN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeKey(lender,Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void typeLendTitle(String title){
        type(lendTitle, title);
    }

    public void typeLoadRate(String rate){
        type(loadRate, rate);
    }

    public void typeloadTerm(String term){
        type(loadTerm, term);
    }

    public void typeAmount(String amountnum){
        type(amount, amountnum);
    }

    public void typeBiddingDays(String days){
        type(biddingDays, days);
    }

    public void clickRiskManageTab(){
        click(riskManageTab);
    }

    public void typeEvaluAmount(String evalue){
        type(evaluAmount,evalue);
    }

    public void clickProjEnterTab(){
        click(projEnterTab);
    }

    public void typeNavitePlace(String place){
        type(navitePlace,place);
    }

    public void typeProfession(String job){
        type(profession, job);
    }

    public void typeAge(String age){
        type(ageInput, age);
    }

    public void clickSubmit(){
        click(submitButton);
    }

    public void chooseLastBid(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(lastBid);
    }

    public void clickAudit(){
        click(auditButton);
    }

    public void scroll2passButton(){
        scrollPage(passAudit);
    }

    public void clickPassAudit(){
        click(passAudit);
    }


}
