package com.radio.Models;

public class AutoShow extends Show{

    private Genre genre;
    private Policies policies = new Policies();

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Policies getPolicies() {
        return policies;
    }

    public void setPolicies(Policies policies) {
        this.policies = policies;
    }
}
