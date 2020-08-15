package com.lemon.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class ScreenShotUtils {
    public static byte[] screenShotByte(WebDriver driver){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        byte[] arr = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return arr;
    }


    public static void screenShotFile(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("screenShot.png"));
        int b;
        while((b = bis.read())!=-1){
            bos.write(b);
        }
        bis.close();
        bos.close();
    }
}
