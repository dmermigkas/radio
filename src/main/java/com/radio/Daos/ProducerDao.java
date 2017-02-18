package com.radio.Daos;

public class ProducerDao implements DaoFactory{

    public ProducerDao getDao(){
        System.out.println("Producer Dao");
        return new ProducerDao();
    }

    public void add(){
        System.out.println("i am addin");
    }

}
