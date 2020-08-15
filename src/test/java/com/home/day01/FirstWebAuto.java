package com.home.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FirstWebAuto {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = getWebDriver("chrome");
        if(wd!=null){
            wd.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
            WebElement ele1 = wd.findElement(By.id("treeDemo_2_span"));
            WebElement ele2 = wd.findElement(By.id("treeDemo_3_span"));
            Actions actions = new Actions(wd);
            Thread.sleep(2000);
            actions.clickAndHold(ele1).dragAndDrop(ele1,ele2).release().perform();
        }else {
            System.out.println("浏览器名称错误");
        }


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
