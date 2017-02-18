package com.radio.Daos;

public class MusicTrackDao extends TrackDao{

    @Override
    public MusicTrackDao getChildDao(){
        System.out.println("Music Track Dao");
        return new MusicTrackDao();
    }

}
