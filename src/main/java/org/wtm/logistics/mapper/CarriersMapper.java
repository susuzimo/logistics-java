package org.wtm.logistics.mapper;

import org.apache.ibatis.annotations.Param;
import org.wtm.logistics.model.Carriers;

import java.util.List;

public interface CarriersMapper {
    int deleteByPrimaryKey(Integer carriersid);

    int insert(Carriers record);

    int insertSelective(Carriers record);

    Carriers selectByPrimaryKey(Integer carriersid);

    int updateByPrimaryKeySelective(Carriers record);

    int updateByPrimaryKey(Carriers record);

    Long getTotal(@Param("uid") Integer userid);

    List<Carriers> getAllCarriesByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("uid") Integer userid);


    Long getTotal2(Integer state);

    List<Carriers> getAllCarriers(@Param("page") Integer page, @Param("size") Integer size, @Param("state") Integer state);
}