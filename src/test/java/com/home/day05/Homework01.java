package com.home.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homework01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getWebDriver("chrome");
        driver.get("file:///D:/scripts/iframe/a.html");
        //分别输入AAA,BBB,CCC
        driver.findElement(By.id("aa")).sendKeys("AAA");
        driver.switchTo().frame("bframe");
        driver.findElement(By.id("bb")).sendKeys("BBB");
        driver.switchTo().frame("cframe");
        driver.findElement(By.id("cc")).sendKeys("CCC");

        //将第二个输入框的BBB改为DDD
        driver.switchTo().parentFrame();
        driver.findElement(By.id("bb")).clear();
        driver.findElement(By.id("bb")).sendKeys("DDD");

        //回到第一个输入框输入完成
        driver.switchTo().defaultContent();
        driver.findElement(By.id("aa")).sendKeys("完成");
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
