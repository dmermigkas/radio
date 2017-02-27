package com.radio.Models;

import com.radio.Daos.DaoGeneric;

import javax.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="SHOW_TYPE")
@Table(name="SHOWS")
public abstract class Show {

    @Id
    @Column(name="showId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer showId;

    @Column(name="name")
    protected String name;

    @Column(name="playdatetime")
    protected Calendar playDateTime;

    @Column(name="duration")
    protected int duration;

    @Transient
    private DaoGeneric dao;

    //Relational Properties
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="producerid")
    protected Producer producer;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            fetch=FetchType.LAZY)
    @JoinTable(name="SHOWTRACKS",
            joinColumns = {@JoinColumn(name="showId")},
            inverseJoinColumns = {@JoinColumn(name="trackId")}
    )
    protected List<Track> tracks = new ArrayList<>();

    public Show(){}

    public Show(String name,Calendar playDateTime,int duration){

        //this.dao = dao;
        this.name = name;
        this.playDateTime = playDateTime;
        this.duration = duration;

    }

//    public <T> T getDao(){
//        return dao.getDao();
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getPlayDateTime() {
        return playDateTime;
    }

    public void setPlayDateTime(Calendar playDateTime) {
        this.playDateTime = playDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<Track> getTracks(){
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    //    public abstract void addTrackToList(Track track);
//
//    public abstract void removeTrackFromList(Track track);

}