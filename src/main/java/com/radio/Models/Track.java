package com.radio.Models;

import com.radio.Daos.DaoFactory;

import java.time.Duration;

public class Track {

    private Integer id;
    private Duration duration;
    private DaoFactory dao;

    public Track(){};

    public Track(DaoFactory dao,Duration duration){

        this.dao = dao;
        this.duration = duration;

    }

    public <T> T getDao(){
        return dao.getDao();
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

}
