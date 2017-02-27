package com.radio.Models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@DiscriminatorValue("PL")
@Table(name="PLAYLISTSHOWS")
public class PlaylistShow extends Show{

    public void addTrackToList(Track track){

        if (track != null) {

            super.tracks.add(track);
            System.out.println(super.getTracks());

        }

    }

    public void removeTrackFromList(Track track){

        if (track != null) {

            super.getTracks().remove(track);
            System.out.println(super.getTracks());

        }

    }

    public PlaylistShow(String name, Producer producer, int duration, Calendar playDateTime) {

        super.name = name;
        super.producer = producer;
        super.duration = duration;
        super.playDateTime = playDateTime;
    }

    public PlaylistShow(){}

}
