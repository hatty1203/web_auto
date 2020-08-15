package com.lemon.listener;

import com.lemon.commons.BaseTest;
import com.lemon.utils.ScreenShotUtils;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.IOException;

public class TestResultListener implements IHookable {

    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        iHookCallBack.runTestMethod(iTestResult);
        if(iTestResult.getThrowable() !=null){
            BaseTest baseTest = (BaseTest)iTestResult.getInstance();
            byte[] arr = ScreenShotUtils.screenShotByte(baseTest.driver);
            saveScreenshot(arr);
//            try {
//                ScreenShotUtils.screenShotFile(baseTest.driver);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
