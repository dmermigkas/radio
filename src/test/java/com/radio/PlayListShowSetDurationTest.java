package com.radio;

import com.radio.Controllers.PlaylistShowController;
import com.radio.Controllers.ShowController;
import com.radio.Models.MusicTrack;
import com.radio.Models.PlaylistShow;
import com.radio.Models.Show;
import com.radio.Models.Track;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lotv on 01/03/2017.
 */
public class PlayListShowSetDurationTest {

    @Test
    public void PlayListShowControllerTest(){

        ShowController controller = new PlaylistShowController();
        Track track = new MusicTrack();
        track.setDuration(100);
        PlaylistShow show = new PlaylistShow();
        show.setDuration(99);
        show.addTrackToList(track);
        Assert.assertTrue(controller.checkDuration(show));
        show.setDuration(101);
        Assert.assertFalse(controller.checkDuration(show));

        Track track1 = new MusicTrack();
        track1.setDuration(2);
        show.addTrackToList(track1);
        Assert.assertTrue(controller.checkDuration(show));
        controller.fixDuration(show);
        Assert.assertFalse(controller.checkDuration(show));

    }
}
