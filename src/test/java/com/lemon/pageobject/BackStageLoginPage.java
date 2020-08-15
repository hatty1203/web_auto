package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import com.lemon.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackStageLoginPage extends BasePage {

    public BackStageLoginPage(WebDriver webDriver){
        super(webDriver);
    }
    private By user = By.name("admin_name");
    private By password = By.name("admin_pwd");
    private By verifycode = By.name("code");
    private By loginbutton = By.xpath("//button[text()='登陆后台']");

    public void typeUsername(String username){
        type(user, username);
    }
    public void typePassword(String pwd){
        type(password, pwd);
    }
    public void typeVerifyCode(String code){
        type(verifycode, code);
    }
    public void clickLogin(){
        click(loginbutton);
    }


}
