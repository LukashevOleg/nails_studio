package ru.vsu.Lukashev.entity.human;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Master extends Human {

    private double salary;

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
