package com.radio.Models;

import com.radio.Daos.DaoGeneric;

import javax.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
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
    protected Long playDateTime;

    @Column(name="duration")
    protected int duration;

    //Relational Properties
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="producerid")
    protected Producer producer;

    @OneToMany(orphanRemoval = true,cascade = { CascadeType.PERSIST,CascadeType.MERGE},
            fetch=FetchType.EAGER)
    @JoinColumn(name="showId")
//    @JoinTable(name="SHOWTRACKS",
//            joinColumns = {@JoinColumn(name="showId")},
//            inverseJoinColumns = {@JoinColumn(name="trackId")}
//    )
    protected List<Track> tracks = new ArrayList<>();

    public Show(){}

    public Show(String name,Long playDateTime,int duration){

        this.name = name;
        this.playDateTime = playDateTime;
        this.duration = duration;

    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPlayDateTime() {
        return playDateTime;
    }

    public void setPlayDateTime(Long playDateTime) {
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

    public int getId() { return showId; }

}
