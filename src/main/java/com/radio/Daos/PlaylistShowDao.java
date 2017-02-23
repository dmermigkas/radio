package com.radio.Daos;

public class PlaylistShowDao extends ShowDao{

    @Override
    public PlaylistShowDao getChildDao(){
        System.out.println("hello!");return new PlaylistShowDao();
    }

}
