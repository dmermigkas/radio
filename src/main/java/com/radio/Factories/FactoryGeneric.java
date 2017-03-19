package com.radio.Factories;

import java.util.List;
import java.util.Set;

public interface FactoryGeneric <T, E>{

    T create(T entity);
    List<T> getAll();
    T get(E id);
    T update(T entity);
    void remove(T entity);
    boolean removeById(E id);

}
