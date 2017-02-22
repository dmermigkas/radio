package com.radio;

import com.radio.Models.*;
import com.radio.Daos.*;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Calendar today = Calendar.getInstance();


        Producer prod = new Producer("dimitris", "mermigkas", new EmailAddress("ddsadasds"));
        //Producer prod = new Producer(new MusicTrackDao(), "dimitris", "mermigkas", new EmailAddress("ddsadasds"));
//        MusicTrackDao dao = prod.getDao();

        MusicTrack track = new MusicTrack("test","test artist",new Genre("test"),1990);

        Track track2 = new MusicTrack("test","test artist",new Genre("test"),1990);

        PlaylistShow pl = new PlaylistShow();
        pl.addTrackToList(track);
        prod.addPlaylistShow(pl);
        prod.getPlaylistShows();

//        MusicTrack track = new MusicTrack("test","test artist",new Genre("test"),1990);
//        AdTrack ad = new AdTrack("test",new PlayBackZone(today,today),today,today,4);
//        PlaylistShow pl = new PlaylistShow();
//        pl.addMusicTrackToList(track);
//        pl.removeMusicTrackFromList(track);
//        pl.addAdTrackToList(ad);
//
//        AutoShow auto = new AutoShow();
//        auto.getPolicies().playedLastHour();

    }

}