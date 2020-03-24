package org.wtm.logistics.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Truck {
    private Integer truckid;

    private String number;

    private Date buydate;

    private String type;

    private String length;

    private Integer tonnage;

    private Integer fkTeamid;

    private Integer state;

    private String remark;

    private Date checkintime;

    private Integer isdelete;

    private Date altertime;

    private TruckTeam truckTeam;

    public TruckTeam getTruckTeam() {
        return truckTeam;
    }

    public void setTruckTeam(TruckTeam truckTeam) {
        this.truckTeam = truckTeam;
    }

    public Integer getTruckid() {
        return truckid;
    }

    public void setTruckid(Integer truckid) {
        this.truckid = truckid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public Integer getTonnage() {
        return tonnage;
    }

    public void setTonnage(Integer tonnage) {
        this.tonnage = tonnage;
    }

    public Integer getFkTeamid() {
        return fkTeamid;
    }

    public void setFkTeamid(Integer fkTeamid) {
        this.fkTeamid = fkTeamid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
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

    public Date getAltertime() {
        return altertime;
    }

    public void setAltertime(Date altertime) {
        this.altertime = altertime;
    }
}