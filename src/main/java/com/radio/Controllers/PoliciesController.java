package com.radio.Controllers;

import com.radio.Factories.TrackFactory;
import com.radio.Factories.TrackFactoryImpl;
import com.radio.Models.AdTrack;
import com.radio.Models.Show;

import java.util.*;

public class PoliciesController {

    public Map getUniqueAdTracks(List<Show> allshows){

        TrackFactory trackFactory = new TrackFactoryImpl();

        List<AdTrack> allShowsAdtracks = new ArrayList<>();

        for (Show pl : allshows) {

            for (AdTrack a : trackFactory.getAdTracks(pl.getShowId())) {
                allShowsAdtracks.add(a);
            }

        }

        List<AdTrack> allShowsAdtracksCopy = new ArrayList<>(allShowsAdtracks);

        Set<AdTrack> uniqueAds = new HashSet<>();

        int counter = 0;

        for (AdTrack a : allShowsAdtracks) {

            for (AdTrack b : allShowsAdtracksCopy) {
                if(a.equals(b)){

                    counter++;

                }
                else{
                    uniqueAds.add(b);
                    break;
                }

            }
        }

        HashMap hm = new HashMap();

        for (AdTrack s : uniqueAds) {

            if(s.getBrand().equals("jumbo")){
                hm.put(s, 3);
            }
            else{
                hm.put(s, 1);
            }

        }

        return hm;

    }

}
