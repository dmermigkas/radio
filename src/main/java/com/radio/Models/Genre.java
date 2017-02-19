package com.radio.Models;

import javax.persistence.*;

@Entity
@Table(name="GENRES")
public class Genre {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="genre")
    private String genre;

    public Genre(){};

    public Genre(String genre){
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
