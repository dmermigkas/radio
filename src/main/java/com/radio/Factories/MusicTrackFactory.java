package com.radio.Factories;

import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;

import java.util.List;

public interface MusicTrackFactory extends FactoryGeneric<MusicTrack,Integer>{

    List<MusicTrack> getByGenre(Genre genre);

}
