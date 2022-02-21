package com.beppe.configration;

import com.beppe.register.ExtensionCenter;
import com.beppe.register.ExtensionInit;
import com.beppe.register.ExtensionRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过 @Bean 形式 注解管理bean  用于管理配置类
 */
@Configuration
public class ExtensionConfigration {

    // 通过方法直接注入需要的实例
    @Bean(initMethod = "init")
    public ExtensionInit extensionInit(ExtensionRegister extensionRegister){
        System.out.println("创建ExtensionInit对象");
        return new ExtensionInit(extensionRegister);
    }

    // 注册类
    @Bean
    public ExtensionRegister extensionRegister(){
        return new ExtensionRegister(extensionCenter());
    }

    @Bean
    public ExtensionCenter extensionCenter(){
        return new ExtensionCenter();
    }



}
