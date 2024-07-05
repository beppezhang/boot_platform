package com.beppe.jvm;

import com.beppe.concurrent.Singleton;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassLoaderDemo {

    @Test
    public void test1() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("", "", "");
//        Singleton.getInstance();
        new ClassPathXmlApplicationContext();
    }
}
