//package com.beppe.test;
//
//import com.beppe.entity.Order1;
//import com.beppe.entity.Order2;
//import com.beppe.entity.User;
//import com.beppe.entity.UserCopy;
//import com.beppe.entity.UserDTO;
//import com.google.common.collect.Lists;
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.cglib.beans.BeanCopier;
//import org.springframework.cglib.core.Converter;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BeanTest {
//
//    @Test
//    public void test1(){
//        List<User> list = null;
////        User beppe1 = new User(1, "beppe1", true);
////        User beppe2 = new User(2, "beppe2", true);
////        User beppe3 = new User(3, "beppe3", true);
//////        beppe1.setOrders(Lists.newArrayList(new Order1(1l,"qw")));
//////        beppe2.setOrders(Lists.newArrayList(new Order1(2l,"tt")));
//////        beppe3.setOrders(Lists.newArrayList(new Order1(3l,"uu")));
////        list.add(beppe1);
////        list.add(beppe2);
////        list.add(beppe3);
//        List<UserCopy> userCopies = convertList(BeanCopier.create(User.class, UserCopy.class, false), list, UserCopy.class);
////        if(CollectionUtils.isNotEmpty(userCopies)){
//            userCopies.forEach(userCopy -> {
//                List<Order2> order2s = convertList(BeanCopier.create(Order1.class, Order2.class, false), userCopy.getOrders(), Order2.class);
//                userCopy.setOrders(order2s);
//            });
////        }
//        userCopies.forEach(userCopy -> {
//            List<Order2> orders = userCopy.getOrders();
//            System.out.println("coede:"+orders.get(0).getCode() );
//        });
//    }
//
//    public static <T, S> List<T> convertList(BeanCopier copier, List<S> source, Class<T> cls) {
//        List<T> list = Lists.newArrayList();
//        if (source != null && !source.isEmpty()) {
//            source.forEach((e) -> {
//                list.add(convert(copier, e, cls));
//            });
//        }
//
//        return list;
//    }
//
//    public static <T, S> T convert(BeanCopier copier, S source, Class<T> cls) {
//        try {
//            if (source == null) {
//                return null;
//            } else {
//                T target = cls.newInstance();
//                copier.copy(source, target, (Converter)null);
//                return target;
//            }
//        } catch (Exception var4) {
//            return null;
//        }
//    }
//
//    @Test
//    public void test2(){
//        User user = new User(1, "beppe", true);
//        UserDTO build = UserDTO.builder().user(user).build();
//        user.setName("aaaaaa");
//        String name = build.getUser().getName();
//        System.out.println("name:"+name);
//
//    }
//
//
//}
