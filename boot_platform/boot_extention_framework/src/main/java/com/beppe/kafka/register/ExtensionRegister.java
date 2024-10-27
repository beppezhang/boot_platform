package com.beppe.kafka.register;

import com.beppe.kafka.annotation.BusinessIdentity;
import com.beppe.kafka.annotation.Extension;
import com.beppe.kafka.api.ExtensionPoint;
import com.beppe.kafka.api.IdentityResolver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 扩展点注册中心
 */
public class ExtensionRegister {
    private final ExtensionRepository extensionRepository;

    @Autowired
    public ExtensionRegister(ExtensionRepository extensionRepository) {
        this.extensionRepository = extensionRepository;
    }

    public void registry(ExtensionPoint extensionPoint){
        Class<?>  extensionClz = extensionPoint.getClass();
        Extension extensionAnn = extensionClz.getDeclaredAnnotation(Extension.class);
        ExtensionCoordinate extensionCoordinate = new ExtensionCoordinate(extensionAnn.type() ,extensionAnn.point() ,extensionAnn.code());
        ExtensionPoint preVal = extensionRepository.getExtensionMap().put(extensionCoordinate,extensionPoint);
        if(preVal !=null ){
            throw new RuntimeException("Duplicate registration is not allowed for :" + extensionCoordinate);
        }
    }

    public void registry(IdentityResolver identityResolver){
        Class<?>  identityResolverClz = identityResolver.getClass();
        BusinessIdentity identityResolverAnn = identityResolverClz.getDeclaredAnnotation(BusinessIdentity.class);
        IdentityResolver preVal = extensionRepository.getIdentityResolverMap().put(identityResolverAnn.code(),identityResolver);
        if(preVal !=null ){
            throw new RuntimeException("Duplicate registration is not allowed for :" + identityResolverAnn.code());
        }
    }
}
