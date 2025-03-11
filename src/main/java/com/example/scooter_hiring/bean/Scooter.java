package com.example.scooter_hiring.bean;

public class Scooter {
    private Long id;
    private String scooterName;
    private String scooterDetail;

    //获取id
    public Long getId() {
        return id;
    }

    //设置id
    public void setId(Long id) {
        this.id = id;
    }

    //获取名称
    public String getScooterName() {
        return scooterName;
    }

    //设置名称
    public void setScooterName(String scooterName) {
        this.scooterName = scooterName;
    }

    //获取详细信息
    public String getScooterDetail() {
        return scooterDetail;
    }

    //设置详细信息
    public void setScooterDetail(String scooterDetail) {
        this.scooterDetail = scooterDetail;
    }
}
