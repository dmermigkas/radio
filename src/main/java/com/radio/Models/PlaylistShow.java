package com.radio.Models;

public class PlaylistShow extends Show{

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
//s
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
