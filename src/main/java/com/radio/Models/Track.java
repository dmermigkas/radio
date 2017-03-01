package com.radio.Models;

import com.radio.Daos.DaoGeneric;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TRACK_TYPE")
@Table(name="TRACKS")
public abstract class Track {

    @Id
    @Column(name="trackId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trackId;

    @Column(name="duration")
    protected int duration;

    public Track(){};

    public Track(int duration){

        this.duration = duration;

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
