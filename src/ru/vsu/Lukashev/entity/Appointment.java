package ru.vsu.Lukashev.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Appointment {

    private long idClient;
    private long idMaster;
    private long idAppointment;

    private double totalCost;
    private String date;
    private String time;


}
