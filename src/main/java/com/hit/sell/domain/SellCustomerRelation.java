package com.hit.sell.domain;


public class SellCustomerRelation {
    private Integer scrId;
    private Integer customerId;
    private  Integer sellOrderId;

    public SellCustomerRelation() {
    }

    public SellCustomerRelation(Integer scrId, Integer customerId, Integer sellOrderId) {
        this.scrId = scrId;
        this.customerId = customerId;
        this.sellOrderId = sellOrderId;
    }

    public Integer getScrId() {
        return scrId;
    }

    public void setScrId(Integer scrId) {
        this.scrId = scrId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Integer sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    @Override
    public String toString() {
        return "SellCustomerRelation{" +
                "scrId=" + scrId +
                ", customerId=" + customerId +
                ", sellOrderId=" + sellOrderId +
                '}';
    }
}
