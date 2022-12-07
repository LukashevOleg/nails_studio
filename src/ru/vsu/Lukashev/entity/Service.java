package ru.vsu.Lukashev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


public class Service implements Entity {


    private int ID;
    private String info;
    private double actualPrice;


    public Service(int ID, String info, double actualPrice) {
        this.ID = ID;
        this.actualPrice = actualPrice;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Service{" +
                "actualPrice=" + actualPrice +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public int getCountFields() {
        return 3;
    }
}
