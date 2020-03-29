package org.wtm.logistics.controller.truck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wtm.logistics.model.RespBean;
import org.wtm.logistics.model.RespPageBean;
import org.wtm.logistics.model.Truck;
import org.wtm.logistics.service.truck.TruckService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    TruckService truckService;

    @PostMapping("/")
    public RespBean addTruck(@RequestBody Truck truck){

        if(truckService.addTruck(truck)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.ok("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteTruckById(@PathVariable Integer id){
        if(truckService.deleteTruckById(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }


    @PutMapping("/")
    public RespBean updateTruckById(@RequestBody Truck truck){
        if(truckService.updateTruckById(truck)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }


    @GetMapping("/")
    public RespPageBean getAllTruckByPage(Integer page, Integer size, Date[] daterange, String type){
        RespPageBean respPageBean=new RespPageBean();
        respPageBean.setData(truckService.getAllTruckByPage(page,size,daterange,type));
        respPageBean.setTotal(truckService.getTotal(daterange,type));
        return respPageBean;
    }


    @GetMapping("/types")
    public List<String> getAllTypes(){
        List<String> allTypes = truckService.getAllTypes();
        allTypes.add(0,"全部");
        return allTypes;
    }
}
