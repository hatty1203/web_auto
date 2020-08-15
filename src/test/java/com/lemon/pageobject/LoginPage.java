package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import com.lemon.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By mobilephone = By.name("phone");
    private By password = By.name("password");
    private By loginbutton = By.xpath("//button[text()='登录']");
    private By centermsg = By.className("layui-layer-content");

    private By errorMsg = By.cssSelector(".form-error-info");

    public LoginPage(WebDriver webdriver){
        super(webdriver);
    }

    public void typeMobilephone(String phonenum){
        type(mobilephone, phonenum);
    }

    public void typePassword(String pwd){
        type(password,pwd);
    }

    public void clickLogin(){
        click(loginbutton);
    }

    public String getCenterMsg(){
        return getElementText(centermsg);
    }

    public String getErrorMsg(){
        return getElementText(errorMsg);
    }

}
