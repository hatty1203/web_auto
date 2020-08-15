package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import com.lemon.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {
    public IndexPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By account = By.xpath("//a[contains(text(),'"+ Constants.NICKNAME +"')]");
    private By bidLinkText = By.xpath("//a[text()='投标']");


    public boolean isNicknameVisible(){
        return isDisplay(account);
    }

    public void clickBid(){
        click(bidLinkText);
    }
}
