package com.radio.Factories;

import java.util.List;
import java.util.Set;

public interface FactoryGeneric <T, E>{

    void create(T entity);
    List<T> getAll();
    T get(E id);
    //public void add(T entity);
    void update(T entity);
    void remove(T entity);

}
