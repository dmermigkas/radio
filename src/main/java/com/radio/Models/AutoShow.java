package com.radio.Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("AU")
@Table(name="AUTOSHOWS")
public class AutoShow extends Show{

    @ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="SHOWGENRES",
            joinColumns = {@JoinColumn (name="showId")},
            inverseJoinColumns = {@JoinColumn(name="genreid")})
    private Genre genre;

    //private Policies policies = new Policies();

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void addTrackToList(Track track){
    }

    public void removeTrackFromList(Track track){

    }

//    public Policies getPolicies() {
//        return policies;
//    }
//
//    public void setPolicies(Policies policies) {
//        this.policies = policies;
//    }

}
