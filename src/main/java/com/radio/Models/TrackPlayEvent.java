package com.radio.Models;

import java.util.Calendar;

public class TrackPlayEvent {

    private Calendar dateTime;
    private AdTrack ad;

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public AdTrack getAd() {
        return ad == null ? null : new AdTrack();
    }

    public void setAd(AdTrack ad) {
        this.ad = ad == null ? null : new AdTrack();
    }

}
