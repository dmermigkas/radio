package com.radio.Models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@DiscriminatorValue("AU")
@Table(name="AUTOSHOWS")
public class AutoShow extends Show{

    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name="genreid")
    private Genre genre;

    //private Policies policies = new Policies();

    public AutoShow(String name, Producer producer, int duration, Genre genre, Calendar playDateTime) {

        super.duration = duration;
        super.producer = producer;
        super.name = name;
        super.playDateTime = playDateTime;
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

//    public Policies getPolicies() {
//        return policies;
//    }
//
//    public void setPolicies(Policies policies) {
//        this.policies = policies;
//    }

}

