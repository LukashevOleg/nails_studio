package ru.vsu.Lukashev.entity.human;

import lombok.*;



public class Master extends Human {

    private double salary;

    public Master(long ID, String name, double salary) {
        super(ID, name);
        this.salary = salary;
    }

    @Override
    public int getCountFields(){
        return super.getCountFields() + 1;
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
