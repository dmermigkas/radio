package com.radio.Models;

public class PlaylistShow extends Show{

    private Integer id;

    public void addMusicTrackToList(MusicTrack track){
        if (author != null) {
            author.addBook(this);
        }
    }

}
