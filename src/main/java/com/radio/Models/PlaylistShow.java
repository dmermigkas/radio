package com.radio.Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PL")
@Table(name="PLAYLISTSHOWS")
public class PlaylistShow extends Show{

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
