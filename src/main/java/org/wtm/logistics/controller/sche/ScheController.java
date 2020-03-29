package org.wtm.logistics.controller.sche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wtm.logistics.model.RespBean;
import org.wtm.logistics.model.RespPageBean;
import org.wtm.logistics.model.Truck;
import org.wtm.logistics.service.sche.ScheService;
import org.wtm.logistics.service.truck.TruckService;

import java.util.List;

@RestController
@RequestMapping("/sche")
public class ScheController {
    @Autowired
    ScheService scheService;
    @Autowired
    TruckService truckService;

    @GetMapping("/")
    public RespPageBean getAllScheduling(Integer page,Integer size){
        RespPageBean respPageBean=new RespPageBean();
        respPageBean.setData(scheService.getAllScheduling(page,size));
        respPageBean.setTotal(scheService.getScheTotal());
        return  respPageBean;
    }


    @PostMapping("/")
    public  RespBean sche(Integer carriersid,Integer truckid,String startTime){
        if(scheService.updateSche(carriersid,truckid,startTime)){
           return RespBean.ok("调度成功");
        }
        return RespBean.ok("调度失败");
    }


    @GetMapping("/carriers")
    public RespPageBean getAllCarries(Integer page, Integer size, @RequestParam(defaultValue = "0")Integer state){

        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal(scheService.getTotal(state));
        respPageBean.setData(scheService.getAllCarries(page,size,state));
        return  respPageBean;
    }



    @GetMapping("/truck")
    public List<Truck> getAllTruckByState(){
        return truckService.getAllTruckByState(2);
    }

}
