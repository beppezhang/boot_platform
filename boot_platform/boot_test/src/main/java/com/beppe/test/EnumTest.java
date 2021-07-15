package com.beppe.test;

import com.beppe.common.MyEnum;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.List;

public class EnumTest {

    @Test
    public void test1(){
        // 获取枚举类的value
        List<MyEnum> enumList = EnumUtils.getEnumList(MyEnum.class);
        MyEnum myEnum = enumList.stream().filter(n -> n.getValue() == 1L).findAny().orElse(null);
        System.out.println("enum："+myEnum.getDescription());
    }
}
