package com.beppe.model;

import javax.sound.midi.Soundbank;
import java.sql.Timestamp;
import java.util.List;

public class MyModel implements Imodel{

    public MyModel() {
    }

    public MyModel(Integer opSense, Integer opType, Timestamp dateTime) {
        this.opSense = opSense;
        this.opType = opType;
        this.dateTime = dateTime;
    }

    private List<Long> manageCategoryIds;

    private Integer opSense;

    private Integer opType;

    private Timestamp dateTime;

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

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void doInsert() {

    }

    @Override
    public void execute() {
        System.out.println("MyModel --- execute" );
    }

    @Override
    public Integer priority() {
        return 1;
    }

    @Override
    public boolean getModel(Integer type) {
        if(type==1){
            return true;
        }
        return false;
    }
}
