package com.radio.Models;

import org.glassfish.grizzly.http.util.TimeStamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Embeddable
public class TrackPlayEvent {

    @Column(name="timestamp")
    private Long dateTime;

    public TrackPlayEvent(){
    }

    public TrackPlayEvent(Long dateTime){
        this.dateTime = dateTime;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

}
