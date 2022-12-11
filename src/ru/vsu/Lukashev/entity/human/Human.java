package ru.vsu.Lukashev.entity.human;

import lombok.*;
import ru.vsu.Lukashev.entity.Entity;

@Data
@EqualsAndHashCode
public abstract class Human implements Entity {

    private long ID;
    private String name;

//    public Human() {
//    }

    public Human(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                " name='" + name + '\'' +
                '}';
    }





}
