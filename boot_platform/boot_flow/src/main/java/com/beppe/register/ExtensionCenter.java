package com.beppe.register;

import com.beppe.api.ExtentionPoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 扩展点注册中心，用于保存实例化后的扩展点
 */
public class ExtensionCenter {

    // 维护扩展点容器
    private Map<ExtensionCoordinate, ExtentionPoint> extentionMap=new ConcurrentHashMap();

    public Map<ExtensionCoordinate, ExtentionPoint> getExtentionMap() {
        return extentionMap;
    }

    public <Ext> Ext getExtension(Class<Ext> targetClz,String type, String point, String code){
        return getExtension(new ExtensionCoordinate(type, point, code));
    }

    // 从容器中获取到对应的扩展点
    public <Ext> Ext getExtension(ExtensionCoordinate extensionCoordinate){
        return (Ext) extentionMap.get(extensionCoordinate);
    }
}
