package ru.vsu.Lukashev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Master;

import java.util.HashMap;
import java.util.Map;


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


}
