package com.radio.Models;

import com.radio.Daos.DaoFactory;

import javax.persistence.*;
import java.time.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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

    private DaoFactory dao;

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
    private Set<Track> tracks = new HashSet<>();

    public <T> T getDao(){
        return dao.getDao();
    }

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

    public Set<Track> getTracks(){
        return tracks;
    }

    public abstract void addTrackToList(Track track);

    public abstract void removeTrackFromList(Track track);

}
