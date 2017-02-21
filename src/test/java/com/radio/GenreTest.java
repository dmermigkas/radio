package com.radio;

import com.radio.Models.Genre;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lotv on 21/02/2017.
 */
public class GenreTest {

    @Test
    public void genreConstructor() {
        Genre genre = new Genre("genrename");
        Assert.assertEquals("genrename", genre.getGenre());
    }

    @Test
    public void genreSetter() {
        Genre genre = new Genre("genrename");
        genre.setGenre("newgenre");
        Assert.assertEquals("newgenre", genre.getGenre());
    }
}
