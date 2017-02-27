package com.radio.Daos;

import java.util.Set;

public interface DaoGeneric<T,E> {

    //<T> T getDao();
    void add(T entity) ;
    void saveOrUpdate(T entity) ;
    void update(T entity) ;
    void remove(T entity);
    T find(E key);
    Set<T> getAll();

}
