package org.wtm.logistics.service.truck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wtm.logistics.mapper.TruckMapper;
import org.wtm.logistics.model.Truck;

import java.util.Date;
import java.util.List;

@Service
public class TruckService {

    @Autowired
    TruckMapper truckMapper;

    public Integer addTruck(Truck truck) {

        return truckMapper.insertSelective(truck);
    }

    public Integer deleteTruckById(Integer id) {
        return truckMapper.deleteByPrimaryKey(id);
    }

    public Integer updateTruckById(Truck truck) {
        return truckMapper.updateByPrimaryKeySelective(truck);
    }

    public List<Truck> getAllTruckByPage(Integer page, Integer size, Date[] daterange,String type){
        if(page!=null && size!=null){
            page=(page-1)*size;
        }

        return truckMapper.getAllTruckByPage(page,size,daterange,type);
    }

    public List<String> getAllTypes() {
        return truckMapper.getAllTypes();
    }

    public Long getTotal(Date[] daterange, String type) {
        return truckMapper.getTotal(daterange,type);
    }

    public List<Truck> getAllTruckByState(Integer state) {
        return  truckMapper.getAllTruckByState(state);
    }
}
