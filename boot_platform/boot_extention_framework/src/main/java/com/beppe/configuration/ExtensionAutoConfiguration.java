package com.beppe.configuration;

import com.beppe.register.ExtensionInit;
import com.beppe.register.ExtensionRegister;
import com.beppe.register.ExtensionRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展点注册配置
 */

@Configuration
public class ExtensionAutoConfiguration {

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean(ExtensionInit.class)
    public ExtensionInit extensionInit(ExtensionRegister extensionRegister) {
        System.out.println("进入extensionInit方法");
        return new ExtensionInit(extensionRegister);
    }

    @Bean
    @ConditionalOnMissingBean(ExtensionRegister.class)
    public ExtensionRegister register(ExtensionRepository extensionRepository) {
        System.out.println("进入register方法");
        return new ExtensionRegister(extensionRepository);
    }

    @Bean
    @ConditionalOnMissingBean(ExtensionRepository.class)
    public ExtensionRepository repository() {
        System.out.println("进入repository方法");
        return new ExtensionRepository();
    }

}
