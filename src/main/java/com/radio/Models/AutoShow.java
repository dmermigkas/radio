package com.radio.Models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@DiscriminatorValue("AU")
@Table(name="AUTOSHOWS")
public class AutoShow extends Show{

    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name="genreid")
    private Genre genre;

    //private Policies policies = new Policies();


    public AutoShow() {
    }

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

    @Override
    public boolean equals(Object other) {
        if ( other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (! (other instanceof AutoShow)) {
            return false;
        }

        AutoShow musicTrack = (AutoShow) other;
        if (! (getName() == null ? musicTrack.getName()
                == null : getName().equals(musicTrack.getName()))) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.hashCode();
    }

//    public Policies getPolicies() {
//        return policies;
//    }
//
//    public void setPolicies(Policies policies) {
//        this.policies = policies;
//    }

}

