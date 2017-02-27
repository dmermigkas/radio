package com.radio.Factories;

import com.radio.Models.MusicTrack;

public interface MusicTrackFactory  extends FactoryGeneric<MusicTrack,Integer>{

    public boolean removeAdmin(Integer id);

}
