package com.radio.Factories;

import com.radio.Models.MusicTrack;
import com.radio.Models.Track;

import java.util.List;

public interface TrackFactory extends FactoryGeneric<Track,Integer>{

    List<MusicTrack> getMusicTracks(Integer id);

}


