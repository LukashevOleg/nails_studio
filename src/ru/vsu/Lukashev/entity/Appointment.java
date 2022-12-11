package ru.vsu.Lukashev.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Master;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Appointment implements Entity{

    private int idClient;
    private int idMaster;
    private int idAppointment;

    private int totalCost;
    private Date date;
    private Time time;


    @Override
    public String toString() {
        return "Appointment{" +
                "idClient=" + idClient +
                ", idMaster=" + idMaster +
                ", idAppointment=" + idAppointment +
                ", totalCost=" + totalCost +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Appointment(int idAppointment, int idClient, int idMaster, int totalCost, Date date, Time time) {
        this.idClient = idClient;
        this.idMaster = idMaster;
        this.idAppointment = idAppointment;
        this.totalCost = totalCost;
        this.date = date;
        this.time = time;
    }
}
