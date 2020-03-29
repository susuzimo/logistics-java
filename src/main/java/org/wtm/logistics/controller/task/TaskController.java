package org.wtm.logistics.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wtm.logistics.model.Carriers;
import org.wtm.logistics.model.RespBean;
import org.wtm.logistics.model.RespPageBean;
import org.wtm.logistics.service.task.CarriesService;
import org.wtm.logistics.utils.UserUtils;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    CarriesService carriesService;


    @PutMapping("/")
    public  RespBean updateCarriesById(@RequestBody Carriers carriers){
        if(carriesService.updateCarriesById(carriers)==1){
            return   RespBean.ok("更新成功");
        }
        return   RespBean.error("更新失败");
    }



    @DeleteMapping("/{id}")
    public RespBean deleteCarriesById(@PathVariable Integer id){
        if(carriesService.deleteCarriesById(id)==1){
          return   RespBean.ok("删除成功");
        }
        return   RespBean.error("删除失败");
    }


    @PostMapping("/")
    public RespBean  addTask(@RequestBody Carriers carriers){

        carriers.setFkUserid(UserUtils.getCurrentUser().getUserid());

        if(carriesService.addTask(carriers)==1){
            return RespBean.ok("添加成功");
        }

        return RespBean.error("添加失败");
    }


    @GetMapping("/")
    public RespPageBean getAllCarriesByPage(){
        RespPageBean respPageBean=new RespPageBean();
        respPageBean.setData(carriesService.getAllCarriesByPage());
        respPageBean.setTotal(carriesService.getTotal());
        return respPageBean;
    }

}
