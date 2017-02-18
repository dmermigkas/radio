package com.radio.Daos;

public abstract class TrackDao implements DaoFactory{

    public TrackDao getDao(){
        return getChildDao();
    }

    public abstract <T> T getChildDao();

}
