package com.radio.Daos;

public abstract class ShowDao implements DaoFactory{

    public ShowDao getDao(){
        return getChildDao();
    }

    public abstract <T> T getChildDao();

}
