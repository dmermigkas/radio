package com.radio.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Calendar;

@Embeddable
public class PlayBackZone {

    @Column(name="fromtime")
    private Calendar fromTime;

    @Column(name="totime")
    private Calendar toTime;

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

    public PlayBackZone getPlaybackZone(){
        return new PlayBackZone(this.fromTime, this.toTime);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof PlayBackZone)) {
            return false;
        }

        PlayBackZone playbackzone = (PlayBackZone) other;
        return playbackzone == null
                ? playbackzone.getPlaybackZone() == null
                : playbackzone.equals(playbackzone.getPlaybackZone());
    }


    @Override
    public int hashCode() {
        return new PlayBackZone(this.fromTime, this.toTime) == null ? 0 : new PlayBackZone(this.fromTime, this.toTime).hashCode();
    }
}
