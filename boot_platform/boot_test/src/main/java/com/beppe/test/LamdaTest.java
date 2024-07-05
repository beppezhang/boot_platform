//package com.beppe.test;
//
//import com.beppe.model.MyModel;
//import com.beppe.model.ToModel;
//import com.google.common.collect.Lists;
//import org.apache.commons.beanutils.BeanUtils;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.InvocationTargetException;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class LamdaTest {
//
//    @Test
//    public void test1(){
//        //匹配到任意一个
//        List<MyModel> list = Lists.newArrayList();
//        MyModel myModel1 = new MyModel(1,1,new Timestamp(new Date().getTime()));
//        MyModel myModel2 = new MyModel(2,2,new Timestamp(new Date().getTime()));
//        MyModel myModel3 = new MyModel(3,3,new Timestamp(new Date().getTime()));
//
//
//        list.add(myModel1);
//        list.add(myModel2);
//        list.add(myModel3);
//        List<ToModel> collect = list.stream().map(myModel -> {
//            ToModel toModel = new ToModel();
//            try {
//                BeanUtils.copyProperties(toModel,myModel);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            return toModel;
//        }).collect(Collectors.toList());
//        System.out.println("collect:"+collect);
//
//    }
//}
//
