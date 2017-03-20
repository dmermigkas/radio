package com.radio.Factories;

import com.radio.Models.AdTrack;

import java.util.List;

public interface AdTrackFactory  extends FactoryGeneric<AdTrack,Integer>{

    List<AdTrack> getAdTracks();

}
