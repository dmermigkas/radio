package com.radio.Models;

import com.radio.Daos.DaoFactory;

import java.util.HashSet;
import java.util.Set;

public class Producer {

    private Integer id;
    private DaoFactory dao;
    private String firstName;
    private String lastName;
    private EmailAddress email;

    private Set<AutoShow> autoShows = new HashSet<>();
    private Set<PlaylistShow> playlistShows = new HashSet<>();

    public Producer(){};

    public Producer(DaoFactory dao, String firstName, String lastName, EmailAddress email){

        this.dao = dao;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public <T> T getDao(){
        return dao.getDao();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public void setEmail(EmailAddress email) {
        this.email = email;
    }

    public Set<AutoShow> getAutoShows() {
        System.out.println(autoShows);
        return autoShows;
    }

    public void setAutoShows(Set<AutoShow> autoShows) {
        this.autoShows = autoShows;
    }

    public Set<PlaylistShow> getPlaylistShows() {
        return playlistShows;
    }

    public void setPlaylistShows(Set<PlaylistShow> playlistShows) {
        this.playlistShows = playlistShows;
    }

    public void addAutoShow(AutoShow show){
        this.autoShows.add(show);
    }

    public void removeAutoShow(AutoShow show){
        this.autoShows.remove(show);
    }

    public void addPlaylistShow(PlaylistShow show){
        this.playlistShows.add(show);
    }

    public void removePlaylistShow(PlaylistShow show){
        this.playlistShows.remove(show);
    }

}
