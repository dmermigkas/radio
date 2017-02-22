package com.radio.Models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ADTRACKS")
public class AdTrack extends Track{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="brand")
    private String brand;

    @Embedded
    private PlayBackZone zone;

    @Column(name="fromdate")
    private Calendar fromDate;

    @Column(name="todate")
    private Calendar toDate;

    @Column(name="playsperzone")
    private int playsPerZone; //

    //private Set<Track> adTracks = new HashSet<>();

    public AdTrack(){};

    public AdTrack(String brand, PlayBackZone zone, Calendar from, Calendar to, int playsPerZone){

        this.brand = brand;
        this.zone = zone;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.playsPerZone = playsPerZone;

    }

    @Override
    public HashSet<AdTrack> getTracks(){
        return new HashSet<AdTrack>();
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
        return fromDate;
    }

    public void setFrom(Calendar from) {
        this.fromDate = from;
    }

    public Calendar getTo() {
        return toDate;
    }

    public void setTo(Calendar to) {
        this.toDate = to;
    }

    public int getPlaysPerZone() {
        return playsPerZone;
    }

    public void setPlaysPerZone(int playsPerZone) {
        this.playsPerZone = playsPerZone;
    }
}
