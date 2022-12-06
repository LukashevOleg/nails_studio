package ru.vsu.Lukashev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Services {

    private float ID;

    private double actualPrice;
    private String info;


}
