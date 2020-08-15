package com.lemon.commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //日志对象
    private Logger logger = Logger.getLogger(BasePage.class);

    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }


    public WebElement isVisible(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement isClickable(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void type(By by, String value){
        isVisible(by).clear();
        isVisible(by).sendKeys(value);
        logger.info("在元素【"+by+"】输入了数据【"+value+"】");
    }

    public void typeKey(By by, Keys keys){
        isVisible(by).sendKeys(keys);
        logger.info("点击了按键【"+keys.name()+"】");
    }

    public void click(By by){
        isClickable(by).click();
        logger.info("点击了元素【"+by+"】");
    }

    public String getElementText(By by){
        String elementText = isVisible(by).getText();
        logger.info("获取元素【"+by+"】文本值【"+elementText+"】");
        return elementText;
    }

    public String getElementAttributeValue(By by, String attribute){
        String elementValue = isVisible(by).getAttribute(attribute);
        logger.info("获取元素【"+by+"】属性【"+attribute+"】的值【"+elementValue+"】");
        return elementValue;
    }

    public boolean isDisplay(By by){
        return isVisible(by).isDisplayed();
    }

    public void switchIframe(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        logger.info("切换iframe【"+by+"】");
    }

    public void scrollPage(By by){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(0)", isVisible(by));
    }
}
