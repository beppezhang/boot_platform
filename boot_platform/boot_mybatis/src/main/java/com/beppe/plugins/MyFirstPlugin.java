package com.beppe.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author beppe
 * @data 2020/10/14 13:57
 * @description :
 */
@Intercepts(
        {
                @Signature(type = StatementHandler.class, method = "parameterize",
                        args = java.sql.Statement.class)
        }
)
public class MyFirstPlugin implements Interceptor {

    // 拦截目标对象中目标方法的执行
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行目标方法
        Object proceed = invocation.proceed();
        // 返回拦截之后的目标方法
        return proceed;
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
