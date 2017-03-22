package com.radio.Controllers;

import com.radio.Factories.AdTrackFactory;
import com.radio.Factories.AdTrackFactoryImpl;
import com.radio.Factories.ShowFactory;
import com.radio.Factories.ShowFactoryImpl;
import com.radio.Models.AdTrack;
import com.radio.Models.Show;
import com.radio.Models.Track;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public class StatisticsController {

    AdTrackFactory adtrdao = new AdTrackFactoryImpl();
    ShowFactory showDao = new ShowFactoryImpl();

    public List<Show> showDailySchedule(){
        Calendar yesterday = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        return showDao.getTodaysShows(yesterday.getTimeInMillis(),now.getTimeInMillis());
    }

    public List<Show> getShowsByDate(Long from,Long to){

        ShowFactory showFactory = new ShowFactoryImpl();
        return showFactory.getShowsByDate(from,to);

    }

    public Long getProgramGaps(List<Show> shows){

        Long sum = 0L;
        System.out.println(shows);
        for (int i=0; i<shows.size()-1; i++){

            Show currShow = (Show) shows.get(i);
            Show nextShow = (Show) shows.get(i+1);

            sum = sum + abs(currShow.getPlayDateTime() - nextShow.getPlayDateTime());

        }

        return sum;

    }

    public Long getShowGaps(Show show){

        Long sum = 0L;
        List tracks = show.getTracks();
        System.out.println(tracks);
        for (int i=0; i<tracks.size()-1; i++){

            Track currTrack = (Track) tracks.get(i);
            Track nextTrack = (Track) tracks.get(i+1);
            System.out.println(currTrack.getTrackPlayEvent());
            System.out.println(nextTrack.getTrackPlayEvent().getDateTime());
            sum = sum + abs(currTrack.getTrackPlayEvent().getDateTime() - nextTrack.getTrackPlayEvent().getDateTime());

        }

        return sum;

    }

    public Boolean satisfiesPolicies(int times,AdTrack a){

        return (a.getPolicies().getMinTimes() <= times && a.getPolicies().getMaxTimes() >= times) ? true : false;

    }

    public List<AdTrack> getAllAdTracks(){
        return adtrdao.getAdTracks();
    }

}
