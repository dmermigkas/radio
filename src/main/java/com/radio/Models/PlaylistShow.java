package com.radio.Models;

import javax.persistence.*;

@Entity
@Table(name="PLAYLISTSHOWS")
public class PlaylistShow extends Show{

    @Id
    @Column(name="playlistshowid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public void addMusicTrackToList(MusicTrack track){

        if (track != null) {
            getMusicTracks().add(track);
            getMusicTracks();
        }

    }

    public void removeMusicTrackFromList(MusicTrack track){

        if (track != null) {
            getMusicTracks().remove(track);
            getMusicTracks();
        }
//
    }

    public void addAdTrackToList(AdTrack track){

        if (track != null) {
            getAdTracks().add(track);
            getAdTracks();
        }

    }

    public void removeAdTrackFromList(AdTrack track){

        if (track != null) {
            getAdTracks().remove(track);
            getAdTracks();
        }

    }


}
