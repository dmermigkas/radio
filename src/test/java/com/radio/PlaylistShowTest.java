package com.radio;

import com.radio.Models.EmailAddress;
import com.radio.Models.PlaylistShow;
import com.radio.Models.Producer;
import org.junit.Before;

import java.util.Calendar;

/**
 * Created by agk on 26/02/2017.
 */
public class PlaylistShowTest {
    PlaylistShow playlistShow;
    Calendar playDateTime;
    Producer producer;

    @Before
    public void PlaylistShowSetup {
        Calendar playDateTime = Calendar.getInstance();
        Producer producer = new Producer("firstName", "lastName", new EmailAddress("testing@email.org"));
        playlistShow =

    }
}

