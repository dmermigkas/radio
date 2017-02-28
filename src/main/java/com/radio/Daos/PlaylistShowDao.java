package com.radio.Daos;

import com.radio.Models.PlaylistShow;

import javax.persistence.EntityManager;

public interface PlaylistShowDao extends DaoGeneric<PlaylistShow,Integer> {

    public void getDao();

   // public void merge(PlaylistShow entity,EntityManager em);

}
