package com.beppe.register;

import com.beppe.annotations.MyAnnotation;
import com.beppe.api.ExtentionPoint;
import com.beppe.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class ExtensionInit implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    // 引入注册中心  将扩展点注册到注册中心中
    private final ExtensionRegister extensionRegister;

    @Autowired
    public ExtensionInit(ExtensionRegister extensionRegister) {
        this.extensionRegister = extensionRegister;
    }

    // spring 容器启动的时候初始化操作  用于注册功能执行   可以将扩展点的实例加载到容器中
    public void init(){
        // 获取到项目中 有MyAnnotation 这个注解的实例
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(MyAnnotation.class);
        // 注册这个实例到注册中心中
        beansWithAnnotation.values().forEach(
                // 将扩展点注册中注册中心
                extension->extensionRegister.register((ExtentionPoint)extension)

        );
        System.out.println("开始执行init 方法");
    }

    // 获取  spring容器上下文   用于后续接下自定义注解，将自定义注解的类加载中容器中
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

}
