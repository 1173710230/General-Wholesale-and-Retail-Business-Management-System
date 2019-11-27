package com.hit.sell.domain;

public class WareHouse {
    private Integer whId;
    private String name;

    public WareHouse() {
    }

    public WareHouse(Integer whId, String name) {
        this.whId = whId;
        this.name = name;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    @Override
    public String toString() {
        return "WareHouse{" +
                "whId=" + whId +
                ", name=" + name +
                '}';
    }
}
