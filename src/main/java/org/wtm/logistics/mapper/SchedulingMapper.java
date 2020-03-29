package org.wtm.logistics.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wtm.logistics.model.Scheduling;

import java.util.List;

@Mapper
public interface SchedulingMapper {
    int deleteByPrimaryKey(Integer schedulingid);

    int insert(Scheduling record);

    int insertSelective(Scheduling record);

    Scheduling selectByPrimaryKey(Integer schedulingid);

    int updateByPrimaryKeySelective(Scheduling record);

    int updateByPrimaryKey(Scheduling record);

    Long getTotal();

    List<Scheduling> getAllScheduling(@Param("page") Integer page, @Param("size") Integer size);
}