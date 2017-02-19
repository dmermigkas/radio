package com.radio.Models;

import com.radio.Daos.DaoFactory;

import java.time.Duration;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Show {

    private Integer id;
    private String name;
    private Calendar playDateTime;
    private Duration duration;
    private DaoFactory dao;

    //Relational Properties
    private Producer producer;
    private Set<MusicTrack> musicTracks = new HashSet<>();
    private Set<AdTrack> adTracks = new HashSet<>();

    public Show(){};

    public Show(DaoFactory dao,String name,Calendar playDateTime,Duration duration,Producer producer){

        this.dao = dao;
        this.name = name;
        this.playDateTime = playDateTime;
        this.duration = duration;
        this.producer = producer;

    }

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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Set<MusicTrack> getMusicTracks() {
        System.out.println(musicTracks);
        return musicTracks;
    }

    public void setMusicTracks(Set<MusicTrack> musicTracks) {
        this.musicTracks = musicTracks;
    }

    public Set<AdTrack> getAdTracks() {
        System.out.println(adTracks);
        return adTracks;
    }

    public void setAdTracks(Set<AdTrack> adTracks) {
        this.adTracks = adTracks;
    }
}
