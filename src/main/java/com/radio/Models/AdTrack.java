package com.radio.Models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("AD")
@Table(name="ADTRACKS")
public class AdTrack extends Track{

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

    public AdTrack(){};

    public AdTrack(String brand, PlayBackZone zone, Calendar fromDate, Calendar toDate, int playsPerZone, int duration){

        this.brand = brand;
        this.zone = zone;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.playsPerZone = playsPerZone;
        super.duration = duration;

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
        return this.fromDate;
    }

    public void setFrom(Calendar from) {
        this.fromDate = from;
    }

    public Calendar getTo() {
        return this.toDate;
    }

    public void setTo(Calendar to) {
        this.toDate = to;
    }

    public int getPlaysPerZone() {
        return this.playsPerZone;
    }

    public void setPlaysPerZone(int playsPerZone) {
        this.playsPerZone = playsPerZone;
    }
}
