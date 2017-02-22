package com.radio.Models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="TRACKPLAYEVENTS")
public class TrackPlayEvent {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="timestamp")
    private Calendar dateTime;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name="trackid") //problem here: we have id for child classes only
//    @Embedded
//    private Track musicTrack = new MusicTrack("test","test artist",new Genre("test"),1990);
//
//    @Embedded
//    private Track ad = new AdTrack();

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    //
//    public String getMusicTrack() {
//        return musicTrack.getTitle();
//        //return track == null ? null : new Track();
//    }
//
//    public void setTrack(Track track) {
//        //this.track = track == null ? null : new Track();
//    }

}
