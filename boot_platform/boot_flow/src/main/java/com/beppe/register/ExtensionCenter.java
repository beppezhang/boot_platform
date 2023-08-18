package com.beppe.register;

import com.beppe.api.ExtentionPoint;
import com.beppe.api.IdentityResolver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 扩展点注册中心，用于保存实例化后的扩展点
 */
public class ExtensionCenter {

    // 维护扩展点容器
    private Map<ExtensionCoordinate, ExtentionPoint> extensionMap=new ConcurrentHashMap();

    // 维护业务身份
    private Map<String, IdentityResolver> identityResolverMap = new ConcurrentHashMap<>();

    public Map<ExtensionCoordinate, ExtentionPoint> getExtentionMap() {
        return extensionMap;
    }

    public <Ext,T> Ext getExtension(Class<Ext> targetClz,String type, String point, T t){
        IdentityResolver identityResolver = getIdentityResolver(point);
        String code = identityResolver.getExtensionCode(t);
        return getExtension(targetClz, type, point, code);
    }

    public <Ext> Ext getExtension(Class<Ext> targetClz, String type, String point, String code){
        return getExtension(targetClz, new ExtensionCoordinate(type, point, code));
    }

    public <Ext> Ext getExtension(Class<Ext> targetClz, ExtensionCoordinate extensionCoordinate){
        return (Ext) extensionMap.get(extensionCoordinate);
    }
    // 从容器中获取到对应的扩展点
    public <Ext> Ext getExtension(ExtensionCoordinate extensionCoordinate){
        return (Ext) extensionMap.get(extensionCoordinate);
    }

    public IdentityResolver getIdentityResolver(String point){
        return identityResolverMap.get(point);
    }
}
