package com.radio.Daos;

import com.radio.Models.AdTrack;
import com.radio.Models.MusicTrack;
import com.radio.Models.Track;

import javax.persistence.EntityManager;
import java.util.List;

public interface TrackDao extends DaoGeneric<Track,Integer>{

    List<Track> getTracks(EntityManager em,Integer id);

    List<MusicTrack> getMusicTracks(EntityManager em,Integer id);

    List<AdTrack> getAdTracks(EntityManager em, Integer id);

}
