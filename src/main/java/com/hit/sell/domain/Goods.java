package com.hit.sell.domain;

public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String specification;
    private Integer warehouseId;

    public Goods() {
        super();
    }

    public Goods(Integer goodsId, String goodsName, String specification, Integer warehouseId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.specification = specification;
        this.warehouseId = warehouseId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", warehouseId=" + warehouseId +
                '}';
    }
}
