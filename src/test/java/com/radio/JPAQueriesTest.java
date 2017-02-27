package com.radio;

import com.radio.Models.Track;
import com.radio.Utilities.JPAUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by lotv on 27/02/2017.
 */
public class JPAQueriesTest {

    private Initializer dataHelper;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.prepareData();
    }

    @SuppressWarnings("all")
    @Test
    public void simpleQuery() {
        int expectedMusicTrackNumber = 1;
        EntityManager em = JPAUtil.getCurrentEntityManager();
        Query query = em.createQuery("select musictrack from MusicTrack musictrack");
        List<Track> results = query.getResultList();
        Assert.assertEquals(expectedMusicTrackNumber, results.size());
    }
}
