package com.beppe.model;

import java.util.List;

/**
 * @author beppe
 * @data 2020/10/13 14:27
 * @description :
 */
public class UserQuery {

    List<String> idList;

    List<String> realNameList;

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public List<String> getRealNameList() {
        return realNameList;
    }

    public void setRealNameList(List<String> realNameList) {
        this.realNameList = realNameList;
    }
}
