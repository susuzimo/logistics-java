package org.wtm.logistics.service.sche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wtm.logistics.mapper.CarriersMapper;
import org.wtm.logistics.mapper.SchedulingMapper;
import org.wtm.logistics.model.Carriers;
import org.wtm.logistics.model.Scheduling;
import org.wtm.logistics.model.Truck;
import org.wtm.logistics.service.truck.TruckService;
import org.wtm.logistics.utils.UserUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheService {

    @Autowired
    CarriersMapper carriersMapper;
    @Autowired
    SchedulingMapper schedulingMapper;

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public Long getTotal(Integer state) {

        return carriersMapper.getTotal2(state);
    }

    public List<Carriers> getAllCarries(Integer page, Integer size, Integer state) {
        if(page!=null && size!=null){
            page=(page-1)*size;
        }
        return carriersMapper.getAllCarriers(page,size,state);
    }

    public boolean updateSche(Integer carriersid, Integer truckid, String startTime) {
        try {
            Carriers carriers=new Carriers();
            carriers.setCarriersid(carriersid);
            carriers.setFinishedstate(1);
            carriersMapper.updateByPrimaryKeySelective(carriers);
            Scheduling scheduling=new Scheduling();
            scheduling.setFkCarriersid(carriersid);
            scheduling.setFkTruckid(truckid);
            scheduling.setStarttime(sdf.parse(startTime));
            scheduling.setCheckintime(new Date());
            scheduling.setFkUserid(UserUtils.getCurrentUser().getUserid());
            return  schedulingMapper.insertSelective(scheduling)==1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  false;
    }

    public Long getScheTotal() {
        return schedulingMapper.getTotal();
    }

    public List<Scheduling> getAllScheduling(Integer page, Integer size) {
        if(page!=null && size!=null){
            page=(page-1)*size;
        }
        return  schedulingMapper.getAllScheduling(page,size);
    }
}
