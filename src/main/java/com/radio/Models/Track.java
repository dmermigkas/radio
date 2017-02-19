package com.radio.Models;

import com.radio.Daos.DaoFactory;

import javax.persistence.*;
import java.time.Duration;


@MappedSuperclass
public class Track {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="duration", length = 20, nullable=false)
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
