package com.radio.Models;

import javax.persistence.*;
import java.util.Calendar;

@Embeddable
public class TrackPlayEvent {

    @Column(name="timestamp")
    private Calendar dateTime;

    public TrackPlayEvent(){}

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

}
