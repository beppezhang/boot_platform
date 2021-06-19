package com.beppe.mapper;

import com.beppe.model.User;
import com.beppe.model.UserQuery;
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
