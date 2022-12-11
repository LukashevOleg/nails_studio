package ru.vsu.Lukashev.repository;

import ru.vsu.Lukashev.ConnectionOnly;
import ru.vsu.Lukashev.entity.*;
import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Master;
import ru.vsu.Lukashev.entityFactory.EntityFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class EntityRep {

    private Connection connection;
    private final EntityFactory entityFactory = new EntityFactory();
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
        entityInBase.put(Appointment.class, "Appointments");
        entityInBase.put(ServicesInAppointment.class, "Services_in_appointment");

    }

    public List<Entity> getListEntity(Class<? extends Entity> c){
        List<Entity> entityList = new ArrayList<>();

        String tableName = entityInBase.get(c);

//      int fieldsCount =c.getCountFields();
        try (Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM \"%s\" ", tableName);
            ResultSet resultSet = statement.executeQuery(query);
//            Entity entity = null;
            Constructor<?> constructor = c.getDeclaredConstructors()[0];
            Class<?>[] typeArg = constructor.getParameterTypes();
            Object[] valueArg = new Object[typeArg.length];

            while (resultSet.next()) {

//                entityFactory.createEntity(c, resultSet);
//                for(int i = 0, k = 1; i < typeArg.length; i++, k++){
//                    valueArg[i] = resultSet.getObject(k);
//                }
//                try {
//                    entity = c.getDeclaredConstructor(typeArg).newInstance(valueArg);
//                }
//                catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//                    e.printStackTrace();
//                }



                entityList.add(entityFactory.createEntity(c, resultSet, typeArg, valueArg));
            }

            print(entityList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entityList;
    }


    private String getQuery(List<Class<? extends Entity>> classList ){
        List<String> tableList = new ArrayList<>();
        for(Class<? extends Entity> c : classList){
            tableList.add(entityInBase.get(c));
        }

        Map<Class<? extends Entity>, String> map = InfoEntity.getMapForeignKeys().get(classList.remove(0));

        List<String> listForeignKey = new ArrayList<>();

        for(Class<? extends Entity> c : classList){
//            tableList.add(entityInBase.get(c));
            listForeignKey.add(map.get(c));
        }

        System.out.println(tableList);
        System.out.println(listForeignKey);

        String query = String.format("SELECT * FROM \"%s\" a", tableList.remove(0));
        int curTable = 1;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Iterator<String> listForeignKeyIterator = listForeignKey.iterator();
        Iterator<String> tableListIterator = tableList.iterator();

        while (tableListIterator.hasNext() && listForeignKeyIterator.hasNext()) {
            query = String.format("%s INNER JOIN \"%s\" %s ON a.%s = %s.id", query, tableListIterator.next(),
                    alphabet[curTable], listForeignKeyIterator.next(), alphabet[curTable]);
            curTable++;
        }
        System.out.println(query);
        System.out.println("right: SELECT * FROM \"Services_in_appointment\" a\n" +
                "\tINNER JOIN \"Services\" b \n" +
                "\tON a.service_id = b.id\n");

        return query;
//        +
//                "\tINNER JOIN \"Appointments\" c ON c.id = a.appointment_id");


//        for(Map.Entry<Class<? extends Entity>, String> cur : map.entrySet()){
//            listForeignKey.add(cur.getValue())
//        }

    }







    public Entity getEntityByID(Class<? extends Entity> c, int ID){

        Entity entity = null;

        String tableName = entityInBase.get(c);

        try (Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM \"%s\" m WHERE m.id = %d", tableName, ID);
            ResultSet resultSet = statement.executeQuery(query);
            Constructor<?> constructor = c.getDeclaredConstructors()[0];
            Class<?>[] typeArg = constructor.getParameterTypes();
            Object[] valueArg = new Object[typeArg.length];

            while (resultSet.next()) {
                for(int i = 0, k = 1; i < typeArg.length; i++, k++){
                    valueArg[i] = resultSet.getObject(k);
                }
                try {
                    entity = c.getDeclaredConstructor(typeArg).newInstance(valueArg);
                }
                catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }

            }


            System.out.println(entity);

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return entity;
    }






    public void getJoinResult(List<Class<? extends Entity>> classList ){

        List<Entity> entityList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String query = getQuery(new ArrayList<>(classList));

            ResultSet resultSet = statement.executeQuery(query);
//            Entity entity = null;
//            Constructor<?> constructor = c1.getDeclaredConstructors()[0];
//            Class<?>[] typeArg = constructor.getParameterTypes();
//            Object[] valueArg = new Object[typeArg.length];


            while (resultSet.next()) {

//                entityFactory.createEntity(c, resultSet);
//                for(int i = 0, k = 1; i < typeArg.length; i++, k++){
//                    valueArg[i] = resultSet.getObject(k);
//                }
//                try {
//                    entity = c.getDeclaredConstructor(typeArg).newInstance(valueArg);
//                }
//                catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//                    e.printStackTrace();
//                }



                entityList.add(entityFactory.createJoinEntity(classList, resultSet));
            }

            print(entityList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    private <T> void print(List<T>  list){
        for (T t : list)
            System.out.println(t);
    }


//    private Class<?>

}
