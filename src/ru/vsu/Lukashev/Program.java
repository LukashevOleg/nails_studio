package ru.vsu.Lukashev;

import ru.vsu.Lukashev.entity.*;
import ru.vsu.Lukashev.entity.human.Master;
import ru.vsu.Lukashev.repository.EntityRep;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException {

//        Connection connection = ConnectionOnly.getConnection();
//        Statement statement = connection.createStatement();
//        String query = String.format("SELECT * FROM \"%s\" ","Clients");
//
//        ResultSet resultSet = statement.executeQuery(query);
//        System.out.println("до вызова Евы");
//        List<Entity> rs = new ArrayList<>();
//        while (resultSet.next()) {
//            System.out.println(resultSet.getMetaData().getColumnClassName(1));
//            System.out.println("Hi, I'm " + resultSet.getString(2));
//        }
//        Object[] k = {1, "ss"};

//        System.out.println(k.length);
//        Class c = Human.class;
//        System.out.println(Entity.class.isAssignableFrom(c));
//        da(c);


        EntityRep entityRep = new EntityRep();

//        entityRep.getList(Service.class);

//        entityRep.deleteEntityByID(Client.class, 6);
        List<Class<? extends Entity>> list = new ArrayList<>(){{
            add(Master.class);
            add(Office.class);
        }};

//        entityRep.getJoinResult(list);

        entityRep.getListEntity(Master.class);

//        entityRep.getQuery(list);
//        entityRep.getListEntity(ServicesInAppointment.class);
//        entityRep.training(ServicesInAppointment.class);
//        entityRep.getEntityByID(Office.class, 3);
    }

    public static void da(Class<? extends Entity> c) {


    }
}
