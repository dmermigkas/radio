package com.radio.Daos;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public interface DaoGeneric<T,E> {

    T create(T entity,EntityManager em) ;
    void update(T entity,EntityManager em) ;
    void remove(T entity,EntityManager em);
    boolean removeById(E key,EntityManager em);
    T find(E key,EntityManager em);
    List<T> getAll(EntityManager em);

}
