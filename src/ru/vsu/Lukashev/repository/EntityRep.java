package ru.vsu.Lukashev.repository;

import ru.vsu.Lukashev.ConnectionOnly;
import ru.vsu.Lukashev.entity.Entity;
import ru.vsu.Lukashev.entity.Office;
import ru.vsu.Lukashev.entity.Service;
import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Master;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class EntityRep {

    private Connection connection;

    private Map<Class<?>, String> entityInBase;

    public EntityRep() {
        try {
            before();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void before() throws SQLException {
        connection = ConnectionOnly.getConnection();
        createEntityInBaseMap();

    }

    private void createEntityInBaseMap(){
        entityInBase = new HashMap<>();
        entityInBase.put(Master.class, "Masters");
        entityInBase.put(Client.class, "Clients");
        entityInBase.put(Office.class, "Offices");
        entityInBase.put(Service.class, "Services");

    }

    public List<Entity> getList(Class<? extends Entity> c){
        List<Entity> entityList = new ArrayList<>();

        String tableName = entityInBase.get(c);

//      int fieldsCount =c.getCountFields();
        try (Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM \"%s\" ", tableName);
            ResultSet resultSet = statement.executeQuery(query);
            Entity entity = null;
            Constructor<?> constructor = c.getDeclaredConstructors()[0];
            Class<?>[] typeArg = constructor.getParameterTypes();
            Object[] valueArg = new Object[typeArg.length];

            while (resultSet.next())
            {
                for(int i = 0, k = 1; i < typeArg.length; i++, k++){
                    valueArg[i] = resultSet.getObject(k);
                }
                try {
                entity = c.getDeclaredConstructor(typeArg).newInstance(valueArg);
                }
                catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                entityList.add(entity);
            }

            print(entityList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entityList;
    }

    private <T> void print(List<T>  list){
        for (T t : list)
            System.out.println(t);
    }


//    private Class<?>

}
