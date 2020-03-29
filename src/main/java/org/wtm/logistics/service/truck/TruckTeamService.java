package org.wtm.logistics.service.truck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wtm.logistics.mapper.TruckTeamMapper;
import org.wtm.logistics.model.TruckTeam;

import java.util.List;

@Service
public class TruckTeamService {
    @Autowired
    TruckTeamMapper truckTeamMapper;
    public Integer addTruckTeam(TruckTeam truckTeam) {

        return truckTeamMapper.insertSelective(truckTeam);
    }

    public Long getTotal(String keyword) {
        return truckTeamMapper.getTotal(keyword);
    }

    public List<TruckTeam> getAllTruckTeamByPage(Integer page, Integer size, String keyword) {
        if(page!=null && size!=null){
            page=(page-1)*size;
        }
        return truckTeamMapper.getAllTruckTeamByPage(page,size,keyword);
    }

    public Integer updateTruckTeamById(TruckTeam truckTeam) {
        return truckTeamMapper.updateByPrimaryKeySelective(truckTeam);
    }

    public Integer deleteTrcuckTeamById(Integer id) {
        return truckTeamMapper.deleteByPrimaryKey(id);
    }
}
