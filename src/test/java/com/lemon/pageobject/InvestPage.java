package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvestPage extends BasePage {

    public InvestPage(WebDriver webDriver){
        super(webDriver);
    }

    private By typeAmount = By.xpath("//input[@data-url='/Invest/invest']");
    private By bidButton = By.xpath("//button[text()='投标']");
    private By bidSuccessMsg = By.xpath("//div[text()='投标成功！']");
    private By bidLeaveAmount = By.className("mo_span4");

    public void clickBidDetail(String loanTitle){
        By bidChoose = By.xpath("//span[text()='"+loanTitle+"']/parent::a");
        click(bidChoose);
    }

    public void typeAmount(String amount){
        type(typeAmount,amount);
    }

    public void clickBid(){
        click(bidButton);
    }

    public boolean bidSuccessMsg(){
        return isDisplay(bidSuccessMsg);
    }

    public String getUserAmount(){
        return getElementAttributeValue(typeAmount,"data-amount");
    }

    public String getBidLeavAmount(){
        return getElementText(bidLeaveAmount);
    }

}
