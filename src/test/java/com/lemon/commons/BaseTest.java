package com.lemon.commons;

import com.lemon.utils.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    private Logger logger = Logger.getLogger(BaseTest.class);

    public WebDriver driver;

    public void getWebDriver(String webType){
        if(webType.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            ChromeDriver cd = new ChromeDriver();
            driver = cd;
            logger.info("====================================打开Chrome浏览器=============================");
        }else if(webType.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            System.setProperty("webdriver.firefox.bin","D:/sofware/firefox/firefox.exe");
            FirefoxDriver fd = new FirefoxDriver();
            driver = fd;
            logger.info("====================================打开Firefox浏览器=============================");
        }
    }

    public void getUrl(String url){
        logger.info("访问对应URL【"+url+"】");
        driver.get(url);
    }

    public void getMaxWindow(){
        logger.info("浏览器最大化");
        driver.manage().window().maximize();
    }

    public void browserBack(){
        logger.info("页面回退");
        driver.navigate().back();
    }

    public void browserForward(){
        logger.info("页面前进");
        driver.navigate().forward();
    }

    public void browserFresh(){
        logger.info("页面刷新");
        driver.navigate().refresh();
    }

    public void browserQuit(){
        logger.info("浏览器退出");
        driver.quit();
    }
    public void browserTo(String url){
        driver.navigate().to(url);
    }
}
