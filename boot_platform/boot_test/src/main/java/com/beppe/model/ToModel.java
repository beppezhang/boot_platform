package com.beppe.model;

import java.sql.Timestamp;
import java.util.List;

public class ToModel implements Imodel{

    private List<Long> manageCategoryIds;

    private Integer opSense;

    private Integer opType;

    private String dateTime;

    private Boolean flag;

    public List<Long> getManageCategoryIds() {
        return manageCategoryIds;
    }

    public void setManageCategoryIds(List<Long> manageCategoryIds) {
        this.manageCategoryIds = manageCategoryIds;
    }

    public Integer getOpSense() {
        return opSense;
    }

    public void setOpSense(Integer opSense) {
        this.opSense = opSense;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void doInsert() {

    }

    @Override
    public void execute() {
        System.out.println("ToModel --- execute" );
    }

    @Override
    public Integer priority() {
        return 2;
    }


    @Override
    public boolean getModel(Integer type) {
        if(type==1){
            return true;
        }
        return false;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
