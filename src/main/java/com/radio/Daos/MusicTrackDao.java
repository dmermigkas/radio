package com.radio.Daos;

import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;

import javax.persistence.EntityManager;
import java.util.List;

public interface MusicTrackDao  extends DaoGeneric<MusicTrack,Integer> {

    List<MusicTrack> getByGenre(EntityManager em,Genre genre);

}
