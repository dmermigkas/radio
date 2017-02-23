package com.radio.Factories;

import com.radio.Daos.DaoFactory;
import com.radio.Daos.MusicTrackDao;
import com.radio.Daos.ShowDao;
import com.radio.Daos.TrackDao;
import com.radio.Models.*;

public class MusicTrackFactory {

    private MusicTrackDao m;

    private TrackDao dao;

    public void getMusic(MusicTrack d){
        d.getDao();
    }

    //public <T> T getDao(){
//        return dao.getDao();
//    }

}
