package com.beppe.kafka.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beppe.kafka.model.User;
import com.beppe.kafka.model.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author beppe
 * @data 2020/9/2 15:47
 * @description :
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectByPrimaryKey(Integer id);

    List<User> selectUserList(@Param("params") UserQuery userQuery);
}
