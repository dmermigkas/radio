package com.radio.Controllers;

import com.radio.Models.Show;
import com.radio.Models.Track;

public class ShowController{

    public boolean checkDuration(Show show){

        int sum = 0;
        for (Track tr : show.getTracks()) {
            sum = sum + tr.getDuration();

        }

        if(sum > show.getDuration()){
            return true;
        }
        else{
            return false;
        }

    }

    public Show fixDuration(Show show){
        show.getTracks().remove(show.getTracks().size() - 1);
        return show;
    }

}
