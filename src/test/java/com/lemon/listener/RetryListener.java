package com.lemon.listener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        if(iTestAnnotation.getRetryAnalyzer() == null){
            iTestAnnotation.setRetryAnalyzer(TestngRetry.class);
        }
    }
}
