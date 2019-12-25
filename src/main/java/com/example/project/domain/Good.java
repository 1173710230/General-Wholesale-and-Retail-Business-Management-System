package com.example.project.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Good {
    private BigDecimal price;

    public Good(BigDecimal price) {
        this.price = price;
    }

    public Good(){

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(price, good.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Good{" +
                "price=" + price +
                '}';
    }
}


