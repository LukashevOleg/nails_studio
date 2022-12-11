package ru.vsu.Lukashev.entity;

import ru.vsu.Lukashev.entity.Entity;
import ru.vsu.Lukashev.entityFactory.EntityFactory;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JoinEntity implements Entity {
    private List<Entity> listJoinEntity;

    public JoinEntity(List<Entity> listJoinEntity) {
        this.listJoinEntity = listJoinEntity;
    }

    @Override
    public String toString() {
        return "JoinEntity{" +
                "listJoinEntity=" + listJoinEntity +
                '}';
    }

    //    public JoinEntity(List<Class<? extends Entity>> listJoinEntity) {
//        this.listJoinEntity = listJoinEntity;
//    }




}
