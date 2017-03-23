package com.radio.Resources;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.PlaylistShow;
import com.radio.Models.Producer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PlaylistShowInfo")
public class PlaylistShowInfo {

    FactoryGenericImpl musicTrackFactory;

    private String name;
    private Producer producer;
    private int duration;
    private Long playDateTime;

    public PlaylistShowInfo(){}

    public PlaylistShowInfo(String name, Producer producer, int duration, Long playDateTime) {
        this.name = name;
        this.producer = producer;
        this.duration = duration;
        this.playDateTime = playDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getPlayDateTime() {
        return playDateTime;
    }

    public void setPlayDateTime(Long playDateTime) {
        this.playDateTime = playDateTime;
    }

    public PlaylistShow getplaylistshow(Integer id2) throws Exception{ //todo check if factory is used properly

        PlaylistShow musicTrack = null;
        musicTrackFactory = new FactoryGenericImpl(PlaylistShow.class);

        if (id2 != null) {
            try{
                musicTrack = (PlaylistShow)musicTrackFactory.get(id2);
            }
            catch (Exception e){
                throw e;
            }

        } else {
            musicTrack = new PlaylistShow();
        }

        musicTrack.setProducer(producer);
        musicTrack.setDuration(duration);
        musicTrack.setName(name);
        musicTrack.setPlayDateTime(playDateTime);

        return musicTrack;
    }

}
