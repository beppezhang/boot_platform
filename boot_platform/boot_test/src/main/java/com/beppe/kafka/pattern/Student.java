package com.beppe.kafka.pattern;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Student {
    @ExcelProperty("编号")
    private String id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty({"基本信息","年龄"})
    private Integer age;
    @ExcelProperty({"基本信息","电话"})
    private String phone;
    @ExcelProperty({"可选信息","邮件"})
    private String Email;

    public Student(String id, String name, Integer age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        Email = email;
    }
}
