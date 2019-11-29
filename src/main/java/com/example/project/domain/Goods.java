package com.example.project.domain;

import java.util.Objects;


public class Goods {

    private int id;
    private String name;
    private int number;
    public String specification;
    private int warehouse_id;

    //ToDo constructor
    public Goods(int id, String name, int number, String specification, int warehouse_id) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.specification = specification;
        this.warehouse_id = warehouse_id;
    }

    public Goods() {
    }

    // public warehouse 1;
    //public inputOrder 1;
    //public sellOrder 1;

    /**
     * @param newname change name
     * @return change successfully true
     */
    public boolean modifyName(String newname) {
       this.name = newname;
       return true;
    }


    // 按id比较goods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return id == goods.id;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", warehouse_id=" + warehouse_id +
                '}';
    }
}