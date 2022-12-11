package ru.vsu.Lukashev.entity;

import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Master;

import java.util.HashMap;
import java.util.Map;

public class InfoEntity {

    private static final Map<Class<? extends Entity>, String> masterForeignKey = new HashMap<>(){{
        put(Office.class, "office_id");
    }};

    private static final Map<Class<? extends Entity>, String> appointmentForeignKey = new HashMap<>(){{
        put(Master.class, "master_id");
        put(Client.class, "client_id");
    }};

    private static final Map<Class<? extends Entity>, String> servicesInAppointmentForeignKey = new HashMap<>(){{
        put(Service.class, "service_id");
        put(Appointment.class, "appointment_id");
    }};

    private static final Map<Class<? extends Entity>, Map<Class<? extends Entity>, String>> mapForeignKeys = new HashMap<>()
    {{
        put(Client.class, null);
        put(Master.class, masterForeignKey);
        put(Appointment.class, appointmentForeignKey);
        put(Office.class, null);
        put(Service.class, null);
        put(ServicesInAppointment.class, servicesInAppointmentForeignKey);
    }};

    public static Map<Class<? extends Entity>, Map<Class<? extends Entity>, String>> getMapForeignKeys(){
        return mapForeignKeys;
    }


}
