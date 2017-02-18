package com.radio.Daos;

public class AdTrackDao extends TrackDao{

    @Override
    public AdTrackDao getChildDao(){
        System.out.println("im in ad track dao");return new AdTrackDao();
    }

}
