package com.radio.Models;

import com.radio.Daos.DaoGeneric;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TRACK_TYPE")
@Table(name="TRACKS")
public abstract class Track {

    @Id
    @Column(name="trackId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer trackId;

    @Column(name="duration")
    protected int duration;

    @Embedded
    private TrackPlayEvent trackPlayEvent;

    public void setTrackPlayEvent(TrackPlayEvent event) {
        this.trackPlayEvent = event == null ? null : new TrackPlayEvent();
    }
    public TrackPlayEvent getTrackPlayEvent() {
        return trackPlayEvent == null ? null : new TrackPlayEvent();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Integer getId() { return trackId; }

}
