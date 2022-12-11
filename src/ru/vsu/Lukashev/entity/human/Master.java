package ru.vsu.Lukashev.entity.human;

import lombok.*;
import ru.vsu.Lukashev.entity.Office;

import java.util.HashMap;
import java.util.Map;


public class Master extends Human {


    private final double salary;
    private final int office_ID;

    public Master(long ID, String name, double salary, int office_ID) {
        super(ID, name);
        this.office_ID = office_ID;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Master{" +
                " name='" + getName() + '\'' +
                "salary=" + salary +
                '}';
    }

//    public Master(long ID, String name, double salary) {
//        super(ID, name);
//        this.salary = salary;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "Master{" +
//                "name=" + getName() +
//                "salary=" + salary +
//                '}';
//    }
}
