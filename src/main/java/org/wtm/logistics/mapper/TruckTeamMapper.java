package org.wtm.logistics.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wtm.logistics.model.TruckTeam;

import java.util.List;

@Mapper
public interface TruckTeamMapper {
    int deleteByPrimaryKey(@Param("teamid") Integer teamid);

    int insert(TruckTeam record);

    int insertSelective(TruckTeam record);

    TruckTeam selectByPrimaryKey(Integer teamid);

    int updateByPrimaryKeySelective(TruckTeam record);

    int updateByPrimaryKey(TruckTeam record);

    Long getTotal(@Param("keyword") String keyword);

    List<TruckTeam> getAllTruckTeamByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);
}