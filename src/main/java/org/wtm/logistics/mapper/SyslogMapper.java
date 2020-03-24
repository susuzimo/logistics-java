package org.wtm.logistics.mapper;


import org.wtm.logistics.model.Syslog;
import org.wtm.logistics.model.SyslogWithBLOBs;

public interface SyslogMapper {
    int deleteByPrimaryKey(Integer logid);

    int insert(SyslogWithBLOBs record);

    int insertSelective(SyslogWithBLOBs record);

    SyslogWithBLOBs selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(SyslogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SyslogWithBLOBs record);

    int updateByPrimaryKey(Syslog record);
}