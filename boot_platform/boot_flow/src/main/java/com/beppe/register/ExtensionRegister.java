package com.beppe.register;

import com.beppe.annotations.MyAnnotation;
import com.beppe.api.ExtentionPoint;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ExtensionRegister {

    // 注入注册中心
    private final ExtensionCenter extensionCenter;

    @Autowired
    public ExtensionRegister(ExtensionCenter extensionCenter) {
        this.extensionCenter = extensionCenter;
    }

    // 将扩展点注册到注册中心中
    public void register(ExtentionPoint extentionPoint) {
        Class<? extends ExtentionPoint> extentionClass = extentionPoint.getClass();
        // 获取到自定义注解的信息
        MyAnnotation myAnnotation = extentionClass.getDeclaredAnnotation(MyAnnotation.class);
        if (myAnnotation != null) {
            //注册
            register(extentionPoint, myAnnotation.type(), myAnnotation.point(), myAnnotation.code());
        }

    }

    // 根据坐标进行注册到注册中心中
    public void register(ExtentionPoint extentionPoint, String type, String point, String code) {
        // 封装坐标信息
        ExtensionCoordinate extensionCoordinate = new ExtensionCoordinate(type, point, code);
        Map<ExtensionCoordinate, ExtentionPoint> extentionMap = extensionCenter.getExtentionMap();
        if (extentionMap.containsKey(extensionCoordinate)) {
            throw new RuntimeException("坐标重复");
        }
        extentionMap.put(extensionCoordinate, extentionPoint);
    }


}
