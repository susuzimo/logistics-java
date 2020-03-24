package org.wtm.logistics.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.wtm.logistics.model.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByAccount(String account);
}