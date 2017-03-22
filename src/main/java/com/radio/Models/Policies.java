package com.radio.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Policies {

    @Column(name="maxtimes")
    private int maxTimes;

    @Column(name="mintimes")
    private int minTimes;

    public Policies(){}

    public Policies(int minTimes,int maxTimes){
        this.maxTimes = maxTimes;
        this.minTimes = minTimes;
    }

    public int getMaxTimes() {
        return maxTimes;
    }

    public void setMaxTimes(int maxTimes) {
        this.maxTimes = maxTimes;
    }

    public int getMinTimes() {
        return minTimes;
    }

    public void setMinTimes(int minTimes) {
        this.minTimes = minTimes;
    }

}