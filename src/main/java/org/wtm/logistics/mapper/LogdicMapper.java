package org.wtm.logistics.mapper;


import org.wtm.logistics.model.Logdic;

public interface LogdicMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(Logdic record);

    int insertSelective(Logdic record);

    Logdic selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Logdic record);

    int updateByPrimaryKey(Logdic record);
}