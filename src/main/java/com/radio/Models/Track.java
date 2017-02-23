package com.radio.Models;

import com.radio.Daos.DaoFactory;

import javax.persistence.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TRACK_TYPE")
@Table(name="TRACKS")
public class Track {

    @Id
    @Column(name="trackId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trackId;

    @Column(name="duration", nullable=false)
    private int duration;

    private DaoFactory dao;

    public Track(){};

    public Track(DaoFactory dao,int duration){

        this.dao = dao;
        this.duration = duration;

    }

    public <T> T getDao(){
        return dao.getDao();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
