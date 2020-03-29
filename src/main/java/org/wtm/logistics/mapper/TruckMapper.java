package org.wtm.logistics.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wtm.logistics.model.Truck;

import java.util.Date;
import java.util.List;

@Mapper
public interface TruckMapper {
    int deleteByPrimaryKey(Integer truckid);

    int insert(Truck record);

    int insertSelective(Truck record);

    Truck selectByPrimaryKey(Integer truckid);

    int updateByPrimaryKeySelective(Truck record);

    int updateByPrimaryKey(Truck record);

    List<Truck> getAllTruckByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("daterange") Date[] daterange, @Param("type") String type);

    List<String> getAllTypes();

    Long getTotal(@Param("daterange") Date[] daterange, @Param("type") String type);

    List<Truck> getAllTruckByState(Integer state);
}