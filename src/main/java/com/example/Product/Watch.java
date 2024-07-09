package com.example.Product;

public class Watch extends Mobile{
    private Long wid;
    private String wname;
    private String wtype;
    private String wmodel;
    private Long wprice;
    public Watch(){}
    public Watch(Long wid,String wname,String wtype,String wmodel,Long wprice){
        this.wid=wid;
        this.wname=wname;
        this.wtype=wtype;
        this.wmodel=wmodel;
        this.wprice=wprice;
    }
    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWtype() {
        return wtype;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype;
    }

    public String getWmodel() {
        return wmodel;
    }

    public void setWmodel(String wmodel) {
        this.wmodel = wmodel;
    }

    public Long getWprice() {
        return wprice;
    }

    public void setWprice(Long wprice) {
        this.wprice = wprice;
    }

}
