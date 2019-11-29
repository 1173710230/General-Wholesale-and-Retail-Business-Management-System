package com.example.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warehouse {


    private Integer warehouseId;
    private String warehouseName;
    private List<Goods> warehouseGoods;

    //ToDo constructor
    public Warehouse() {
    }

    public Warehouse(Integer warehouseId, String warehouseName, List<Goods> warehouseGoods) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.warehouseGoods = warehouseGoods;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public List<Goods> getWarehouseGoods() {
        return warehouseGoods;
    }

    public void setWarehouseGoods(List<Goods> warehouseGoods) {
        this.warehouseGoods = warehouseGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(warehouseId, warehouse.warehouseId) &&
                Objects.equals(warehouseName, warehouse.warehouseName) &&
                Objects.equals(warehouseGoods, warehouse.warehouseGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId, warehouseName, warehouseGoods);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", warehouseGoods=" + warehouseGoods +
                '}';
    }
}