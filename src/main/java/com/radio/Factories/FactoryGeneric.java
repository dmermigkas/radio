package com.radio.Factories;

import java.util.List;
import java.util.Set;

public interface FactoryGeneric <T, E>{

    void create(T entity);
    List<T> getAll();
    T get(E id);
    boolean update(T entity,E id);
    void remove(T entity);
    boolean removeById(E id);

}
