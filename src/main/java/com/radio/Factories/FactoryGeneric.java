package com.radio.Factories;

import java.util.Set;

public interface FactoryGeneric <T, E>{

    public void create(T entity);
    public Set<T> getAll();
    public T get(E id);
    public void add(T entity);
    public void update(T entity);
    public void remove(T entity);

}
