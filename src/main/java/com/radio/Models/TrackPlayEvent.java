package com.radio.Models;

import java.util.Calendar;

public class TrackPlayEvent {

    private Calendar dateTime;
    private Track track;

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public Track getTrack() {
        return track == null ? null : new Track();
    }

    public void setTrack(Track track) {
        this.track = track == null ? null : new Track();
    }

}
