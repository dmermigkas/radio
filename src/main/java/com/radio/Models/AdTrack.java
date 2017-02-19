package com.radio.Models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="ADTRACKS")
public class AdTrack extends Track{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="brand")
    private String brand;

    @Column(name="playbackzone")
    private PlayBackZone zone;


    private Calendar from;
    private Calendar to;
    private int playsPerZone; //

    public AdTrack(){};

    public AdTrack(String brand, PlayBackZone zone, Calendar from, Calendar to, int playsPerZone){

        this.brand = brand;
        this.zone = zone;
        this.from = from;
        this.to = to;
        this.playsPerZone = playsPerZone;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public PlayBackZone getZone() {
        return zone;
    }

    public void setZone(PlayBackZone zone) {
        this.zone = zone;
    }

    public Calendar getFrom() {
        return from;
    }

    public void setFrom(Calendar from) {
        this.from = from;
    }

    public Calendar getTo() {
        return to;
    }

    public void setTo(Calendar to) {
        this.to = to;
    }

    public int getPlaysPerZone() {
        return playsPerZone;
    }

    public void setPlaysPerZone(int playsPerZone) {
        this.playsPerZone = playsPerZone;
    }
}
