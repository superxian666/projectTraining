package com.firewolf.apitest_platform.domain;

public class Collection {


    private int cId;
    private String cName;
    public Collection(int cId, String cName) {
        this.cId=cId;
        this.cName=cName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
    @Override
    public String toString(){
        return "Collection{ "
                +"cId="+this.cId+","
                +"cName="+this.cName
                + "}";
    }
}
