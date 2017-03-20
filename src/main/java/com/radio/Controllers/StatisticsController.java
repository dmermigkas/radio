package com.radio.Controllers;

import com.radio.Factories.AdTrackFactory;
import com.radio.Factories.AdTrackFactoryImpl;
import com.radio.Factories.ShowFactory;
import com.radio.Factories.ShowFactoryImpl;
import com.radio.Models.AdTrack;
import com.radio.Models.Show;

import java.util.Calendar;
import java.util.List;

public class StatisticsController {

    AdTrackFactory adtrdao = new AdTrackFactoryImpl();
    ShowFactory showDao = new ShowFactoryImpl();

    public List<Show> showDailySchedule(){
        Calendar yesterday = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        return showDao.getShowsByDate(yesterday.getTimeInMillis(),now.getTimeInMillis());
    }

    public List<AdTrack> getAllAdTracks(){
        return adtrdao.getAdTracks();
    }

}
