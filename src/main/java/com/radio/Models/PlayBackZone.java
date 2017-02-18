package com.radio.Models;

import java.util.Calendar;

public class PlayBackZone {

    private Calendar fromTime;
    private Calendar toTime;

    public PlayBackZone(){};

    public PlayBackZone(Calendar fromTime,Calendar toTime){
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Calendar getFromTime() {
        return fromTime;
    }

    public void setFromTime(Calendar fromTime) {
        this.fromTime = fromTime;
    }

    public Calendar getToTime() {
        return toTime;
    }

    public void setToTime(Calendar toTime) {
        this.toTime = toTime;
    }
}
