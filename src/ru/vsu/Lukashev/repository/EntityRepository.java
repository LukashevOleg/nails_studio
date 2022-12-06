package ru.vsu.Lukashev.repository;

public interface EntityRepository<T> {
    void save(T t);
    void remove(T t);
    void print();
}
