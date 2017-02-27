package com.radio.Controllers;

import com.radio.Models.PlaylistShow;
import com.radio.Models.Track;

public class PlaylistShowController {

    public boolean checkDuration(PlaylistShow playlist){
        int sum = 0;
        for (Track tr : playlist.getTracks()) {
            sum = sum + tr.getDuration();

        }

        if(sum > playlist.getDuration()){
            return true;
        }
        else{
            return false;
        }
    }

    public PlaylistShow fixDuration(PlaylistShow playlist){
        playlist.getTracks().remove(playlist.getTracks().size() - 1);
        return playlist;
    }

}
