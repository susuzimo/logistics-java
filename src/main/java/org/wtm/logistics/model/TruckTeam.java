package org.wtm.logistics.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TruckTeam {
    private Integer teamid;

    private String teamname;

    private String leader;

    private String remark;

    private Date checkintime;

    private Integer isdelete;

    private Date altertime;

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    public Date getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(Date checkintime) {
        this.checkintime = checkintime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getAltertime() {
        return altertime;
    }

    public void setAltertime(Date altertime) {
        this.altertime = altertime;
    }
}