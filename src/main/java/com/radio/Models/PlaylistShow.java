package com.radio.Models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

@Entity
@DiscriminatorValue("PL")
@Table(name="PLAYLISTSHOWS")
public class PlaylistShow extends Show{

    public PlaylistShow(){}

    public PlaylistShow(String name, Producer producer, int duration, Long playDateTime) {

        super.name = name;
        super.producer = producer;
        super.duration = duration;
        super.playDateTime = playDateTime;
    }

    public void addTrackToList(Track track){

        if (track != null) {

            super.getTracks().add(track);
            System.out.println(super.getTracks());

        }

    }

    public void removeTrackFromList(Track track){

        if (track != null) {

            super.getTracks().remove(track);
            System.out.println(super.getTracks());

        }

    }

}
