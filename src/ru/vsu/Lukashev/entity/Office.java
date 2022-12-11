package ru.vsu.Lukashev.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Master;

import java.util.HashMap;
import java.util.Map;


@EqualsAndHashCode
public class Office implements Entity{

    private int ID;
    private String address;

    public Office(int ID, String address) {
        this.ID = ID;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Office{" +
                "address='" + address + '\'' +
                '}';
    }
}
