package com.example.project.domain;

import java.util.Objects;


public class Goods {

    private int id;
    private String name;
    private int number;
    public String specification;
    private static int times = 1;

    //ToDo constructor
    public Goods(String name, int number, String specification) {
        this.id = times;
        this.name = name;
        this.number = number;
        this.specification = specification;
        times++;
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

    /**
     * @param newnumber change number
     * @return change successfully true
     */
    public boolean modifyNumber(int newnumber) {
        this.number = newnumber;
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

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, specification);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
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

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public static int getTimes() {
        return times;
    }

    public static void setTimes(int times) {
        Goods.times = times;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", specification='" + specification + '\'' +
                '}';
    }
}