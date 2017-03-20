package com.radio.Daos;

import com.radio.Models.AdTrack;

import javax.persistence.EntityManager;
import java.util.List;

public interface AdTrackDao  extends DaoGeneric<AdTrack,Integer> {

    List<AdTrack> getAdTracks(EntityManager em);

}
