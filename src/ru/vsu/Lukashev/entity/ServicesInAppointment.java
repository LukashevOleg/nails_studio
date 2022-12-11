package ru.vsu.Lukashev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Master;

import java.util.HashMap;
import java.util.Map;


public class ServicesInAppointment implements Entity {

    private int idServices;
    private int idAppointment;

    private int actual_price;



    @Override
    public String toString() {
        return "ServicesInAppointment{" +
                "idServices=" + idServices +
                ", idAppointment=" + idAppointment +
                ", actual_price=" + actual_price +
                '}';
    }

    public ServicesInAppointment(int idAppointment, int idServices, int actual_price) {
        this.idServices = idServices;
        this.idAppointment = idAppointment;
        this.actual_price = actual_price;
    }


}
