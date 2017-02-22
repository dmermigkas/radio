package com.radio.Models;

import com.radio.Daos.DaoFactory;

import javax.persistence.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;


@MappedSuperclass
public abstract class Track {

    @Column(name="duration", nullable=false)
    private Duration duration;

    private DaoFactory dao;

    public Track(){};

    public Track(DaoFactory dao,Duration duration){

        this.dao = dao;
        this.duration = duration;

    }

    public abstract <T> HashSet<T> getTracks();

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
