package ru.vsu.Lukashev.entityFactory;

import ru.vsu.Lukashev.entity.*;
import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Master;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityFactory {
    private Map<Class<?>, String> entityInBase;

    private void createEntityInBaseMap(){
        entityInBase = new HashMap<>();
        entityInBase.put(Master.class, "Masters");
        entityInBase.put(Client.class, "Clients");
        entityInBase.put(Office.class, "Offices");
        entityInBase.put(Service.class, "Services");
        entityInBase.put(Appointment.class, "Appointments");

    }

    public EntityFactory() {
        createEntityInBaseMap();
    }

    public Entity createEntity(Class<? extends Entity> c, ResultSet resultSet,
                               int number, Class<?>[] typeArg, Object[] valueArg) throws SQLException {
        String tableName = entityInBase.get(c);
        Entity entity = null;
//        Constructor<?> constructor = c.getDeclaredConstructors()[0];
//        Class<?>[] typeArg = constructor.getParameterTypes();
//        Object[] valueArg = new Object[typeArg.length];

        for(int i = 0, k = number; i < typeArg.length; i++, k++){
            valueArg[i] = resultSet.getObject(k);
        }
        try {
            entity = c.getDeclaredConstructor(typeArg).newInstance(valueArg);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public Entity createJoinEntity(List<Class<? extends Entity>> listClasses, ResultSet resultSet) throws SQLException {
        List<Entity> listJoinEntity = new ArrayList<>();

        int number = 1;
        for(Class<? extends Entity> c : listClasses){
            Constructor<?> constructor = c.getDeclaredConstructors()[0];
            Class<?>[] typeArg = constructor.getParameterTypes();
            Object[] valueArg = new Object[typeArg.length];
            listJoinEntity.add(createEntity(c, resultSet, number,
                    typeArg, valueArg));
            number += typeArg.length;
        }
        return new JoinEntity(listJoinEntity);

    }


    public Entity createEntity(Class<? extends Entity> c, ResultSet resultSet,
                               Class<?>[] typeArg, Object[] valueArg) throws SQLException {
        String tableName = entityInBase.get(c);
        Entity entity = null;
//        Constructor<?> constructor = c.getDeclaredConstructors()[0];
//        Class<?>[] typeArg = constructor.getParameterTypes();
//        Object[] valueArg = new Object[typeArg.length];

        for(int i = 0, k = 1; i < typeArg.length; i++, k++){
            valueArg[i] = resultSet.getObject(k);
        }
        try {
            entity = c.getDeclaredConstructor(typeArg).newInstance(valueArg);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return entity;
    }

}
