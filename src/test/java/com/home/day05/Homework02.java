package com.home.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getWebDriver("chrome");
        driver.get("http://www.lemfix.com/");
        //登录
        driver.findElement(By.xpath("//a[text()='登录']")).click();
        WebDriverWait wait_login = new WebDriverWait(driver,10);
        By by_login = By.id("user_login");
        WebElement element_login = wait_login.until(ExpectedConditions.presenceOfElementLocated(by_login));
        element_login.sendKeys("Hatty");
        driver.findElement(By.id("user_password")).sendKeys("xxxxxx");
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.btn-block")).click();
        //点击进入文章
        WebDriverWait wait_article = new WebDriverWait(driver,10);
        By by_article = By.xpath("//a[@title='Flutter 自动化测试-集成测试篇']");
        WebElement element = wait_article.until(ExpectedConditions.presenceOfElementLocated(by_article));
        element.click();
        //滚动到回帖区，回帖
        WebDriverWait wait_follow = new WebDriverWait(driver,10);
        By by_follow = By.cssSelector(".follow.btn.btn-default");
        wait_follow.until(ExpectedConditions.presenceOfElementLocated(by_follow));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("document.getElementById('reply_body').scrollIntoView()");
        driver.findElement(By.id("reply_body")).sendKeys("homework-day06-hatty");
        driver.findElement(By.id("reply-button")).click();
    }

    public static WebDriver getWebDriver(String webType){
        if(webType.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            ChromeDriver cd = new ChromeDriver();
            return cd;
        }else if(webType.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            System.setProperty("webdriver.firefox.bin","D:/sofware/firefox/firefox.exe");
            FirefoxDriver fd = new FirefoxDriver();
            return fd;
        }

        return null;
    }
}
