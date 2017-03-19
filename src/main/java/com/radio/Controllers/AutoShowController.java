package com.radio.Controllers;

import com.radio.Factories.*;
import com.radio.Models.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AutoShowController extends ShowController{

    TrackFactory trackDao = new TrackFactoryImpl();

    public AutoShow fillAutoshow(List<MusicTrack> musicTracks,List<AdTrack> adTracks,AutoShow myShow){

        FactoryGeneric showDao = new FactoryGenericImpl(AutoShow.class);

        List<Track> showTracks = new ArrayList<>();

        for(MusicTrack musicTrack : musicTracks) {

            if(musicTrack.getGenre().equals(myShow.getGenre())){
                showTracks.add(musicTrack);
            }

        }

        myShow.setTracks(showTracks);

        while(super.checkDuration(myShow) == true){
            myShow = (AutoShow) super.fixDuration(myShow);
        }

        for(int i=0; i<adTracks.size(); i++) {

            if(super.checkDuration(myShow) == false) {
                showTracks.add(adTracks.get(i));
                myShow.setTracks(showTracks);
            }

        }

        showDao.create(myShow);

        return myShow;
        
    }

    public List<Track> getTracks(Integer id){

        return trackDao.getTracks(id);

    }

    public List<MusicTrack> getMusicTracks(Integer id){

        return trackDao.getMusicTracks(id);

    }

    public List<AdTrack> getAdTracks(Integer id){

        return trackDao.getAdTracks(id);

    }

    public int getTrackSize(Integer id){

        return trackDao.getTracks(id).size();

    }

    public int getMusicTrackSize(Integer id){

        return trackDao.getMusicTracks(id).size();

    }

    public int getAdTrackSize(Integer id){

        return trackDao.getAdTracks(id).size();

    }
    
}
