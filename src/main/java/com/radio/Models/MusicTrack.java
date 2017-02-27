package com.radio.Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MT")
@Table(name="MUSICTRACKS")
public class MusicTrack extends Track{

    @Column(name="title")
    private String title;

    @Column(name="artist")
    private String artist;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="genreid")
    private Genre genre;

    @Column(name="releaseyear")
    private int releaseYear;

    public MusicTrack(){}

    public MusicTrack(String title,String artist,Genre genre,int releaseYear, int duration){

        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        super.duration = duration;

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
