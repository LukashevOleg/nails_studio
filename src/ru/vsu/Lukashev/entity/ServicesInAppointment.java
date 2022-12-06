package ru.vsu.Lukashev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ServicesInAppointment {

    private long idAppointment;
    private long idServices;
    private long idServicesInAppointment;

    private double price;


}
