package com.beppe.register;

import com.beppe.annotation.BusinessIdentity;
import com.beppe.annotation.Extension;
import com.beppe.api.ExtensionPoint;
import com.beppe.api.IdentityResolver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * 扩展点启动初始化
 */
//@Component
public class ExtensionInit implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    private final ExtensionRegister extensionRegister;

    public void init(){
        System.out.println("进入ExtensionInit 扩展点初始化方法");
        Map<String, Object> extensionBeans = applicationContext.getBeansWithAnnotation(Extension.class);
        extensionBeans.values().forEach(
                extension -> extensionRegister.registry((ExtensionPoint) extension)
        );
        Map<String, Object> businessIdentityBeans = applicationContext.getBeansWithAnnotation(BusinessIdentity.class);
        businessIdentityBeans.values().forEach(
                businessIdentity -> extensionRegister.registry((IdentityResolver) businessIdentity)
        );
    }

    @Autowired
    public ExtensionInit(ExtensionRegister extensionRegister) {
        this.extensionRegister = extensionRegister;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
