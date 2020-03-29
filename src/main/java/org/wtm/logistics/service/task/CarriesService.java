package org.wtm.logistics.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wtm.logistics.mapper.CarriersMapper;
import org.wtm.logistics.model.Carriers;
import org.wtm.logistics.utils.UserUtils;

import java.util.List;

@Service
public class CarriesService {

    @Autowired
    CarriersMapper carriersMapper;
    public Integer addTask(Carriers carriers) {
        return carriersMapper.insertSelective(carriers);
    }

/*    public List<Carriers> getAllCarriesByPage(Integer page, Integer size) {
        if(page!=null && size!=null){
            page=(page-1)*size;
        }
        return carriersMapper.getAllCarriesByPage(page,size,UserUtils.getCurrentUser().getUserid());
    }*/

    public List<Carriers> getAllCarriesByPage() {

        return carriersMapper.getAllCarriesByPage(UserUtils.getCurrentUser().getUserid());
    }

    public Long getTotal() {
        return carriersMapper.getTotal(UserUtils.getCurrentUser().getUserid());
    }

    public Integer deleteCarriesById(Integer id) {
        return carriersMapper.deleteByPrimaryKey(id);
    }

    public Integer updateCarriesById(Carriers carriers) {

        return carriersMapper.updateByPrimaryKeySelective(carriers);
    }
}
