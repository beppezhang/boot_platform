package com.beppe.kafka.register;

import com.beppe.kafka.annotation.BusinessData;
import com.beppe.kafka.container.GlobalContainer;
import com.beppe.kafka.processor.Processor;
import com.beppe.kafka.template.ProcessTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 注册服务   在项目启动的时候  将具体的处理模板注册到全局容器中  以便后续使用
 */
@Component
public class ProcessRegister implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    public void ProcessRegister(ProcessTemplate otherProcessTemplate,
                                ProcessTemplate coreProcessTemplate,
                                ProcessTemplate externalProcessTemplate) {
        GlobalContainer.processTemplateMap.put("core", coreProcessTemplate);
        GlobalContainer.processTemplateMap.put("external", externalProcessTemplate);
        GlobalContainer.processTemplateMap.put("other", otherProcessTemplate);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 解析用户标注了 BusinessData注解的类
        // 获取所有的@Register 注解
        Map<String, Object> registerBeans = applicationContext.getBeansWithAnnotation(BusinessData.class);
        registerBeans.values().forEach(register -> doRegister((Processor) register));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void doRegister(Processor pro) {
        // code 作为key   将Processor 注册到容器中
        BusinessData businessDataAnn = pro.getClass().getDeclaredAnnotation(BusinessData.class);
        String code = businessDataAnn.code();
        List<Processor> list = GlobalContainer.processorListMap.getOrDefault(code, new ArrayList<>());
        list.add(pro);
        GlobalContainer.processorListMap.put(code, list);
    }
}
