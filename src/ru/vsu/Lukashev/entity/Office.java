package ru.vsu.Lukashev.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode
public class Office implements Entity{

    private int ID;
    private String address;

    @Override
    public int getCountFields(){
        return 2;
    }

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
