package ru.vsu.Lukashev;

import ru.vsu.Lukashev.entity.Entity;
import ru.vsu.Lukashev.entity.Office;
import ru.vsu.Lukashev.entity.Service;
import ru.vsu.Lukashev.entity.human.Client;
import ru.vsu.Lukashev.entity.human.Human;
import ru.vsu.Lukashev.entity.human.Master;
import ru.vsu.Lukashev.repository.EntityRep;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.sql.*;
import java.sql.Connection;
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

        entityRep.getList(Service.class);
    }

    public static void da(Class<? extends Entity> c) {
        System.out.println(c);
        Constructor<?> constructor1 = null;
        Object entity = null;
//        constructor = c.getEnclosingConstructor();

//        System.out.println(cAgr);


//        Constructor<?> constructor = c.getDeclaredConstructors()[0];
//        Class<?>[] cArg = constructor.getParameterTypes();
//
//        try {
//            entity = c.getDeclaredConstructor(cArg).newInstance(l, s, i);
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//        try {
//
//            constructor = c.getDeclaredConstructors();
////            Parameter[] cAgr = constructor.getParameters();
////            System.out.println(cAgr.length);
////            entity = ;
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

        System.out.println(entity.toString() + " ociajdck");

    }
}
