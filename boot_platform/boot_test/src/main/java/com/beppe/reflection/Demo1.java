package com.beppe.reflection;

import com.beppe.annotation.FieldAnnotion;
import com.beppe.entity.User;
import org.springframework.util.ReflectionUtils;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

public class Demo1 {

    @Test
    public void reflectionTest(){
        // 发射方式赋值
        User user = new User();
        // 获取到类上的注解
        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field field:declaredFields) {
            if(field.isAnnotationPresent(FieldAnnotion.class)){
                // 有 FieldAnnotion 这个注解标识 则赋值
                setField(User.class,user,field.getName(),"bepppe");
            }
        }
        System.out.println("name:"+user.getName());
        System.out.println("code:"+user.getCode());
    }

    // 反射给对象赋值
    private <T>void setField(Class<T> tClass,T t,String fieldName,Object value) {
        try {
            Field field = tClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            ReflectionUtils.setField(field,t,value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
