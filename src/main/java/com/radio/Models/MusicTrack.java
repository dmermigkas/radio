package com.radio.Models;

import java.time.Duration;

public class MusicTrack extends Track{

    private Integer id;
    private String title;
    private String artist;
    private Genre genre;
    private int releaseYear;

    public MusicTrack(){};

    public MusicTrack(String title,String artist,Genre genre,int releaseYear){

        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

}
