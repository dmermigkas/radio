package com.radio.Daos;

import javax.persistence.EntityManager;
import java.util.Set;

public interface DaoGeneric<T,E> {

    //<T> T getDao();
    void add(T entity,EntityManager em) ;
    Boolean create(T entity,EntityManager em) ;
    void update(T entity) ;
    void remove(T entity);
    T find(E key);
    Set<T> getAll();

}
