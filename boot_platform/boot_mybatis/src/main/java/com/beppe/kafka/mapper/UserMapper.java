package com.beppe.kafka.mapper;

import com.beppe.kafka.model.User;
import com.beppe.kafka.model.UserQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author beppe
 * @data 2020/9/2 15:47
 * @description :
 */
@Repository
public interface UserMapper {

    User selectByPrimaryKey(Integer id);

    List<User> selectUserList(@Param("params") UserQuery userQuery);
}
