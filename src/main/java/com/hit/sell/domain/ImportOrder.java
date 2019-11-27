package com.hit.sell.domain;

public class ImportOrder {
    private Integer inId;
    private double unitPrice;
    private Integer importNumber;
    private Integer goodsId;

    public ImportOrder() {
        super();
    }

    public ImportOrder(Integer inId, double unitPrice, Integer importNumber, Integer goodsId) {
        this.inId = inId;
        this.unitPrice = unitPrice;
        this.importNumber = importNumber;
        this.goodsId = goodsId;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getImportNumber() {
        return importNumber;
    }

    public void setImportNumber(Integer importNumber) {
        this.importNumber = importNumber;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "ImportOrder{" +
                "inId=" + inId +
                ", unitPrice=" + unitPrice +
                ", importNumber=" + importNumber +
                ", goodsId=" + goodsId +
                '}';
    }
}
