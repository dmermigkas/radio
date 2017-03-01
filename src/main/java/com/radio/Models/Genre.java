package com.radio.Models;

import javax.persistence.*;

@Entity
@Table(name="GENRES")
public class Genre {

    @Id
    @Column(name="genreid")
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

    @Override
    public boolean equals(Object other) {
        if ( other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (! (other instanceof Genre)) {
            return false;
        }

        Genre musicTrack = (Genre) other;
        if (! (getGenre() == null ? musicTrack.getGenre()
                == null : getGenre().equals(musicTrack.getGenre()))) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return genre == null ? 0 : genre.hashCode();
    }

}
