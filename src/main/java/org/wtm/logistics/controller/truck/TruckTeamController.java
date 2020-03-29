package org.wtm.logistics.controller.truck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wtm.logistics.model.RespBean;
import org.wtm.logistics.model.RespPageBean;
import org.wtm.logistics.model.TruckTeam;
import org.wtm.logistics.service.truck.TruckTeamService;

@RequestMapping("/truck/team")
@RestController
public class TruckTeamController {
    @Autowired
    TruckTeamService truckTeamService;


    @PutMapping("/")
    public RespBean updateTruckTeamById(@RequestBody  TruckTeam truckTeam){
        if(truckTeamService.updateTruckTeamById(truckTeam)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }


    @DeleteMapping("/{id}")
    public RespBean deleteTrcuckTeamById(@PathVariable Integer id){
        if(truckTeamService.deleteTrcuckTeamById(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PostMapping("/")
    public RespBean addTruckTeam(@RequestBody TruckTeam truckTeam){
        if(truckTeamService.addTruckTeam(truckTeam)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.ok("添加失败");
    }




    @GetMapping("/")
    public RespPageBean addTruckTeam(Integer page,Integer size,String keyword){
        RespPageBean respPageBean=new RespPageBean();
        respPageBean.setTotal(truckTeamService.getTotal(keyword));
        respPageBean.setData(truckTeamService.getAllTruckTeamByPage(page,size,keyword));
        return  respPageBean;

    }


}
