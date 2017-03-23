package com.radio.Resources;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.AdTrack;
import com.radio.Models.AutoShow;
import com.radio.Models.MusicTrack;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="AutoShowInfo")
public class AutoShowInfo {

    FactoryGenericImpl musicTrackFactory;

    private Integer id;
    private List<MusicTrack> m;
    private List<AdTrack> a;
    private AutoShow auto;

    public AutoShowInfo(){}

    public AutoShowInfo(List<MusicTrack> m, List<AdTrack> a, AutoShow auto) {
        this.m = m;
        this.a = a;
        this.auto = auto;
    }

    public List<MusicTrack> getM() {
        return m;
    }

    public void setM(List<MusicTrack> m) {
        this.m = m;
    }

    public List<AdTrack> getA() {
        return a;
    }

    public void setA(List<AdTrack> a) {
        this.a = a;
    }

    public AutoShow getAuto() {
        return auto;
    }

    public void setAuto(AutoShow auto) {
        this.auto = auto;
    }
}
