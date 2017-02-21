package com.radio.Models;

import javax.persistence.*;

@Entity
@Table(name="PLAYLISTSHOWS")
public class PlaylistShow extends Show{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public void addTrackToList(Track track){

        if (track != null) {
            //test
            track.getTracks().add(track);
            track.getTracks();
        }

    }

    public void removeMusicTrackFromList(Track track){

        if (track != null) {
            track.getTracks().remove(track);
            track.getTracks();
        }
//
    }

    public void addAdTrackToList(Track track){

        if (track != null) {
            track.getTracks().add(track);
            track.getTracks();
        }

    }

    public void removeAdTrackFromList(Track track){

        if (track != null) {
            track.getTracks().remove(track);
            track.getTracks();
        }

    }


}
