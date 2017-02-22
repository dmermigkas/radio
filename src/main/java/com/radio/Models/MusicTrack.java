package com.radio.Models;

import javax.persistence.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="MUSICTRACKS")
public class MusicTrack extends Track{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="artist")
    private String artist;

    @ManyToOne
    @JoinColumn(name="genreid", nullable = false)
    private Genre genre;

    @Column(name="releaseyear")
    private int releaseYear;

    //private Set<MusicTrack> musicTracks = new HashSet<>();

    public MusicTrack(String title,String artist,Genre genre,int releaseYear){

        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;

    }

    @Override
    public HashSet<MusicTrack> getTracks(){
        System.out.println(new HashSet<MusicTrack>());
        return new HashSet<MusicTrack>();
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
