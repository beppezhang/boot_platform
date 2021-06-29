package com.beppe.register;

import com.beppe.api.ExtensionPoint;
import com.beppe.api.IdentityResolver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 扩展点仓库
 */
public class ExtensionRepository {

    private Map<ExtensionCoordinate, ExtensionPoint> extensionMap = new ConcurrentHashMap<>();

    private Map<String, IdentityResolver> identityResolverMap = new ConcurrentHashMap<>();

    public Map<ExtensionCoordinate, ExtensionPoint> getExtensionMap(){
        return extensionMap;
    }

    public Map<String, IdentityResolver> getIdentityResolverMap() {
        return identityResolverMap;
    }

    public <Ext> Ext getExtension(Class<Ext> targetClz, String type, String point, String code){
        return getExtension(targetClz, new ExtensionCoordinate(type, point, code));
    }

    public <Ext> Ext getExtension(Class<Ext> targetClz, ExtensionCoordinate extensionCoordinate){
        return (Ext) extensionMap.get(extensionCoordinate);
    }

    public IdentityResolver getIdentityResolver(String point){
        return identityResolverMap.get(point);
    }


    public <Ext,T> Ext getExtension(Class<Ext> targetClz, String type, String point ,T t){
        IdentityResolver identityResolver = getIdentityResolver(point);
        String code = identityResolver.getExtensionCode(t);
        return getExtension(targetClz, type, point, code);
    }
}
