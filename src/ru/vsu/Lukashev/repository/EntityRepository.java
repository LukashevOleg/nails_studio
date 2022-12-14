package ru.vsu.Lukashev.repository;

public interface EntityRepository<T> {

    void create(T t);

    void remove(T t);

    void print();
}
