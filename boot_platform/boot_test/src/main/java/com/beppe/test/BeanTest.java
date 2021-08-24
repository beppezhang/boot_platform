package com.beppe.test;

import com.beppe.entity.User;
import com.beppe.entity.UserCopy;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BeanTest {

    @Test
    public void test1(){
        List<User> list = new ArrayList<>();
        list.add(new User(1, "beppe1", true));
        list.add(new User(2, "beppe2", true));
        list.add(new User(3, "beppe3", true));
        List<UserCopy> list1 = new ArrayList<>();
        List<UserCopy> userCopies = convertList(BeanCopier.create(User.class, UserCopy.class, false), list, UserCopy.class);

    }

    public static <T, S> List<T> convertList(BeanCopier copier, List<S> source, Class<T> cls) {
        List<T> list = Lists.newArrayList();
        if (source != null && !source.isEmpty()) {
            source.forEach((e) -> {
                list.add(convert(copier, e, cls));
            });
        }

        return list;
    }

    public static <T, S> T convert(BeanCopier copier, S source, Class<T> cls) {
        try {
            if (source == null) {
                return null;
            } else {
                T target = cls.newInstance();
                copier.copy(source, target, (Converter)null);
                return target;
            }
        } catch (Exception var4) {
            return null;
        }
    }


}
