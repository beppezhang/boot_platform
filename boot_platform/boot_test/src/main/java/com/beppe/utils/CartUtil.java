package com.beppe.utils;

import com.beppe.entity.Order1;
import com.beppe.entity.Order2;
import com.beppe.entity.User;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CartUtil {

    public static List<Order2> buildMultiCartInfo(User user, Function<Order1, Order2> function){
        System.out.println("doing the buildMultiCartInfo");
        Order1 o1 = new Order1(1l, "zhang1");
        Order1 o2 = new Order1(2l,"zhang2");
        Order1 o3 = new Order1(3l,"zhang3");
        List<Order1> listOrder = Lists.newArrayList(o1, o2, o3);
        List<Order2> collect = listOrder.stream().map(function).filter(Objects::nonNull).collect(Collectors.toList());
        return collect;
    }
}
