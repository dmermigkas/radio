package com.radio.Daos;

public class PlaylistShowDao extends ShowDao{

    @Override
    public PlaylistShowDao getChildDao(){
        return new PlaylistShowDao();
    }

}
