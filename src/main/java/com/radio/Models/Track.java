package com.radio.Models;

import com.radio.Daos.DaoGeneric;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

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
    protected TrackPlayEvent trackPlayEvent;

    @Embedded
    protected Policies policies;

    public void setTrackPlayEvent(TrackPlayEvent event) {
        this.trackPlayEvent = event == null ? null : new TrackPlayEvent();
    }
    public TrackPlayEvent getTrackPlayEvent() {
        return trackPlayEvent == null ? null : new TrackPlayEvent(trackPlayEvent.getDateTime());
    }

    public void setPolicies(Policies policies) {
        this.policies = policies == null ? null : new Policies();
    }
    public Policies getPolicies() {
        return policies == null ? null : new Policies(policies.getMinTimes(),policies.getMaxTimes());
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Integer getId() { return trackId; }

    public boolean equals(Object other) {

        if ( other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (! (other instanceof Track)) {
            return false;
        }

        Track track0 = (Track) other;
        if (! (getTrackPlayEvent().getDateTime() == null ? track0.getTrackPlayEvent().getDateTime()
                == null : getTrackPlayEvent().getDateTime().equals(track0.getTrackPlayEvent().getDateTime()))) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return trackPlayEvent == null ? 0 : 0;
    }

}
