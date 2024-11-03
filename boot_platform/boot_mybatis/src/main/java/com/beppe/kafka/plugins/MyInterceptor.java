package com.beppe.kafka.plugins;

import com.beppe.kafka.service.CityService;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author beppe
 * @data 2020/10/14 13:57
 * @description :
 */
@Intercepts(
        {
                @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
        }
)
public class MyInterceptor implements Interceptor {

    private final CityService cityService;

    public MyInterceptor(CityService cityService) {
        this.cityService = cityService;
    }

    // 拦截目标对象中目标方法的执行
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Before method: " + invocation.getMethod().getName());
        // 执行目标方法
        Object result = invocation.proceed();
        cityService.getCityName();
        // 返回拦截之后的目标方法
        System.out.println("After method: " + invocation.getMethod().getName());
        return result;
    }

    // 包装目标对象,即为目标对象创建一个代理对象
    @Override
    public Object plugin(Object target) {
        // 借助 Plugin 的 wrap(Object target,Interceptor interceptor); 包装我们的目标对象
        // target: 目标对象, interceptor: 拦截器, this 表示使用当前拦截器
        Object proxy = Plugin.wrap(target,this);
        return proxy;
    }

    // 可以获取插件注册时,传入的property属性
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件的配置信息:"+properties);
    }
}
