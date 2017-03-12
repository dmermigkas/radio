package com.radio.Resources;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lotv on 11/03/2017.
 */
@XmlRootElement
public class MusicTrackInfo {

    FactoryGeneric musicTrackFactory;

    private Integer id;
    private String title;
    private String artist;
    private Integer duration;
    private Integer releaseYear;
    private String genre;

    public MusicTrackInfo(String title, String artist, Integer duration, Integer releaseYear, String genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public MusicTrackInfo(Integer id, String title, String artist, Integer duration, Integer releaseYear, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public MusicTrackInfo(MusicTrack musicTrack){
        id=musicTrack.getId();
        title=musicTrack.getTitle();
        artist=musicTrack.getArtist();
        duration=musicTrack.getDuration();
        releaseYear=musicTrack.getReleaseYear();
        genre=musicTrack.getGenre().getGenre();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static MusicTrackInfo wrap(MusicTrack musicTrack) {return new MusicTrackInfo(musicTrack);}


    public static List<MusicTrackInfo> wrap(List<MusicTrack> musicTracks) {

        List<MusicTrackInfo> musicTrackInfoList = new ArrayList<>();

        for (MusicTrack b : musicTracks) {
            musicTrackInfoList.add(new MusicTrackInfo(b));
        }

        return musicTrackInfoList;

    }

    public MusicTrack getMusicTrack(){ //todo check if factory is used properly

        MusicTrack musicTrack = null;
        musicTrackFactory = new FactoryGenericImpl(MusicTrack.class);

        if (id != null) {
            musicTrack = (MusicTrack)musicTrackFactory.get(id);
        } else {
            musicTrack = new MusicTrack();
        }

        musicTrack.setArtist(artist);
        musicTrack.setTitle(title);
        musicTrack.setDuration(duration);
        musicTrack.setReleaseYear(releaseYear);


        if (musicTrack.getGenre() == null || !musicTrack.getGenre().getGenre().equals(genre)) {
            musicTrack.setGenre(new Genre(genre));
        }

        return musicTrack;
    }




}