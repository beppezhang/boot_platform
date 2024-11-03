package com.beppe.kafka.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author beppe
 * @data 2020/9/2 35:45
 * @description : 数据库对象
 */
@Data
@Getter
@Setter
@TableName(value = "user" )
public class User implements Serializable {

    private static final long serialVersionUID = -864026603758673556L;

    private String userName;

    private String password;

    private String realName;

    @TableId(type = IdType.AUTO)
    private Integer id;


}




