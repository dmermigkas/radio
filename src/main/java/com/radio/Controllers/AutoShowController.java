package com.radio.Controllers;

import com.radio.Models.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AutoShowController extends ShowController{

    public AutoShow fillAutoshow(List<MusicTrack> musicTracks,List<AdTrack> adTracks,AutoShow myShow){

        List<Track> showTracks = new ArrayList<>();

        System.out.println(musicTracks);
        System.out.println(adTracks);

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

        return myShow;
        
    }
    
}
